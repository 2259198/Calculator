package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    Dimension appDimension = Toolkit.getDefaultToolkit().getScreenSize();

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
        //mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        mainPanel.setPreferredSize(new Dimension(appDimension.width / 5, appDimension.height / 2));

        createTextFieldPanel();
        createButtonPanel();

        mainPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        mainPanel.add(textFieldPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
    }


    private void createTextFieldPanel() {
        mainTextField = new JTextField();
        mainTextField.setEditable(false);

        textFieldPanel = new JPanel(new BorderLayout());
        //textFieldPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
        textFieldPanel.add(mainTextField, BorderLayout.CENTER);
    }

    private void createButtonPanel() {
        buttonPanel = new JPanel(new GridBagLayout());

        addButton("%", 0, 0, 1, 1);
        addButton("CE", 1, 0, 1, 1);
        addButton("C", 2, 0, 1, 1);
        addButton("<-", 3, 0, 1, 1);

        addButton("1/x", 0, 1, 1, 1);
        addButton("x²", 1, 1, 1, 1);
        addButton("√", 2, 1, 1, 1);
        addButton("/", 3, 1, 1, 1);

        addButton("7", 0, 2, 1, 1);
        addButton("8", 1, 2, 1, 1);
        addButton("9", 2, 2, 1, 1);
        addButton("x", 3, 2, 1, 1);

        addButton("4", 0, 3, 1, 1);
        addButton("5", 1, 3, 1, 1);
        addButton("6", 2, 3, 1, 1);
        addButton("-", 3, 3, 1, 1);

        addButton("1", 0, 4, 1, 1);
        addButton("2", 1, 4, 1, 1);
        addButton("3", 2, 4, 1, 1);
        addButton("+", 3, 4, 1, 1);

        addButton("+/-", 0, 5, 1, 1);
        addButton("0", 1, 5, 1, 1);
        addButton(".", 2, 5, 1, 1);
        addButton("=", 3, 5, 1, 1);
    }

    private void addButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        button.setBackground(ColorPalette.MAIN_COLOR);
        button.setForeground(ColorPalette.TEXT_COLOR);
        button.setBorderPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 18));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        buttonPanel.add(button, gbc);
    }


    @Override
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();


        switch (command)
        {
            case ".":
                mainTextField.setText(mainTextField.getText().concat("."));
                break;
            case "+":
                mainTextField.setText(mainTextField.getText().concat("+"));
                break;
            case "-":
                mainTextField.setText(mainTextField.getText().concat("-"));
                break;
            case "/":
                mainTextField.setText(mainTextField.getText().concat("/"));
                break;
            case "x":
                mainTextField.setText(mainTextField.getText().concat("x"));
                break;
        }

        if(command.equals(".")){

        }

        /*if (command.matches("\\d")) {
            mainTextField.setText(mainTextField.getText() + command);
        } else {
            mainTextField.setText(mainTextField.getText() + " " + command + " ");
        }*/
    }

}
