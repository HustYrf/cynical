class Shape {
    protected String name;
    protected double height;
    protected double width;

    public Shape(String name, double height, double width) {
        this.name = name;
        this.height = height;
        this.width = width;
    }

    protected double getArea() {
        return height * width;
    }
}

class Rectangle extends Shape {
    public Rectangle(String name, double height, double width) {
        super(name, height, width);
    }
}


class Square extends Shape {
    public Square(String name, double sides) {
        super(name, sides, sides);
    }
}