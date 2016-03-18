package chances;
/*
    job of ChanceRepresenter:-
    - represent the chance of getting Tails/NotTails
 */

import exceptions.InvalidProbability;

class ChanceRepresenter {
    private Double probability;

    private ChanceRepresenter(Double probability) {
        this.probability = probability;
    }

    static ChanceRepresenter createChance(Double probability) throws InvalidProbability {
        if (probability < 0 || probability > 1)
            throw new InvalidProbability("Expected values between 0 and 1, but got: " + probability);
        return new ChanceRepresenter(probability);
    }

    ChanceRepresenter and(ChanceRepresenter anotherProbability) {
        return new ChanceRepresenter(this.probability * anotherProbability.probability);
    }

    ChanceRepresenter or(ChanceRepresenter anotherProbability) {
        return new ChanceRepresenter(this.probability + anotherProbability.probability);
    }

    ChanceRepresenter not() {
        return new ChanceRepresenter(1 - this.probability);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChanceRepresenter that = (ChanceRepresenter) o;

        return Double.compare(that.probability, probability) == 0;
    }
}
