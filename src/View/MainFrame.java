package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Runnable {

    MainPanel mainPanel = new MainPanel();

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

        mainPanel.setBackground(new Color(0.0f,0.0f,0.0f, 0.2f));

        add(mainPanel);
    }

}
