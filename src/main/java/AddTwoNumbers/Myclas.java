package AddTwoNumbers;

/**
 * @author wuyanYRF
 */
public class Myclas {
    public static double cS(int hour, double rate) {
        System.out.println("A");
        return hour * rate;
    }

    public static int cS(int rate, int hour) {
        System.out.println("B");
        return hour * rate;
    }

    public static double cS(double hour, int rate) {
        System.out.println("C");

        return hour * rate;
    }

    public static double cS(double rate, double hour) {
        System.out.println("D");
        return hour * rate;
    }

    public static void main(String[] args) {
        System.out.println(cS(10, 5.0));
    }
}
