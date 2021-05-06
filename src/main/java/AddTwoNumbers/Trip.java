package AddTwoNumbers;

public class Trip {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Not enough inputs");
            return;
        }
        if (args.length > 3) {
            System.out.println("Too many inputs");
            return;
        }
        try {
            Integer integer1 = Integer.valueOf(args[0]);
            Integer integer2 = Integer.valueOf(args[1]);
            Integer integer3 = Integer.valueOf(args[2]);

            if(integer1<0 || integer2<0 || integer3<0){
                System.out.println("Negative inputs not allowed.");
                return;
            }

            if (integer1.equals(0)) {
                System.out.println("Divide by zero exception! Please check your inputs.");
                return;
            }

            int cars = 0;
            if (integer1 % 4 != 0) {
                cars = (integer1 / 4) + 1;
            } else {
                cars = integer1 / 4;
            }
            int cost = (cars * integer2) / integer1 + integer3;

            System.out.println("Number of Cars Required: " + cars);
            System.out.println("Cost per Person : $" + cost);
        } catch (Exception e) {
            System.out.println("Number format Exception! Please enter non-negative integers only.");
            return;
        }

    }
}
