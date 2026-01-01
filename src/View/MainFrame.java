package View;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame implements Runnable {

    MainPanel mainPanel = new MainPanel();

    public MainFrame() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
    }

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
