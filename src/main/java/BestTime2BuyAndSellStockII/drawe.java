package BestTime2BuyAndSellStockII;

import java.awt.*;

public class drawe extends EasyGraphics {


    @Override
    public void run() {
        makeWindow("Q2", 300, 300);
        int endX = 0;
        int endY = 300;
        for (int i = 0; i < 15; i++) {
            drawLine(0, 0, endX, endY, Color.GRAY);
            endX += 20;
            endY -= 20;
        }
    }

    public static void main(String[] args) {
        launch("false");
    }


}
