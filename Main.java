/**
 * This code is the main function that calls MedianCalculatorGUI.
 */
import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MedianCalculatorGUI();
            }
        });
    }
}