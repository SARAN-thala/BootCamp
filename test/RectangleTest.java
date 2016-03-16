import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class RectangleTest {
    @Test
    public void area_should_return_the_area_of_rectangle() throws Exception {
        Rectangle rectangle = new Rectangle(20,10);
        assertEquals(200.0,rectangle.area());
    }
    @Test
    public void area_should_return_the_area_of_rectangle_in_float() throws Exception {
        Rectangle rectangle = new Rectangle(10.5,10);
        assertEquals(105.0,rectangle.area());
    }

    @Test
    public void perimeter_should_return_the_perimeter_of_given_rectangle() throws Exception {
        Rectangle rectangle = new Rectangle(25,10);
        assertEquals(70.0,rectangle.perimeter());
    }

    @Test
    public void perimeter_should_return_the_perimeter_of_given_rectangle_in_float() throws Exception {
        Rectangle rectangle = new Rectangle(25.5,9.5);
        assertEquals(70.0,rectangle.perimeter());
    }
}