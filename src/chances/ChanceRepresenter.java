package chances;
/*
    job of ChanceRepresenter:-
    - represent the chance of getting Tails/NotTails
 */

import exceptions.InvalidProbability;

public class ChanceRepresenter {
    private Double probability;

    private ChanceRepresenter(Double probability) {
        this.probability = probability;
    }

    public static ChanceRepresenter createChance(Double probability) throws InvalidProbability {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChanceRepresenter that = (ChanceRepresenter) o;

        return Double.compare(that.probability, probability) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(probability);
        return (int) (temp ^ (temp >>> 32));
    }
}
