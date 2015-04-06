//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class FractalTreePanel extends JPanel
{
    private final int PANEL_WIDTH = 1000;
    private final int PANEL_HEIGHT = 800;

    private final double SQ = Math.sqrt(3.0) / 6;

    private final int TOPX = 200, TOPY = 20;
    private final int LEFTX = 60, LEFTY = 300;
    private final int RIGHTX = 340, RIGHTY = 300;

    private int current; //current order

    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public FractalTreePanel (int currentOrder)
    {
        current = currentOrder;
        setBackground (Color.black);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    public void drawFractal (int order, int x1, int y1,Graphics page, int length,
    double totalAngle, double angle)
    {
        if (length <= 5 || order == 1  )
        {
            return;
        }

        else
        {
            int x2, y2, x3, y3;
            
            double sinValue = Math.sin(Math.toRadians(totalAngle+angle));
            double cosValue = Math.cos(Math.toRadians(totalAngle+angle));
            double deltaX = sinValue * length;
            double deltaY = cosValue * length;
            x2 = x1 + (int)deltaX;
            y2 = y1 - (int)deltaY;
            sinValue = Math.sin(Math.toRadians(totalAngle-angle));
            cosValue = Math.cos(Math.toRadians(totalAngle-angle));
            deltaX = sinValue * length;
            deltaY = cosValue * length;
            x3 = x1 + (int)deltaX;
            y3 = y1 - (int)deltaY;
            
            page.drawLine(x1, y1, x2, y2);
            page.drawLine(x1, y1, x3, y3);
            drawFractal (order-1, x2, y2, page, (int) (length*.9), totalAngle+angle, angle);
            drawFractal (order-1, x3, y3, page, (int) (length*.9), totalAngle-angle, angle);
        }
    }

    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);

        page.setColor (Color.green);

        
        drawFractal (current, 500, 700, page, 50, 0 , 10);
    }

    //-----------------------------------------------------------------
    //  Sets the fractal order to the value specified.
    //-----------------------------------------------------------------
    public void setOrder (int order)
    {
        current = order;
    }

    //-----------------------------------------------------------------
    //  Returns the current order.
    //-----------------------------------------------------------------
    public int getOrder ()
    {
        return current;
    }
}
