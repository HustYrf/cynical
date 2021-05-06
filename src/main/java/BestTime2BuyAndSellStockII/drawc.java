package BestTime2BuyAndSellStockII;

import java.awt.*;

public class drawc extends EasyGraphics {


    @Override
    public void run() {
        makeWindow("Q1", 300, 300);
        drawLine(0, 0, 300, 300, Color.GREEN);
        drawLine(300, 0, 0, 300, Color.GREEN);
        drawLine(150, 0, 155, 300, Color.blue);
        drawLine(0, 150, 300, 150, Color.blue);
    }

    public static void main(String[] args) {
        launch("true");
    }


}
