package View.Operations;

import static java.lang.Math.*;

public class SquareRoot implements OperationsLogic {

    @Override
    public double operation(double number1, double number2)
    {
        return sqrt(number1);
    }

    @Override
    public String getOperation() {
        return "√";
    }

}
