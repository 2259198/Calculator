package Model;

public class Model {

    private static Model instance = new Model();

    private Model()
    {

    }

    public static Model getInstance()
    {
        return instance;
    }

}
