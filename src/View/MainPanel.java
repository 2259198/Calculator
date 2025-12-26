package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    Dimension appDimension = Toolkit.getDefaultToolkit().getScreenSize();

    public final int MAX_BOUTTONS = 10;
    public final int MAX_COLUMNS = 3;

    JPanel mainPanel;

    JPanel textFieldPanel;

    JButton buttons;

    JTextField mainTextField;

    public MainPanel()
    {
        panelLayout();
        textFieldCreation();
        buttonCreation();
        panelCreation();
    }

    public void panelLayout()
    {
        this.setLayout(new GridLayout(0, MAX_COLUMNS));

        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        mainPanel.setPreferredSize(new Dimension(500, 200));
    }

    public void textFieldCreation()
    {
        mainTextField = new JTextField();
        mainTextField.setPreferredSize(new Dimension(100, 30));
        mainTextField.setEditable(false);
        textFieldPanel = new JPanel();
    }

    public void buttonCreation()
    {
        buttons = new JButton();

        for(int i = 0; i < MAX_BOUTTONS; i++)
        {
            buttons = new JButton(String.valueOf(i));
            buttons.addActionListener(this);
            buttons.setPreferredSize(new Dimension(100, 100));
            buttons.setBackground(ColorPalette.MAIN_COLOR);
            buttons.setForeground(ColorPalette.TEXT_COLOR);
            buttons.setBorderPainted(false);

            add(buttons);

            mainPanel.add(buttons);
        }
    }

    public void panelCreation()
    {
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        textFieldPanel.add(mainTextField);
        textFieldPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        textFieldPanel.setPreferredSize(new Dimension(appDimension.width, 100));

        mainPanel.add(textFieldPanel);


        add(mainPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent event)
    {

    }

}
