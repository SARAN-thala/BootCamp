package chances;

import exceptions.InvalidProbability;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.TestCase.assertEquals;

public class ChanceRepresenterTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_represent_a_chance_of_getting_tails_when_flipping_a_coin() throws InvalidProbability {
        ChanceRepresenter chance = ChanceRepresenter.createChance(0.25);
        ChanceRepresenter expected = ChanceRepresenter.createChance(0.25);
        assertEquals(expected, chance);
    }

    @Test
    public void should_represent_a_chance_of_not_getting_tails_when_flipping_a_coin() throws InvalidProbability {
        ChanceRepresenter chance = ChanceRepresenter.createChance(0.25);
        ChanceRepresenter expected = ChanceRepresenter.createChance(0.75);
        assertEquals(expected, chance.not());
    }

    @Test
    public void should_represent_a_chance_of_getting_tails_when_flipping_two_coin() throws InvalidProbability {
        ChanceRepresenter chance1 = ChanceRepresenter.createChance(0.25);
        ChanceRepresenter chance2 = ChanceRepresenter.createChance(0.25);
        ChanceRepresenter expected = ChanceRepresenter.createChance(0.0625);
        assertEquals(expected, chance1.and(chance2));
    }

    @Test
    public void should_represent_a_chance_of_getting_tails_when_flipping_two_coin_in_or_method() throws InvalidProbability {
        ChanceRepresenter chance1 = ChanceRepresenter.createChance(0.25);
        ChanceRepresenter chance2 = ChanceRepresenter.createChance(0.25);
        ChanceRepresenter expected = ChanceRepresenter.createChance(0.5);
        assertEquals(expected, chance1.or(chance2));
    }

    @Test
    public void chances_will_throw_error_message_when_to_create_probability_beyond_1() throws InvalidProbability {
        thrown.expectMessage("Expected values between 0 and 1, but got: 1.25");
        thrown.expect(InvalidProbability.class);
        ChanceRepresenter.createChance(1.25);
    }

    @Test
    public void chances_will_throw_error_message_when_to_create_probability_below_0() throws InvalidProbability {
        thrown.expectMessage("Expected values between 0 and 1, but got: -0.2");
        thrown.expect(InvalidProbability.class);
        ChanceRepresenter.createChance(-0.2);
    }
}