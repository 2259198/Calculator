package View;
import static java.lang.Math.*;

public class ToThePower implements OperationsLogic{


    @Override
    public double operation(int number1, int number2) {
        return pow(number1, 2);
    }

    @Override
    public String getOperation() {
        return "x²";
    }
}
