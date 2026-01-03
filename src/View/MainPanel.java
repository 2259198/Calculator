package View;

import View.Operations.*;
import View.Palettes.ColorPalette;
import View.Palettes.TextPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class MainPanel extends JPanel implements ActionListener {

    private double firstNumber = 0;
    private double secondNumber = 0;
    private OperationsLogic currentOperation = null;
    private boolean startNewNumber = true;

    Dimension appDimension = Toolkit.getDefaultToolkit().getScreenSize();

    JPanel mainPanel = new JPanel();
    JPanel textFieldPanel;
    JPanel buttonPanel;

    JTextField mainTextField = new JTextField();

    File fileHover = new File("src/Sound/hover_sound.wav");
    File fileClick = new File("src/Sound/button_Clicked.wav");
    private Clip hoverClip;
    private Clip clickClip;


    public MainPanel() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        panelLayout();
        createMainPanel();
        audioControlLogic();
    }

    public void panelLayout()
    {
        setLayout(new GridBagLayout());
        mainPanel = new JPanel();
    }

    private void createMainPanel() {
        mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setPreferredSize(new Dimension(400, 600));
        mainPanel.setBorder(new EmptyBorder(25,25,25,25));

        createTextFieldPanel();
        createButtonPanel();

        mainPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        mainPanel.add(textFieldPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    public void audioControlLogic() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        AudioInputStream audioStreamHover = AudioSystem.getAudioInputStream(fileHover);
        hoverClip = AudioSystem.getClip();
        hoverClip.open(audioStreamHover);

        AudioInputStream audioStreamClicked = AudioSystem.getAudioInputStream(fileClick);
        clickClip = AudioSystem.getClip();
        clickClip.open(audioStreamClicked);
    }

    private void createTextFieldPanel() {
        mainTextField.setEditable(false);

        mainTextField.setFont(new Font("Segoe UI", Font.BOLD, 32));

        mainTextField.setHorizontalAlignment(JTextField.LEFT);
        mainTextField.setMargin(new Insets(10,10,10,10));

        mainTextField.setPreferredSize(new Dimension(0, 80));

        textFieldPanel = new JPanel(new BorderLayout());
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
        button.setFont(TextPalette.MAIN_FONT);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickClip.setFramePosition(0);
                clickClip.start();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hoverClip.setFramePosition(0);
                hoverClip.start();
            }
        });

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

    private void handleAddition()
    {
        if (checkIfTextFieldIsEmpty()) {
            return;
        }

        try{
            firstNumber = Double.parseDouble(mainTextField.getText());
            currentOperation = new Addition();
            startNewNumber = true;
        }
        catch (NumberFormatException e)
        {
            jOptionPaneMessageError();
        }
    }

    private void handleSubtraction()
    {
        if (checkIfTextFieldIsEmpty()) {
            return;
        }

        try{
            firstNumber = Double.parseDouble(mainTextField.getText());
            currentOperation = new Substract();
            startNewNumber = true;
        }
        catch (NumberFormatException e)
        {
            jOptionPaneMessageError();
        }
    }

    private void handleMultiplication()
    {
        if (checkIfTextFieldIsEmpty()) {
            return;
        }

        try {
            firstNumber = Double.parseDouble(mainTextField.getText());
            currentOperation = new Multiplication();
            startNewNumber = true;
        }
        catch (NumberFormatException e)
        {
            jOptionPaneMessageError();
        }

    }

    private void handleSquareRoot()
    {
        if (checkIfTextFieldIsEmpty()) {
            return;
        }

        try {
            firstNumber = Double.parseDouble(mainTextField.getText());
            currentOperation = new SquareRoot();
            handleEquals();
        }
        catch (NumberFormatException e)
        {
            jOptionPaneMessageError();
        }

    }

    private void handleToThePower()
    {
        if (checkIfTextFieldIsEmpty()) {
            return;
        }

        try {
            firstNumber = Double.parseDouble(mainTextField.getText());
            currentOperation = new ToThePower();
            handleEquals();
        } catch (NumberFormatException e) {
            jOptionPaneMessageError();
        }
    }


    private void handleDivision()
    {
        if (checkIfTextFieldIsEmpty()) {
            return;
        }

        try{
            firstNumber = Double.parseDouble(mainTextField.getText());
            currentOperation = new Division();
            startNewNumber = true;
        }
        catch (NumberFormatException e)
        {
            jOptionPaneMessageError();
        }
    }

    private void handleReciprocal()
    {
        if (checkIfTextFieldIsEmpty()) {
            return;
        }

        try{
            firstNumber = Double.parseDouble(mainTextField.getText());
            currentOperation = new Reciprocal();
            handleEquals();
        }
        catch (NumberFormatException e)
        {
            jOptionPaneMessageError();
        }
    }

    private void handlePlusMinus()
    {
        if (checkIfTextFieldIsEmpty()) {
            return;
        }

        try{
            double value = Double.parseDouble(mainTextField.getText());
            value = -value;
            mainTextField.setText(String.valueOf(value));
        }
        catch (NumberFormatException e)
        {
            jOptionPaneMessageError();
        }

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
        if (checkIfTextFieldIsEmpty()) {
            return;
        }

        secondNumber = Double.parseDouble(mainTextField.getText());
        double result = currentOperation.operation(firstNumber, secondNumber);

        mainTextField.setText(String.valueOf(result));
        startNewNumber = true;
        currentOperation = null;
    }

    private boolean checkIfTextFieldIsEmpty()
    {
        String text = mainTextField.getText();

        if (text == null || text.isEmpty()) {
            JOptionPane.showMessageDialog(this,"There's nothing entered in the text field, please enter something","Blank text field error",JOptionPane.ERROR_MESSAGE);
            return true;
        }

        return false;
    }

    private void jOptionPaneMessageError()
    {
        JOptionPane.showMessageDialog(this, "Please enter a valid numeric values", "Input error", JOptionPane.ERROR_MESSAGE);
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
            case "√":
                handleSquareRoot();
                break;
            case "x²":
                handleToThePower();
                break;
            case "1/x":
                handleReciprocal();
                break;
            case "+/-":
                handlePlusMinus();
                break;
        }
    }

}
