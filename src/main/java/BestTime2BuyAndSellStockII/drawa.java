package BestTime2BuyAndSellStockII;

import java.awt.*;

public class drawa extends EasyGraphics {


    @Override
    public void run() {
        makeWindow("Q5", 300, 300);
        for (int x = 0; x < 300; x += 10) {
            drawLine(x, 0, 300, x, Color.BLACK);
            drawLine(x, 300, 0, x, Color.BLACK);
            drawLine(x, 300, 300, 300 - x, Color.BLACK);
            drawLine(0, 300 - x, x, 0, Color.BLACK);
        }
    }

    public static void main(String[] args) {
        launch("false");
    }


}
