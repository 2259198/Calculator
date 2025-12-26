package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    public final int MAX_BOUTTONS = 10;

    JPanel mainPanel;
    JButton[] buttons;

    public MainPanel()
    {
        panelLayout();
        configurationOfPanel();
    }

    public void panelLayout()
    {

    }

    public void configurationOfPanel()
    {
        buttons = new JButton[MAX_BOUTTONS];

        for(int i = 1; i < MAX_BOUTTONS; i++)
        {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {

    }

}
