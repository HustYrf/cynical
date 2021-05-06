package BestTime2BuyAndSellStockII;

import java.awt.*;

public class drawb extends EasyGraphics {


    @Override
    public void run() {
        makeWindow("Q4", 300, 300);
        for (int x = 0; x < 300; x += 30) {
            drawLine(x, 300, 0, x, Color.BLACK);
        }
    }



    public static void main(String[] args) {
        launch("false");
    }


}
