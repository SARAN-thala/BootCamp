package shapes;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;


public class RectangleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void area_should_return_the_area_of_rectangle() throws Exception, NegativeValueException {
        Rectangle rectangle = Rectangle.createRectangle(20,10);
        assertEquals(200.0,rectangle.calculateArea());
    }

    @Test
    public void a_rectangle_will_throws_error_message_when_try_to_create_by_negative_values() throws Exception, NegativeValueException {
        thrown.expectMessage("Can't create rectangle with negative value ");
        Rectangle rectangle = Rectangle.createRectangle(-1, 2);
    }

    @Test
    public void area_should_return_the_area_of_rectangle_in_float() throws Exception, NegativeValueException {
        Rectangle rectangle = Rectangle.createRectangle(10.5,10);
        assertEquals(105.0,rectangle.calculateArea());
    }

    @Test
    public void perimeter_should_return_the_perimeter_of_given_rectangle() throws Exception, NegativeValueException {
        Rectangle rectangle = Rectangle.createRectangle(25,10);
        assertEquals(70.0,rectangle.calculatePerimeter());
    }

    @Test
    public void perimeter_should_return_the_perimeter_of_given_rectangle_in_float() throws Exception, NegativeValueException {
        Rectangle rectangle = Rectangle.createRectangle(25.5,9.5);
        assertEquals(70.0,rectangle.calculatePerimeter());
    }
}