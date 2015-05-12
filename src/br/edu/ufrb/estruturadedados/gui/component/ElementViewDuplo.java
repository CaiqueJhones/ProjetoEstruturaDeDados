package br.edu.ufrb.estruturadedados.gui.component;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class ElementViewDuplo<E> extends ElementView<E> {
		
	private static final long serialVersionUID = 8199856891273993700L;
	
	public ElementViewDuplo() {
		super();
	}

    public ElementViewDuplo(E value) {
    	super(value);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.drawLine(0, 55, 60, 55);
        drawRect(g, 0, 40, 60, 60);
        drawArrow(g, 40, 90, 40, 145);
        drawArrow(g, 20, 50, 20, 0);
    }

}
