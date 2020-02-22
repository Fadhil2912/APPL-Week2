/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CirclePanel extends JPanel
{
    private final int CIRCLE_SIZE = 50;
    private int x,y;
    private Color c;
    private int width, height;
    private JButton left, right, up, down;
    
    //---------------------------------------------------------------
    // Set up circle and buttons to move it.
    //---------------------------------------------------------------
    public CirclePanel(int width, int height)
    {
        //set width and height
        this.height = height;
        this.width = width;
        // Set coordinates so circle starts in middle
        x = (width/2)-(CIRCLE_SIZE/2);
        y = (height/2)-(CIRCLE_SIZE/2);
        c = Color.green;
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        
        // Create buttons to move the circle
        //left
        left = new JButton("Left");
        left.setMnemonic('l');
        left.setToolTipText("The circle move to the left by 20");
        
        //right
        right = new JButton("Right");
        right.setMnemonic('r');
        right.setToolTipText("The circle move to the right by 20");
        
        //up
        up = new JButton("Up");
        up.setMnemonic('u');
        up.setToolTipText("The circle move to the up by 20");
        
        //down
        down = new JButton("Down");
        down.setMnemonic('d');
        down.setToolTipText("The circle move to the down by 20");
        
        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20,0));
        right.addActionListener(new MoveListener(20,0));
        up.addActionListener(new MoveListener(0,-20));
        down.addActionListener(new MoveListener(0,20));
        
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);
        
        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
    }
    
    //---------------------------------------------------------------
    // Draw circle on CirclePanel
    //---------------------------------------------------------------
    public void paintComponent(Graphics page)
    {
        
    super.paintComponent(page);
    page.setColor(c);
    page.fillOval(x,y,CIRCLE_SIZE,CIRCLE_SIZE);
    }
    
    //---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    //---------------------------------------------------------------
    private class MoveListener implements ActionListener
    {
        private int dx;
        private int dy;
        private boolean kondisi_kiri = false;
        
        //---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        //---------------------------------------------------------------
        public MoveListener(int dx, int dy)
        {
        this.dx = dx;
        this.dy = dy;
        }
        
        //---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        //---------------------------------------------------------------
        public void actionPerformed(ActionEvent e)
        {
            //right
            if(x + dx + (CIRCLE_SIZE + CIRCLE_SIZE / 2) >= width){
              right.setEnabled(false);
            }else{
                right.setEnabled(true);
            }
            
            //left
            if(x + dx  <= 0){
                kondisi_kiri = true;
                x = 0;
              left.setEnabled(false);
            }else{
                kondisi_kiri = false;
                left.setEnabled(true);
            }
            
            //down
           if(y + dy + (CIRCLE_SIZE * 3) >= height){
              down.setEnabled(false);
            }
           else{
               down.setEnabled(true);
           }
            
           //up
            if(y + dy <= 0){
                
              y = 0;
              up.setEnabled(false);
            }else{
                if(kondisi_kiri == false){
                    x += dx;
                    y += dy;
                    up.setEnabled(true);
                }
                
            }          
                repaint();        
        }
    }
}
