/**
 * This code implements a GUI using swings. It prompts the user to enter the array elements. 
 * Sorts them using bubble sort and displays the median of the array along with the sorted array on the GUI.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MedianCalculatorGUI extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;

    public MedianCalculatorGUI() {
    // The below code is for designing the GUI
        super("Median Calculator");

        inputField = new JTextField(20);
        JButton calculateButton = new JButton("Calculate Median");
        outputArea = new JTextArea(10, 20);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMedian();
            }
        });

        setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel(new GridLayout(2, 1));
        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.add(new JLabel("Enter space-separated numbers:" + "(do not start with a space)"));
        inputPanel.add(labelPanel);
        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        textPanel.add(inputField);
        inputPanel.add(textPanel);

        add(inputPanel, BorderLayout.NORTH);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        resultPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        add(resultPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
        buttonPanel.add(calculateButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    // The below function finds the median.
    private void calculateMedian() {
        String input = inputField.getText();
        String[] numberStrings = input.split(" ");
        double[] numbers = new double[numberStrings.length];

        for (int i = 0; i < numberStrings.length; i++) {
    //The below code reads the input from the GUI
            try {
                numbers[i] = Double.parseDouble(numberStrings[i]);
            } catch (NumberFormatException e) {
                outputArea.setText("Invalid input. Please enter valid numbers.");
                return;
            }
        }
    // The below line will call bubbleSort function to sort the numbers in acending order. 
        Sorter.bubbleSort(numbers);
        int n = numbers.length;
        double result;
    // The below is the finding median implementation that was given in the pseudo code.
        if (n % 2 == 0) {
            result = (numbers[n / 2 - 1] + numbers[n / 2]) / 2;
        } else {
            result = numbers[n / 2];
        }
    // The below line will output an array of sorted numbers and also the median of the array.
        outputArea.setText("Sorted Array: " + Arrays.toString(numbers) + "\nMedian: " + result);
    }
}