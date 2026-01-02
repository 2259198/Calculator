package View;
import static java.lang.Math.*;

public class SquareRoot implements OperationsLogic{

    @Override
    public double operation(int number1, int number2)
    {
        return sqrt(number1);
    }

    @Override
    public String getOperation() {
        return "√";
    }

}
