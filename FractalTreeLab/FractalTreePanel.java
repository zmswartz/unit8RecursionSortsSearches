//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class FractalTreePanel extends JPanel
{
    private final int PANEL_WIDTH = 400;
    private final int PANEL_HEIGHT = 400;

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
        int x2, y2, x3, y3;
        totalAngle += angle;
        double sinValue = Math.sin(Math.toRadians(totalAngle));
        double cosValue = Math.cos(Math.toRadians(totalAngle));
        double deltaX = sinValue * length;
        double deltaY = cosValue * length;
        x2 = x1 + (int)deltaX;
        y2 = y1 - (int)deltaY;
        x3 = x1 - (int)deltaX;
        y3 = y1 - (int)deltaY;
        if (order == 1)
        {
            page.drawLine(x1, y1, x2, y2);
            page.drawLine(x1, y1, x3, y3);
        }
           
        else
        {
            page.drawLine(x1, y1, x2, y2);
            page.drawLine(x1, y1, x3, y3);
            drawFractal (order-1, x2, y2, page,length, totalAngle, angle);
            drawFractal (order-1, x3, y3, page, length, totalAngle, angle-1);
        }
    }

    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);

        page.setColor (Color.green);

                 drawFractal (current, 200, 400, page, 10, 0 , 5);
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
