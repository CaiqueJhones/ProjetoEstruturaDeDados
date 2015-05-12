package br.edu.ufrb.estruturadedados.gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class PanelWhat extends JPanel {

	private JTextPane textPane;

	/**
	 * Create the panel.
	 */
	public PanelWhat() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setContentType("text/html");
		add(new JScrollPane(textPane), BorderLayout.CENTER);
		
	}
	
	public void setText(String text) {
		textPane.setText(text);
	}

}
