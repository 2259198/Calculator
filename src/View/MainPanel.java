package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class MainPanel extends JPanel implements ActionListener {

    Dimension appDimension = Toolkit.getDefaultToolkit().getScreenSize();

    public final int MAX_COLUMNS = 3;

    JPanel mainPanel = new JPanel();
    JPanel textFieldPanel;
    JPanel buttonPanel;

    JButton buttons;

    JTextField mainTextField;

    private int firstNumber = 0;
    private int secondNumber = 0;
    private OperationsLogic currentOperation = null;
    private boolean startNewNumber = true;


    File file = new File("src/Sound/hover_sound.wav");


    public MainPanel() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        panelLayout();
        createMainPanel();


        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();
    }

    public void panelLayout()
    {
        setLayout(new GridBagLayout());
        mainPanel = new JPanel();

        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        mainPanel.setPreferredSize(new Dimension(600, 200));
    }

    private void createMainPanel() {
        mainPanel = new JPanel(new BorderLayout(10, 10));
        //mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
        mainPanel.setPreferredSize(new Dimension(appDimension.width / 5, appDimension.height / 2));
        mainPanel.setBorder(new EmptyBorder(25,25,25,25));

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
        addButton("←", 3, 0, 1, 1);

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

    private void appendNumber(String number) {
        if (startNewNumber) {
            mainTextField.setText(number);
            startNewNumber = false;
        }
        else {
            mainTextField.setText(mainTextField.getText() + number);
        }
    }

    private void handleAddition() {
        firstNumber = Integer.parseInt(mainTextField.getText());
        currentOperation = new Addition();
        startNewNumber = true;
    }

    private void handleSubtraction()
    {
        firstNumber = Integer.parseInt(mainTextField.getText());
        currentOperation = new Substract();
        startNewNumber = true;
    }

    private void handleMultiplication()
    {
        firstNumber = Integer.parseInt(mainTextField.getText());
        currentOperation = new Multiplication();
        startNewNumber = true;
    }

    private void handleDivision()
    {
        firstNumber = Integer.parseInt(mainTextField.getText());
        currentOperation = new Division();
        startNewNumber = true;
    }

    private void handleClear()
    {
        mainTextField.setText("");
        startNewNumber = true;
    }

    private void handleCE()
    {
        mainTextField.setText("0");
        startNewNumber = true;
    }

    private void handleEquals() {
        if (currentOperation == null) return;

        secondNumber = Integer.parseInt(mainTextField.getText());
        double result = currentOperation.operation(firstNumber, secondNumber);

        mainTextField.setText(String.valueOf(result));
        startNewNumber = true;
        currentOperation = null;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        OperationsLogic operation = null;

        String command = event.getActionCommand();

        switch (command)
        {
            case "0": case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9":
                appendNumber(command);
                break;
            case ".":
                mainTextField.setText(mainTextField.getText().concat("."));
                break;
            case "+":
                handleAddition();
                break;
            case "-":
                handleSubtraction();
                break;
            case "/":
                handleDivision();
                break;
            case "x":
                handleMultiplication();
                break;
            case "=":
                handleEquals();
                break;
            case "C":
                handleClear();
                break;
            case "CE":
                handleCE();
                break;
        }
    }

}
