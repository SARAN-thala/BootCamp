package shapes;

/*
    Job of Rectangle Class:
    - any operation that involves length and/or width of Rectangle
          calculateArea,calculatePerimeter...
 */
public class Rectangle {
    private final double length;
    private final double width;

    private Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return (this.length * this.width);
    }

    public double calculatePerimeter() {
        return (2*(this.length+this.width));
    }

    public static Rectangle createRectangle(double length,double width) throws NegativeValueException {
        if (length < 0  || width < 0)
            throw new NegativeValueException();
        return new Rectangle(length,width);
    }
}
