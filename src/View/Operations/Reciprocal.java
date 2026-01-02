package View.Operations;

public class Reciprocal implements OperationsLogic {
    @Override
    public double operation(double number1, double number2) {
        return 1 / number1;
    }

    @Override
    public String getOperation() {
        return "1 / x";
    }
}
