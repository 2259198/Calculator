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
        buttonCreation();
    }

    public void panelLayout()
    {
        this.setLayout(new GridLayout(0, 3));

        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        mainPanel.setPreferredSize(new Dimension(500, 200));
    }

    public void buttonCreation()
    {
        buttons = new JButton();

        for(int i = 0; i < MAX_BOUTTONS; i++)
        {
            buttons = new JButton(String.valueOf(i));
            buttons.addActionListener(this);
            buttons.setPreferredSize(new Dimension(100, 50));
            buttons.setBackground(ColorPalette.MAIN_COLOR);
            buttons.setForeground(ColorPalette.TEXT_COLOR);

            add(buttons);

            mainPanel.add(buttons);
        }


        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {

    }

}
