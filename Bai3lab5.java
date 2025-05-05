abstract class Shape {
    protected String color;
    protected boolean filled;
    public Shape() {
        this.color = "red";
        this.filled = true;
    }
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shape shape = (Shape) obj;
        return filled == shape.filled && color.equals(shape.color);
    }
}
class Circle implements Shape {
    private double radius;
    public Circle() {
        this.radius = 0;
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return pi * radius * radius;
    }
    @Override
    public double getPerimeter() {
        return 2 * pi * radius;
    }
    @Override
    public String toString() {
        return "Hinh tron [radius=" + radius + ", color=" + color + ", filled=" + filled + "]";
    }
}
class Rectangle implements Shape {
    private double width;
    private double length;
    public Rectangle() {
        this.width = 0;
        this.length = 0;
    }
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public double getArea() {
        return width * length;
    }
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }
    @Override
    public String toString() {
        return "Hinh chu nhat [width=" + width + ", length=" + length + ", color=" + color + ", filled=" + filled + "]";
    }
}
class Square extends Rectangle {
    public Square() {
        super();
    }
    public Square(double side) {
        super(side, side);
    }
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    public double getSide() {
        return getWidth();
    }
    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }
    @Override
    public String toString() {
        return "Hinh vuong [side=" + getSide() + ", color=" + color + ", filled=" + filled + "]";
    }
}
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "blue", true);
        Rectangle rectangle = new Rectangle(4, 6, "green", false);
        Square square = new Square(3, "yellow", true);
        System.out.println("Thong tin hinh tron:");
        System.out.println(circle.toString());
        System.out.println("Dien tich: " + circle.getArea() + ", Chu vi: " + circle.getPerimeter());
        System.out.println("\nThong tin hinh chu nhat:");
        System.out.println(rectangle.toString());
        System.out.println("Dien tich: " + rectangle.getArea() + ", Chu vi: " + rectangle.getPerimeter());
        System.out.println("\nThong tin hinh vuong:");
        System.out.println(square.toString());
        System.out.println("Dien tich: " + square.getArea() + ", Chu vi: " + square.getPerimeter());
        System.out.println("\nKiem tra equals:");
        System.out.println("Circle va Rectangle co bang nhau khong? " + circle.equals(rectangle));
        System.out.println("Rectangle va Square co bang nhau khong? " + rectangle.equals(square));
    }
}
