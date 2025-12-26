public class Multiplication implements OperationsLogic{

    @Override
    public int operation(int number1, int number2)
    {
        return number1 * number2;
    }

    @Override
    public String getOperation()
    {
        return "*";
    }

}
