package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    Dimension appDimension = Toolkit.getDefaultToolkit().getScreenSize();

    public final int MAX_BOUTTONS = 10;
    public final int MAX_COLUMNS = 3;

    JPanel mainPanel = new JPanel();

    JPanel textFieldPanel;

    JPanel buttonPanel;

    JButton buttons;

    JTextField mainTextField;

    public MainPanel()
    {
        panelLayout();
        createMainPanel();
    }

    public void panelLayout()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, MAX_COLUMNS));

        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        mainPanel.setPreferredSize(new Dimension(500, 200));
    }

    private void createMainPanel() {
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        mainPanel.setPreferredSize(new Dimension(500, 300));

        createTextFieldPanel();
        createButtonPanel();

        mainPanel.add(textFieldPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
    }


    private void createTextFieldPanel() {
        mainTextField = new JTextField();
        mainTextField.setEditable(false);

        textFieldPanel = new JPanel(new BorderLayout());
        textFieldPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        textFieldPanel.add(mainTextField, BorderLayout.CENTER);
    }

    private void createButtonPanel() {
        buttonPanel = new JPanel(new GridLayout(0, MAX_COLUMNS, 5, 5));

        for (int i = 0; i < MAX_BOUTTONS; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(this);
            button.setBackground(ColorPalette.MAIN_COLOR);
            button.setForeground(ColorPalette.TEXT_COLOR);
            button.setBorderPainted(false);

            buttonPanel.add(button);
        }
    }



    @Override
    public void actionPerformed(ActionEvent event)
    {

    }

}
