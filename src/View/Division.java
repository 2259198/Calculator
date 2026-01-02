package View;

public class Division implements OperationsLogic{

    @Override
    public double operation(double number1, double number2)
    {
        return number1 / number2;
    }

    @Override
    public String getOperation()
    {
        return "/";
    }

}
