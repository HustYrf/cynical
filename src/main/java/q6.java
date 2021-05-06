public class q6 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle("Rectangle", 10.0, 5.0);
        System.out.println("Area of " +r.name+":"+ r.getArea());

        Square s = new Square("Square", 5.0);
        System.out.println("Area of " +s.name+":"+ s.getArea());
    }
}
