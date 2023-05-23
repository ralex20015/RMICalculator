package ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButtonUI extends BasicButtonUI {
    @Override
    public void paint(Graphics g, javax.swing.JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D roundedRect = new RoundRectangle2D.Float(
                0, 0, c.getWidth() - 1, c.getHeight() - 1, 20, 20);

        JButton b = (JButton) c;
        if (b.getModel().isPressed()) {
            g2d.setColor(b.getBackground().darker());
        } else if (b.getModel().isRollover()) {
            g2d.setColor(b.getBackground().brighter());
        } else {
            g2d.setColor(b.getBackground());
        }

        g2d.fill(roundedRect);

        super.paint(g, c);
    }
}
