package BestTime2BuyAndSellStockII;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class drawd extends EasyGraphics {



    @Override
    public void run() {
        Map<Integer,Color> colorMap = new HashMap<Integer,Color>();
        colorMap.put(0,Color.GREEN);
        colorMap.put(1,Color.MAGENTA);
        colorMap.put(2,Color.red);
        colorMap.put(3,Color.BLUE);
        colorMap.put(4,Color.yellow);
        colorMap.put(5,Color.PINK);
        makeWindow("Q6", 300, 300);
        int radius = 10;
        for (int x = 0; x < 12; x++) {
            drawCircle(150,150,radius,colorMap.get(x%6));
            radius+=10;
        }
    }

    public static void main(String[] args) {

        launch("false");
    }


}
