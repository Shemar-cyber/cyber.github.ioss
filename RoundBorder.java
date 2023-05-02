package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

public class RoundBorder extends AbstractBorder {

	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		int arc = 20;
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(c.getBackground());
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillRoundRect(x, y, width - 1, height - 1, arc, arc);
		g2d.setColor(Color.blue);
		g2d.drawRoundRect(x, y, width -1, height - 1, arc, arc);
		g2d.dispose();
	}

	public Insets getBorderInsets(Component c) {
		return new Insets(4, 8, 4, 8);
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		insets.left = insets.right = 8;
		insets.top = insets.bottom = 4;
		return insets;
	}

	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return false;
	}

}
