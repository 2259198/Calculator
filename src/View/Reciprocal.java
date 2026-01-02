package View;

public class Reciprocal implements OperationsLogic{
    @Override
    public double operation(int number1, int number2) {
        return 1 / number1;
    }

    @Override
    public String getOperation() {
        return "1 / x";
    }
}
