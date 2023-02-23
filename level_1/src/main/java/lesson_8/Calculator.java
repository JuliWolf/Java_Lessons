package lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    JPanel mainPanel;
    JPanel buttonPanel;
    JFrame mainFrame;

    JLabel label;
    JButton[] actionButtons = new JButton[4];

    int[] numbers = {7, 8, 9, 4, 5, 6, 1, 2, 3, 0};

    private Integer x = null;
    private Integer y = null;
    private String operation;

    public void setX (Integer x) {
        this.x = x;
    }

    public void setY (Integer y) {
        this.y = y;
    }

    public void setOperation (String operation) {
        this.operation = operation;
    }

    private boolean isXSet () {
        return x != null;
    }

    private boolean isYSet () {
        return y != null;
    }

    private boolean isOperationSet () {
        return operation.isBlank();
    }

    public Calculator () {
        buildGUI();
    }

    public void buildGUI () {
//      Create main Frame and main panels
        mainFrame = new JFrame("Calculator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

//      Create layout for right button panel
        GridLayout buttonLayout = new GridLayout(4, 1, 4, 4);
        buttonPanel = new JPanel(buttonLayout);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(4,10,0,0));

//      Create label to show information about operations
        label = new JLabel("");
        label.setPreferredSize(new Dimension(200, 40));
        label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        background.add(label, BorderLayout.NORTH);

//      Create operation buttons
        JButton minus = new JButton("-");
        minus.addActionListener(new OperationListener(minus.getText()));
        buttonPanel.add(minus);
        actionButtons[0] = minus;

        JButton plus = new JButton("+");
        plus.addActionListener(new OperationListener(plus.getText()));
        buttonPanel.add(plus);
        actionButtons[1] = plus;

        JButton count = new JButton("=");
        count.addActionListener(new CountListener());
        buttonPanel.add(count);

        JButton clear = new JButton("C");
        clear.addActionListener(new ClearListener());
        buttonPanel.add(clear);

        JButton multiply = new JButton("*");
        multiply.addActionListener(new OperationListener(multiply.getText()));
        actionButtons[2] = multiply;

        JButton division = new JButton("/");
        division.addActionListener(new OperationListener(division.getText()));
        actionButtons[3] = division;

//      Create frid layout for number buttons
        GridLayout grid = new GridLayout(4, 3);
        grid.setVgap(1);
        grid.setVgap(2);

//      Add Buttons to right part of the border layout
//      Add layout to frame
        background.add(BorderLayout.EAST, buttonPanel);
        mainFrame.getContentPane().add(background);

//      Add grid layout with number buttons to main Panel
        mainPanel = new JPanel(grid);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(4,0,0,0));
        background.add(BorderLayout.CENTER, mainPanel);

//      Create number buttons
        for (int number : numbers) {
            JButton n = new JButton(Integer.toString(number));
            n.addActionListener(new NumberListener(number));
            mainPanel.add(n);
        }

        mainPanel.add(multiply);
        mainPanel.add(division);

        mainFrame.setBounds(2000, 1300, 300, 300);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private void updateLabel (String text) {
        if (label.getText().isBlank()) {
            label.setText(text);
            return;
        }

        String labelText = label.getText();
        label.setText(labelText + " " + text);
    }

    private void clear () {
        setX(null);
        setY(null);
        setOperation("");
        toggleActionButtons(true);
    }

    private void toggleActionButtons (boolean isEnabled) {
        for (JButton button : actionButtons) {
            button.setEnabled(isEnabled);
        }
    }

    private double count () {
        double count = 0;

        switch (operation) {
            case "*": count = x * y; break;
            case "/": count = (double) x / y; break;
            case "+": count = x + y; break;
            case "-": count = x - y; break;
        }

        return count;
    }

    public class NumberListener implements ActionListener {
        private int number;

        public NumberListener (int n) {
            super();

            number = n;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            if (!isXSet()) {
                label.setText("");
                setX(number);
                updateLabel(Integer.toString(number));
                return;
            }

            if (isOperationSet()) {
                return;
            }

            if (!isYSet()) {
                setY(number);
                updateLabel(Integer.toString(number));
                toggleActionButtons(false);
            }
        }
    }

    public class OperationListener implements ActionListener {
        private String sign;

        public OperationListener (String o) {
            super();

            sign = o;
        }

        public void actionPerformed(ActionEvent actionEvent) {
            setOperation(sign);
            updateLabel(sign);
        }
    }

    public class ClearListener implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            clear();
            label.setText("");
        }
    }

    public class CountListener implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            if (!isYSet()) return;

            double count = count();

            if (count % 1 == 0) {
                int num = (int) count;
                updateLabel("= " + num);
            } else {
                updateLabel("= " + count);
            }

            clear();
        }
    }
}
