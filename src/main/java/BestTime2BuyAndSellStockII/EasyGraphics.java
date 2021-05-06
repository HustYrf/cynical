package BestTime2BuyAndSellStockII;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;


public abstract class EasyGraphics extends JFrame {


    private static final Integer CIRCLE_TYPE = 2;
    private static final Integer LINE_TYPE = 4;

    private ArrayList<Integer> figTypes = new ArrayList<>();


    private int figCount = 0;


    private static boolean launchedCalled = false;

    private static EGGui gui;

    public static void launch(String args) {
        launchedCalled = true;
        EGCommon.startup();
        EasyGraphics app = getApp();
        gui = new EGGui(app, args);
        SwingUtilities.invokeLater(gui);
        EGCommon.latch.awaitStartup();
        EGRunner runner = new EGRunner(app);
        Thread thread = new Thread(runner);
        thread.start();
    }


    public abstract void run();


    public int drawCircle(int centerX, int centerY, int radius, Color color1) {
        return makeCircle(centerX, centerY, radius, false, color1);
    }


    public int drawLine(int startX, int startY, int endX, int endY, Color color1) {
        return makeLine(startX, startY, endX, endY, false, color1);
    }


    public void makeWindow(String title, int width, int height) {
//        checkLaunched();
//        checkPositive(width, "width");
//        checkPositive(height, "height");
        EGWindowStep step = new EGWindowStep(gui, title, width, height);
        addStep(step);
    }


    public void println(String msg) {
        checkLaunched();
        EGPrintStep step = new EGPrintStep(msg + "\n");
        addStep(step);
    }


    private void addStep(EGStep step) {
        EGCommon.stepBuffer.addStep(step);
    }


    private void checkLaunched() {
        if (!launchedCalled)
            EGCommon.fatalError("EasyGraphics method launch must be called from main!");
    }


    private boolean checkPositive(int param, String name) {
        if (param < 0) {
            String msg = "Parameter " + name + " must be positive!";
            EGErrorStep step = new EGErrorStep(msg);
            addStep(step);
            return false;
        }

        return true;
    }


    private static EasyGraphics getApp() {
        EasyGraphics obj = null;
        String className = null;

        try {
            StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();
            int pos = 0;
            boolean found = false;
            while (!found && (pos < stackTraces.length)) {
                StackTraceElement element = stackTraces[pos];
                className = element.getClassName();
                String methodName = element.getMethodName();

                if (methodName.equals("main")) {
                    EGCommon.logMessage("Main class: " + className);

                    ClassLoader loader = ClassLoader.getSystemClassLoader();
                    Class theClass = Class.forName(className, false, loader);
                    Class sc = theClass.getSuperclass();
                    String scName = sc.getSimpleName();

                    if (scName.equals("EasyGraphics")) {
                        obj = (EasyGraphics) theClass.newInstance();
                        found = true;
                    } else {
                        EGCommon.fatalError("Main class is not a subclass (extends) of EasyGraphics");
                    }
                } else
                    pos++;
            }
        } catch (ClassNotFoundException e) {
            EGCommon.fatalError("Unable to load class: " + e.toString());
        } catch (InstantiationException e) {
            EGCommon.fatalError("Unable to instantiate class: " + e.toString());
        } catch (IllegalAccessException e) {
            EGCommon.fatalError("Illegal access: " + e.toString());
        }

        if (obj == null)
            EGCommon.fatalError("Main class not found.");

        return obj;
    }


    private int makeCircle(int centerX, int centerY, int radius,
                           boolean fill, Color color1) {
        checkLaunched();
        checkPositive(radius, "radius");
        EGCircle circle = new EGCircle(centerX, centerY, radius);
        circle.setColor(color1);
        circle.setFill(fill);
        EGMakeStep step = new EGMakeStep(circle);
        addStep(step);
        return nextFigId(CIRCLE_TYPE);
    }


    private int makeLine(int startX, int startY,
                         int endX, int endY,
                         boolean fill, Color color1) {
        checkLaunched();
        EGLine line = new EGLine(startX, startY, endX, endY);
        line.setColor(color1);
        line.setFill(fill);
        EGMakeStep step = new EGMakeStep(line);
        addStep(step);
        return nextFigId(LINE_TYPE);
    }


    private int nextFigId(Integer figType) {
        figTypes.add(figType);
        figCount++;
        return figCount - 1;
    }

}


class EGBuffer {

    private ArrayDeque<ArrayDeque<EGStep>> buffer;
    private ArrayDeque<EGStep> inQueue;
    private ArrayDeque<EGStep> outQueue = null;

    private boolean windowVisible = false;


    public EGBuffer() {
        buffer = new ArrayDeque<>(EGCommon.MAX_QUEUES);
        inQueue = new ArrayDeque<>(EGCommon.INIT_STEPS);
        outQueue = new ArrayDeque<>();
        windowVisible = false;
    }


    public synchronized boolean addQueue(ArrayDeque<EGStep> q) {
        if (buffer.size() >= EGCommon.MAX_QUEUES - 1)
            return false;
        else {
            buffer.offer(q);
            return true;
        }
    }

    public synchronized ArrayDeque<EGStep> getQueue() {
        ArrayDeque<EGStep> q = null;
        int size = buffer.size();
        if (size > 0)
            q = buffer.poll();
        return q;
    }

    public void addStep(EGStep step) {
        if (!windowVisible) {
            if (step instanceof EGWindowStep)
                windowVisible = true;
            else
                EGCommon.fatalError("Method makeWindow must be invoked before all other EasyGraphics methods!");
        }

        if (inQueue.size() >= EGCommon.MAX_STEPS) {
            addQueue();
            inQueue = new ArrayDeque<>(EGCommon.INIT_STEPS);
        }
        inQueue.offer(step);
    }


    public void addQueue() {
        boolean success = addQueue(inQueue);
        while (!success) {
            try {
                Thread.sleep(EGCommon.WAIT_TIME);
            } catch (InterruptedException e) {
                EGCommon.logMessage("Interrupt in EGBuffer.addQueue().");
            }
            success = addQueue(inQueue);
        }
    }


    public EGStep getStep() {
        EGStep step = null;
        if (outQueue == null)
            outQueue = EGCommon.stepBuffer.getQueue();
        if (outQueue != null)
            step = (EGStep) outQueue.poll();
        if (step == null)
            outQueue = null;
        return step;
    }

}


class EGCanvas extends JPanel implements ActionListener {

    public static int minX = 0;
    public static int minY = 0;
    public static int maxX = EGCommon.STD_WIDTH;
    public static int maxY = EGCommon.STD_HEIGHT;

    private static int width = EGCommon.STD_WIDTH;
    private static int height = EGCommon.STD_HEIGHT;
    ;

    private static Color background = EGCommon.STD_BACKGROUND;
    private static int speed = EGCommon.STD_SPEED;

    private static Timer timer = null;
    private static long delay = speedToDelay(speed);
    private static long previous = System.nanoTime();

    private static ArrayList<EGFigure> figList = new ArrayList<>();
    private EGStep currStep = null;


    public EGCanvas() {
        setBackground(background);
        initRect();
        previous = System.nanoTime();
        timer = new Timer(0, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paintComponent(g);
        setBackground(background);

        for (EGFigure f : figList) {
            f.draw(g);
        }
    }


    public void actionPerformed(ActionEvent e) {

        if (keepWaiting())
            return;

        initRect();

        if (currStep == null)
            currStep = EGCommon.stepBuffer.getStep();
        if (currStep == null) {
            return;
        }
        boolean finishedCurrent = currStep.execute();

        while (finishedCurrent) {
            currStep = EGCommon.stepBuffer.getStep();
            if (currStep == null)
                finishedCurrent = false;
            else if (currStep.continueStep())
                finishedCurrent = currStep.execute();
            else
                finishedCurrent = false;
        }


        repaint(minX, minY, maxX - minX, maxY - minY);

    }

    public static void addFig(EGFigure figure) {
        figList.add(figure);
    }

    public void setCanvasSize(int width, int height) {
        this.width = width;
        this.height = height;
        Dimension dim = new Dimension(width, height);
        setPreferredSize(dim);
        setMinimumSize(dim);
        setMaximumSize(dim);
    }


    public static void setUpdateRect(int minX1, int minY1, int maxX1, int maxY1) {
        minX = Math.min(minX, minX1) - 1;
        minY = Math.min(minY, minY1) - 1;
        maxX = Math.max(maxX, maxX1) + 1;
        maxY = Math.max(maxY, maxY1) + 1;
        if (minX < 0)
            minX = 0;
        if (minY < 0)
            minY = 0;
        if (maxX > width)
            maxX = width;
        if (maxY > height)
            maxY = height;
    }


    public static void initRect() {
        minX = width;
        minY = height;
        maxX = 0;
        maxY = 0;
    }

    private boolean keepWaiting() {
        if (delay == 0)
            return false;

        long now = System.nanoTime();

        if (previous + delay > now) {
            return true;
        }

        previous = now;
        return false;
    }


    private static long speedToDelay(int speed) {
        long nano = 1000000;
        return ((speed * -1) + 10) * EGCommon.STD_SPEED_SLOWDOWN * nano;
    }

}


class EGCircle extends EGFigure {

    private int radius;


    public EGCircle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }


    public void draw(Graphics g) {
        if (visible) {
            super.draw(g);
            if (fill)
                g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
            else
                g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        }
    }



    public int minX() {
        return x - radius;
    }


    public int minY() {
        return y - radius;
    }


    public int maxX() {
        return x + radius;
    }


    public int maxY() {
        return y + radius;
    }


    public EGFigure copy() {
        EGCircle copy = new EGCircle(x, y, radius);
        copy.copyColor(color);
        copy.setFill(fill);
        copy.setVisible(visible);
        return copy;
    }
}


class EGCommon {

    public static final boolean DEBUG = false;
    public static final boolean EXIT_ON_FINISH = false;
    public static final int STD_WIDTH = 800;
    public static final int STD_HEIGHT = 800;
    public static final Color STD_BACKGROUND = Color.WHITE;
    public static final Color STD_COLOR = Color.BLACK;
    public static final int STD_SPEED = 10;
    public static final int STD_SPEED_SLOWDOWN = 1;
    public static final int INIT_STEPS = 500;
    public static final int MAX_STEPS = 5000;
    public static final int MAX_QUEUES = 10;
    public static final int WAIT_TIME = 500;
    public static EGBuffer stepBuffer;
    public static EGLatch latch = new EGLatch();
    private static long startTime;
    public static void logMessage(String msg) {
        if (DEBUG)
            System.out.println(msg);
    }

    public static void fatalError(String msg) {
        System.out.println("Fatal error: " + msg);
        System.exit(-1);
    }


    public static void startup() {
        startTime = System.currentTimeMillis();
        stepBuffer = new EGBuffer();
    }


    public static void finish() {
        if (EGCommon.DEBUG) {
            long duration = System.currentTimeMillis() - startTime;
            System.out.println("Duration: " + duration / 1000.0 + "s.");
        }

        if (EGCommon.EXIT_ON_FINISH)
            System.exit(0);
        else
            System.out.println("");
    }

}


class EGErrorStep extends EGStep {

    private String msg;


    public EGErrorStep(String msg) {
        super();
        this.msg = msg;
    }


    public boolean continueStep() {
        return false;
    }


    public boolean execute() {
        EGCommon.fatalError(msg);
        return true;
    }

}


abstract class EGFigure {

    protected int x;
    protected int y;
    protected Color color;
    protected boolean fill;

    protected boolean visible;
    protected boolean touched;


    public EGFigure(int x, int y) {
        this.x = x;
        this.y = y;
        color = EGCommon.STD_COLOR;
        fill = false;
        visible = true;
        touched = false;
    }


    public void draw(Graphics g) {
        g.setColor(color);
        touched = false;
    }


    public void setX(int x) {
        this.x = x;
    }


    public int getX() {
        return x;
    }


    public void setColor(Color color) {
        this.color = color;
    }


    public void setFill(boolean fill) {
        this.fill = fill;
    }


    public void setVisible(boolean visible) {
        this.visible = visible;
    }


    public abstract int minX();

    public abstract int minY();

    public abstract int maxX();

    public abstract int maxY();



    public abstract EGFigure copy();

    public void copyColor(Color color) {
        setColor(new Color(color.getRed(), color.getGreen(), color.getBlue()));
    }

    public void touch() {
        touched = true;
    }
}


class EGFinishStep extends EGStep {

    public EGFinishStep() {
        super();
    }


    public boolean continueStep() {
        return false;
    }


    public boolean execute() {
        EGCommon.latch.animationFinished();
        finished = true;
        return finished;
    }
}

class EGGui implements Runnable {

    private final String STD_TITLE = "EasyGraphics";
    ;

    private EasyGraphics app;

    private EGCanvas canvas;
    private String response;
    private String flag;

    public EGGui(EasyGraphics app, String args) {
        this.app = app;
        this.flag = args;
    }


    public void run() {
        makeGUI();
        EGCommon.latch.startupFinished();
    }


    public void show(String title, int width, int height) {
        canvas.setCanvasSize(width, height);
        app.setTitle(title);
        app.pack();
        app.setResizable(false);
        app.setVisible(true);
    }

    private void makeGUI() {
        app.setTitle(STD_TITLE);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel centerPanel = new JPanel();
        JPanel canvasPanel = new JPanel(new GridLayout(1, 1, 1, 1));
        if (this.flag.equals("true")) {
            canvasPanel.setBackground(Color.red);
            canvasPanel.setBorder(new MatteBorder(1, 1, 1, 1, Color.red));
        }
        canvas = new EGCanvas();
        canvasPanel.add(canvas);
        centerPanel.add(canvasPanel);
        app.add(centerPanel, BorderLayout.CENTER);
    }
}


class EGLatch {

    private static final int PAUSE = 100;

    private CountDownLatch animationLatch = null;

    private CountDownLatch userLatch = null;

    private CountDownLatch startupLatch = null;


    public void awaitStartup() {
        startupLatch = new CountDownLatch(1);
        try {
            startupLatch.await();
        } catch (InterruptedException e) {
            EGCommon.logMessage("Interrupt in EGLatch.awaitStartup().");
        }
    }


    public void startupFinished() {

        while (startupLatch == null)
            pause(PAUSE);

        startupLatch.countDown();
        startupLatch = null;
    }


    public void awaitAnimation() {
        animationLatch = new CountDownLatch(1);
        try {
            animationLatch.await();
        } catch (InterruptedException e) {
            EGCommon.logMessage("Interrupt in EGLatch.awaitAnimation().");
        }
    }


    public void animationFinished() {

        while (animationLatch == null)
            pause(PAUSE);

        animationLatch.countDown();
        animationLatch = null;
    }


    private void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            EGCommon.logMessage("EGLatch.pause() interrupted.");
        }
    }

}


class EGLine extends EGFigure {

    private int width;
    private int height;


    public EGLine(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.width = x2 - x1;
        this.height = y2 - y1;
    }


    public void draw(Graphics g) {
        if (visible) {
            super.draw(g);
            g.drawLine(x, y, x + width, y + height);
        }
    }


    public int minX() {
        return Math.min(x, x + width);
    }


    public int minY() {
        return Math.min(y, y + height);
    }


    public int maxX() {
        return Math.max(x, x + width);
    }


    public int maxY() {
        return Math.max(y, y + height);
    }


    public EGFigure copy() {
        EGLine copy = new EGLine(x, y, x + width, y + height);
        copy.copyColor(color);
        copy.setFill(fill);
        copy.setVisible(visible);
        return copy;
    }

}


class EGMakeStep extends EGStep {

    private EGFigure fig;


    public EGMakeStep(EGFigure fig) {
        super();
        this.fig = fig;
    }


    public boolean continueStep() {
        return false;
    }


    public boolean execute() {
        EGFigure copyFig = fig.copy();
        EGCanvas.addFig(copyFig);


        if (copyFig instanceof EGText) {
            EGText txt = (EGText) copyFig;
            JLabel label = new JLabel();
            FontMetrics metrics = label.getFontMetrics(txt.getFont());
            txt.setWidth(metrics.stringWidth(txt.getStr()));
            txt.setHeight(metrics.getHeight());
        }


        EGCanvas.setUpdateRect(copyFig.minX(), copyFig.minY(), copyFig.maxX(), copyFig.maxY());

        copyFig.touch();
        copyFig.setVisible(true);

        fig = null;

        finished = true;
        return finished;
    }

}


class EGPrintStep extends EGStep {

    private String msg;


    public EGPrintStep(String msg) {
        super();
        this.msg = msg;
    }


    public boolean continueStep() {
        return false;
    }

    public boolean execute() {
        System.out.print(msg);

        finished = true;
        return finished;
    }

}


class EGRunner implements Runnable {

    private EasyGraphics app;


    public EGRunner(EasyGraphics app) {
        this.app = app;
    }


    public void run() {
        app.run();

        EGCommon.stepBuffer.addStep(new EGFinishStep());
        EGCommon.stepBuffer.addQueue();
        EGCommon.latch.awaitAnimation();
        EGCommon.finish();
    }

}


abstract class EGStep {
    protected boolean finished;
    public EGStep() {
        finished = false;
    }
    public abstract boolean continueStep();
    public abstract boolean execute();

}


class EGText extends EGFigure {

    private String str;
    private Font font;
    private int width;
    private int height;


    public EGText(int x, int y, String str, Font font) {
        super(x, y);
        this.str = str;
        this.font = font;
    }


    public void draw(Graphics g) {
        if (visible) {
            super.draw(g);
            g.setFont(font);
            g.drawString(str, x, y);
        }
    }


    public String getStr() {
        return str;
    }

    public Font getFont() {
        return font;
    }

    public int minX() {
        return x;
    }

    public int minY() {
        return y - height;
    }

    public int maxX() {
        return x + width;
    }

    public int maxY() {

        return y + height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public EGFigure copy() {
        Font fontCopy = new Font(font.getName(), Font.PLAIN, font.getSize());
        EGText copy = new EGText(x, y, str, fontCopy);
        copy.copyColor(color);
        copy.setFill(fill);
        copy.setVisible(visible);
        return copy;
    }
}

class EGWindowStep extends EGStep {
    private EGGui gui;
    private String title;
    private int width;
    private int height;
    public EGWindowStep(EGGui gui, String title, int width, int height) {
        super();
        this.title = title;
        this.width = width;
        this.height = height;
        this.gui = gui;
    }
    public boolean continueStep() {
        return false;
    }

    public boolean execute() {
        gui.show(title, width, height);
        finished = true;
        return finished;
    }
}