package BestTime2BuyAndSellStockII;

public class Coach extends Person {
    private double jobDuration;


    public Coach(String name, int age, double jobDuration) {
        super(name, age);
        this.jobDuration = jobDuration;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.jobDuration;
    }
}
