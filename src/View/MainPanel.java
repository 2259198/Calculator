package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    public final int MAX_BOUTTONS = 10;

    JPanel mainPanel;
    JButton buttons;

    public MainPanel()
    {
        panelLayout();
        configurationOfPanel();
    }

    public void panelLayout()
    {
        mainPanel = new JPanel();
        this.setLayout(new GridLayout(0, 3));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        mainPanel.setPreferredSize(new Dimension(500, 200));
    }

    public void configurationOfPanel()
    {
        buttons = new JButton();

        for(int i = 0; i < MAX_BOUTTONS; i++)
        {
            buttons = new JButton(String.valueOf(i));
            buttons.addActionListener(this);
            buttons.setPreferredSize(new Dimension(130, 30));
            add(buttons);

            mainPanel.add(buttons);
        }

        add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {

    }

}
