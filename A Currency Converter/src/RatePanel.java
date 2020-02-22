/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RatePanel extends JPanel {
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result;
    JComboBox <String> currencyList;
    JTextField t1;
    GridLayout layout;
    
    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel ()
    {
        JLabel title = new JLabel ("           How much is that in dollars?            \n\n");
        JLabel enter = new JLabel("\n\n");


        
        title.setAlignmentX (Component.CENTER_ALIGNMENT);
        title.setFont (new Font ("Helvetica", Font.BOLD, 20));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        // Set up the arrays for the currency conversions
        currencyName = new String[] {"Select the currency..",
        "European Euro", "Canadian Dollar",
        "Japanese Yen", "Australian Dollar",
        "Indian Rupee", "Mexican Peso"};
        
        currencyList = new JComboBox<>(currencyName);
     
        t1 = new JTextField("0");
        t1.setColumns(10);
        t1.addActionListener(new ComboListener());
        t1.setAlignmentX(CENTER_ALIGNMENT);
        t1.setSize(200, 20);
        rate = new double [] {0.0, 1.2103, 0.7351,
        0.0091, 0.6969,
        0.0222, 0.0880};
        result = new JLabel (" ------------ ");
        currencyList.setAlignmentX(CENTER_ALIGNMENT);
        result.setAlignmentX(CENTER_ALIGNMENT);
        add (Box.createRigidArea(new Dimension(0,5)));
        add(title);
        add(enter);
        add (Box.createRigidArea(new Dimension(0,10)));
        add(currencyList);
        add (Box.createRigidArea(new Dimension(0,15)));
        add(t1);
        add (Box.createRigidArea(new Dimension(0,20)));
        add (result);
        
    }
    
    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener
    {
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        public void actionPerformed (ActionEvent event)
        {
            try{
                int value = Integer.parseInt(t1.getText());
                int index = currencyList.getSelectedIndex();
                double dollar_value = value * rate[index];
                result.setText (value + " " +  currencyName[index] +
                " = " + dollar_value + " U.S. Dollars");
            }catch(NumberFormatException ex){
               JOptionPane.showMessageDialog(null, "Invalid Input");
            }
        }
    }
}
