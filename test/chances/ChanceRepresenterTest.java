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
        assertEquals("25.0%", chance.toString());
    }

    @Test
    public void should_represent_a_chance_of_not_getting_tails_when_flipping_a_coin() throws InvalidProbability {
        ChanceRepresenter chance = ChanceRepresenter.createChance(0.25);
        assertEquals("75.0%", chance.not().toString());
    }
}