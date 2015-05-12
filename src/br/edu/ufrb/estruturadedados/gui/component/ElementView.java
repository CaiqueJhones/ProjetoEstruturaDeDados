package br.edu.ufrb.estruturadedados.gui.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

public class ElementView<E> extends JComponent {
	
	private static final long serialVersionUID = -3488939584479470690L;

	private final int ARR_SIZE = 4;
	
	protected E value;
	
	public ElementView() {
		super();
	}

    public ElementView(E value) {
    	super();
		this.value = value;
	}

	protected void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {
        Graphics2D g = (Graphics2D) g1.create();

        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy);
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
                      new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
    }
	
	protected void drawRect(Graphics g1, int x1, int y1, int x2, int y2) {
		Graphics2D g = (Graphics2D) g1.create();
		
		Rectangle2D rectangle = new Rectangle2D.Float(x1, y1, x2, y2);
		Line2D line = new Line2D.Float(x1, y1+y2-15, (float) (x1+rectangle.getWidth()), y1+y2-15);
		
		int x = (int) (rectangle.getCenterX()-5);
		int y = (int) (rectangle.getCenterY()+5);
		
		g.draw(rectangle);
		g.draw(line);
		g.drawString(value.toString(), x, y);
	}
	
	public void paintComponent(Graphics g) {
        drawRect(g, 0, 0, 60, 60);
        drawArrow(g, 30, 50, 30, 100);
    }
	
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		repaint();
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

}
