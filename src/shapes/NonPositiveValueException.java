package shapes;

public class NonPositiveValueException extends Throwable {
    public NonPositiveValueException(double length, double width) {
        super("Can't create rectangle with length "+length+" and width "+width);
    }
}
