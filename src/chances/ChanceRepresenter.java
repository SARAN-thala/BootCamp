package chances;
/*
    job of ChanceRepresenter:-
    - represent the chance of getting Tails/NotTails
 */

import exceptions.InvalidProbability;

public class ChanceRepresenter {
    private double probability;

    private ChanceRepresenter(double probability) {
        this.probability = probability;
    }

    public static ChanceRepresenter createChance(double probability) throws InvalidProbability {
        if (probability < 0 || probability > 1)
            throw new InvalidProbability("Expected values between 0 and 1, but got: " + probability);
        return new ChanceRepresenter(probability);
    }

    public ChanceRepresenter and(ChanceRepresenter anotherProbability) {
        return new ChanceRepresenter(this.probability * anotherProbability.probability);
    }

    public ChanceRepresenter or(ChanceRepresenter anotherProbability) {
        return new ChanceRepresenter(this.probability + anotherProbability.probability);
    }

    public ChanceRepresenter not() {
        return new ChanceRepresenter(1 - this.probability);
    }

    @Override
    public String toString() {
        return probability * 100 + "%";
    }
}
