package temperatureconverterjavaswing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TemperatureConverterJavaSwing {
    // Text labels for jframe window
    private final JLabel celsius;
    private final JLabel directions;
    private final JLabel inputLabel;
    private final JLabel outputLabel;
    
    // iput text field
    private final JTextField fahrenheit;
    
    // Frame size
    private final int WIDTH = 350;
    private final int HEIGHT = 150;

  public TemperatureConverterJavaSwing() {
        // Create new Jframe container
        JFrame jfrm = new JFrame("Temperature Converter");

        // Set layout
        jfrm.setLayout(new FlowLayout());
//        jfrm.setBackground(Color.blue);
        
        // Initial frame size
        jfrm.setSize(WIDTH, HEIGHT);

        // Kill the program when user closes the application
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a text labels
        directions = new JLabel("Enter the temperature then click enter");
        inputLabel = new JLabel("Temperature in Fahrenheit");
        outputLabel = new JLabel("Temperature in Celsius: ");
        celsius = new JLabel("");
        
        fahrenheit = new JTextField(6);
        fahrenheit.addActionListener(new TempListener());
        
        // Add the labels to the content pane
        jfrm.add(directions);
        jfrm.add(inputLabel);
        jfrm.add(fahrenheit);
        jfrm.add(outputLabel);
        jfrm.add(celsius);
        
        // Display the frame
        jfrm.setVisible(true);
  }

  private class TempListener implements ActionListener {
      // Converts the user entered temperature
    @Override
    public void actionPerformed(ActionEvent event) throws NumberFormatException {
        double celsiusTemp;
        double fahrenheitTemp;
        try {
            String text = fahrenheit.getText();
            fahrenheitTemp = Double.parseDouble(text);
            celsiusTemp = Math.round((fahrenheitTemp - 32) * 5 / 9);
            celsius.setText(Double.toString(celsiusTemp));
        } catch (NumberFormatException e) {
            celsius.setText("please enter a number");
            System.err.println("NumberFormatException in TempListener: " + e.getMessage());
        }
    }
  }
  
  public static void main(String args[]) {
        // Create the frame on the event dispatching thread
        SwingUtilities.invokeLater(() -> {
            new TemperatureConverterJavaSwing();
        });
    }
  
}

