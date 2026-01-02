package View;
import static java.lang.Math.*;

public class ToThePower implements OperationsLogic{


    @Override
    public double operation(double number1, double number2) {
        return pow(number1, 2);
    }

    @Override
    public String getOperation() {
        return "x²";
    }
}
