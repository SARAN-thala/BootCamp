package shapes;

/*
    Job of Square Class:
    - any operation that involves side of Square
 */

import exceptions.NonPositiveValueException;

public class Square extends Rectangle {

    private Square(double side) {
        super(side,side);
    }

    public static Square createSquare(double side) throws NonPositiveValueException {
        if(side <= 0)
            throw new NonPositiveValueException("Can't create square with side "+side);
        return new Square(side);
    }
}
