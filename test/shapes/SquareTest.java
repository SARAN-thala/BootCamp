package shapes;

import exceptions.NonPositiveValueException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SquareTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void square_will_throws_error_message_when_try_to_create_by_negative_values() throws NonPositiveValueException {
        thrown.expect(NonPositiveValueException.class);
        thrown.expectMessage("Can't create square with side -1.0");
        Square.createSquare(-1);
    }
}