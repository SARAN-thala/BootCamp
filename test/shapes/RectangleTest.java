package shapes;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;


public class RectangleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Rectangle rectangleWithWholeNumber;
    private Rectangle rectangleWithFloatingPoints;

    @Before
    public void setUp() throws NonPositiveValueException {
        rectangleWithWholeNumber = Rectangle.createRectangle(20, 10);
        rectangleWithFloatingPoints = Rectangle.createRectangle(10.5, 10);
    }

    @Test
    public void should_return_the_area_of_the_rectangle_which_has_positive_sides() {
        assertEquals(200.0, rectangleWithWholeNumber.calculateArea());
    }

    @Test
    public void should_return_the_area_of_rectangle_in_float_which_has_floating_point_sides() {
        assertEquals(105.0, rectangleWithFloatingPoints.calculateArea());
    }


    @Test
    public void should_return_the_perimeter_of_given_rectangle_which_has_floating_point_sides() {
        assertEquals(60.0, rectangleWithWholeNumber.calculatePerimeter());
    }

    @Test
    public void should_return_the_perimeter_of_given_rectangle_which_has_positive_int_values() {
        assertEquals(41.0, rectangleWithFloatingPoints.calculatePerimeter());
    }

    @Test
    public void rectangle_will_throws_error_message_when_try_to_create_by_negative_values() throws NonPositiveValueException {
        thrown.expectMessage("Can't create rectangle with length -1.0 and width 2.0");
        thrown.expect(NonPositiveValueException.class);
        Rectangle.createRectangle(-1, 2);
    }

    @Test
    public void rectangle_will_throws_error_message_when_try_to_create_by_null_values() throws NonPositiveValueException {
        thrown.expect(NonPositiveValueException.class);
        thrown.expectMessage("Can't create rectangle with length 0.0 and width 2.0");
        Rectangle.createRectangle(0, 2);
    }
}