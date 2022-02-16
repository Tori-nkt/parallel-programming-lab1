package com.company.Pool;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Pocket {
    private Component canvas;
    private static final int XSIZE = 40;
    private static final int YSIZE = 40;
    public static int x = 195;
    public static int y = 130;

    public Pocket(Component c) {
        this.canvas = c;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }
}
