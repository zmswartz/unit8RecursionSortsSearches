//********************************************************************
//  KochSnowflakeViewer.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of recursion.
//  @gcschmit (19 July 2014): converted from an applet to an application
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FractalTreeViewer implements ActionListener
{
    private final int WIDTH = 1000;
    private final int HEIGHT = 900;

    private final int MIN = 1, MAX = 30;

    private JButton increase, decrease;
    private JLabel titleLabel, orderLabel;
    private FractalTreePanel drawing;
    private JPanel panel, tools;
    private JFrame frame;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
        public static void main(String[] args)
    {
        FractalTreeViewer viewer = new FractalTreeViewer();
    }
    
    public FractalTreeViewer()
    {
        tools = new JPanel ();
        tools.setLayout (new BoxLayout(tools, BoxLayout.X_AXIS));
        tools.setBackground (Color.yellow);
        tools.setOpaque (true);

        titleLabel = new JLabel ("Fractal Tree");
        titleLabel.setForeground (Color.black);

        increase = new JButton (new ImageIcon ("increase.gif"));
        increase.setPressedIcon (new ImageIcon ("increasePressed.gif"));
        increase.setMargin (new Insets (0, 0, 0, 0));
        increase.addActionListener (this);
        decrease = new JButton (new ImageIcon ("decrease.gif"));
        decrease.setPressedIcon (new ImageIcon ("decreasePressed.gif"));
        decrease.setMargin (new Insets (0, 0, 0, 0));
        decrease.addActionListener (this);
        
        orderLabel = new JLabel ("Order: 20");
        orderLabel.setForeground (Color.black);

        tools.add (titleLabel);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (decrease);
        tools.add (increase);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (orderLabel);
        
        //Starts the order at 20
        drawing = new FractalTreePanel (20);

        panel = new JPanel();
        panel.add (tools);
        panel.add (drawing);

        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }

    //-----------------------------------------------------------------
    //  Determines which button was pushed, and sets the new order
    //  if it is in range.
    //-----------------------------------------------------------------
    public void actionPerformed (ActionEvent event)
    {
        int order = drawing.getOrder();

        if (event.getSource() == increase)
            order++;
        else
            order--;

        if (order >= MIN && order <= MAX)
        {
            orderLabel.setText ("Order: " + order);
            drawing.setOrder (order);
            frame.repaint();
        }
    }
}
