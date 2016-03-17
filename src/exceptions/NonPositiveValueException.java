package exceptions;

public class NonPositiveValueException extends Throwable {
    public NonPositiveValueException(String err) {
        super(err);
    }
}
