package View;

import javax.swing.*;

public class MainFrame extends JFrame implements Runnable {

    @Override
    public void run()
    {
        mainFrame();
        this.setVisible(true);
    }

    public void mainFrame()
    {
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Calculator app");
    }

}
