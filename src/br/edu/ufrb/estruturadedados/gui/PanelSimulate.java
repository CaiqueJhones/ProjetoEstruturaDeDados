package br.edu.ufrb.estruturadedados.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import br.edu.ufrb.estruturadedados.Estrutura;
import br.edu.ufrb.estruturadedados.gui.component.ElementView;
import br.edu.ufrb.estruturadedados.gui.component.ElementViewDuplo;
import br.edu.ufrb.estruturadedados.lista.Fila;
import br.edu.ufrb.estruturadedados.lista.Lista;
import br.edu.ufrb.estruturadedados.lista.ListaDuplaEncadeada;
import br.edu.ufrb.estruturadedados.lista.ListaSimplesEncadeada;
import br.edu.ufrb.estruturadedados.lista.Pilha;

@SuppressWarnings("serial")
public class PanelSimulate extends JPanel {

	private JSpinner spInsert;
	private JSpinner spIndexGet;
	private JSpinner spIndexRemove;
	
	private Estrutura<ElementView<Integer>> estrutura;
	private JPanel panelView;
	
	private StructType type; 
	private int iterable;
	private JButton btnRemove;
	private JButton btnGet;
	private JButton btnInsert;
	
	/**
	 * Create the panel.
	 */
	public PanelSimulate(StructType type) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(5, 5));
		
		panelView = new JPanel();
		panelView.setBackground(Color.white);
		panelView.setLayout(null);
		panelView.setSize(100, 100);
		panelView.setPreferredSize(panelView.getPreferredSize());
		JScrollPane scrollPane = new JScrollPane(panelView);
		add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelForm = new JPanel();
		panelForm.setBorder(new TitledBorder(""));
		add(panelForm, BorderLayout.SOUTH);
		panelForm.setLayout(new GridLayout(3, 3, 5, 5));
		
		createPanelForm(panelForm);
		
		start(type);
		
	}

	private void createPanelForm(JPanel panelForm) {
		JLabel lblInsert = new JLabel(Messages.getString("PanelSimulate.lblInsert.text"));
		lblInsert.setHorizontalAlignment(SwingConstants.RIGHT);
		panelForm.add(lblInsert);
		
		spInsert = new JSpinner();
		spInsert.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		panelForm.add(spInsert);
		
		btnInsert = new JButton(Messages.getString("PanelSimulate.btnInsert.text"));
		btnInsert.addActionListener(e -> {
			Integer v = (Integer) spInsert.getValue();
			ElementView<Integer> view = new ElementView<>(v);
			switch (type) {
			case LISTA_S: 
				((Lista<ElementView<Integer>>) estrutura).add(view);
				break;
			case LISTA_D:
				view = new ElementViewDuplo<>(v);
				((Lista<ElementView<Integer>>) estrutura).add(view);
				break;
			case PILHA:
				((Pilha<ElementView<Integer>>) estrutura).push(view);
				break;
			case FILA:
				((Fila<ElementView<Integer>>) estrutura).push(view);
				break;
			default:
				break;
			}
			((SpinnerNumberModel) spIndexRemove.getModel()).setMaximum(estrutura.size()-1);
			((SpinnerNumberModel) spIndexGet.getModel()).setMaximum(estrutura.size()-1);
			fillView();
		});
		panelForm.add(btnInsert);
		
		JLabel lblIndex = new JLabel(Messages.getString("PanelSimulate.lblIndex.text")); 
		lblIndex.setHorizontalAlignment(SwingConstants.RIGHT);
		panelForm.add(lblIndex);
		
		spIndexGet = new JSpinner();
		spIndexGet.setModel(new SpinnerNumberModel(0, 0, 0, 1));
		panelForm.add(spIndexGet);
		
		btnGet = new JButton(Messages.getString("PanelSimulate.btnGet.text"));
		btnGet.addActionListener(e -> {
			int v = (Integer) spIndexGet.getValue();
			ElementView<Integer> value = null;
			try {
				switch (type) {
				case LISTA_S: 
					value = ((Lista<ElementView<Integer>>) estrutura).get(v);
					break;
				case LISTA_D:
					value = ((Lista<ElementView<Integer>>) estrutura).get(v);
					break;
				case PILHA:
					value = ((Pilha<ElementView<Integer>>) estrutura).get(v);
					break;
				case FILA:
					value = ((Fila<ElementView<Integer>>) estrutura).get(v);
					break;
				default:
					break;
				}
				JOptionPane.showMessageDialog(panelView, "Valor: "+value.getValue());
			} catch(ArrayIndexOutOfBoundsException error) {
				
			}
		});
		panelForm.add(btnGet);
		
		JLabel lblIndex_1 = new JLabel(Messages.getString("PanelSimulate.lblIndex_1.text")); 
		lblIndex_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panelForm.add(lblIndex_1);
		
		spIndexRemove = new JSpinner();
		spIndexRemove.setModel(new SpinnerNumberModel(0, 0, 0, 1));
		panelForm.add(spIndexRemove);
		
		btnRemove = new JButton(Messages.getString("PanelSimulate.btnRemove.text"));
		btnRemove.addActionListener(e -> {
			int v = (Integer) spIndexGet.getValue();
			try {
				switch (type) {
				case LISTA_S: 
					((Lista<ElementView<Integer>>) estrutura).remove(v);
					break;
				case LISTA_D:
					((Lista<ElementView<Integer>>) estrutura).remove(v);
					break;
				case PILHA:
					((Pilha<ElementView<Integer>>) estrutura).pop();
					break;
				case FILA:
					((Fila<ElementView<Integer>>) estrutura).remove();
					break;
				default:
					break;
				}
				SpinnerNumberModel m1 =  (SpinnerNumberModel) spIndexGet.getModel();
				m1.setMaximum(estrutura.size()-1);
				m1.setValue(0);
				SpinnerNumberModel m2 = (SpinnerNumberModel) spIndexRemove.getModel();
				m2.setMaximum(estrutura.size()-1);
				m2.setValue(0);
				fillView();
			}catch(ArrayIndexOutOfBoundsException error) {
				
			}
		});
		panelForm.add(btnRemove);
	}
	
	public void start(StructType type) {
		this.type = type;
		btnInsert.setEnabled(true);
		btnGet.setEnabled(true);
		btnRemove.setEnabled(true);
		switch (type) {
		case LISTA_S:
			estrutura = new ListaSimplesEncadeada<>();
			spIndexRemove.setEnabled(true);
			break;
		case LISTA_D:
			estrutura = new ListaDuplaEncadeada<>(); 
			spIndexRemove.setEnabled(true);
			break;
		case PILHA:
			estrutura = new Pilha<>(); 
			spIndexRemove.setEnabled(false);
			break;
		case FILA:
			estrutura = new Fila<>(); 
			spIndexRemove.setEnabled(false);
			break;
		default:
			btnInsert.setEnabled(false);
			btnGet.setEnabled(false);
			btnRemove.setEnabled(false);
			return;
		}
		spIndexRemove.setValue(0);
		spIndexGet.setValue(0);
		fillView();
	}
	
	public void fillView(){
		panelView.removeAll();
		iterable = 0;
		estrutura.forEach(view -> {
			view.setSize(200, 200);
			view.setLocation(50, 10+(iterable*80));
			panelView.add(view);
			iterable++;
		});
		panelView.setSize(300, 90*iterable);
		panelView.setPreferredSize(panelView.getSize());
		panelView.repaint();
	}
	
}
