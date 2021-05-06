package BestTime2BuyAndSellStockII;

import java.awt.*;

public class drawf extends EasyGraphics {


    @Override
    public void run() {
        makeWindow("Q3", 300, 300);
        int endX = 0;
        int endY = 300;
        for (int i = 0; i < 15; i++) {
            drawLine(0, 0, endX, endY, Color.GRAY);
            endX += 20;
            endY -= 20;
        }

        int endX1 = 0;
        int endY1 = 0;
        for (int i = 0; i < 15; i++) {
            drawLine(0, 300, endX1, endY1, Color.GRAY);
            endX1 += 20;
            endY1 += 20;
        }


        int endX2 = 300;
        int endY2 = 300;
        for (int i = 0; i < 15; i++) {
            drawLine(300, 0, endX2, endY2, Color.GRAY);
            endX2 -= 20;
            endY2 -= 20;
        }


        int endX3 = 0;
        int endY3 = 300;
        for (int i = 0; i < 15; i++) {
            drawLine(300, 300, endX3, endY3, Color.GRAY);
            endX3 += 20;
            endY3 -= 20;
        }
    }

    public static void main(String[] args) {
        launch("false");
    }


}
