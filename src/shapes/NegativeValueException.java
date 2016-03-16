package shapes;

public class NegativeValueException extends Throwable {
    public NegativeValueException() {
        super("Can't create rectangle with negative value ");
    }
}
