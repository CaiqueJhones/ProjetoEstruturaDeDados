package br.edu.ufrb.estruturadedados.gui;

import static br.edu.ufrb.estruturadedados.gui.Messages.getString;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.edu.ufrb.estruturadedados.gui.component.TreeModel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private TreeModel model;

	private PanelWhat panelWhat;
	private PanelSimulate panelSimulate;
	private PanelCode panelCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(5, 5));
		setContentPane(contentPane);

		createMenu();

		panelWhat = new PanelWhat();
		panelSimulate = new PanelSimulate(StructType.LISTA_S);
		panelCode = new PanelCode();

		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("O que é?", panelWhat);
		tabbedPane.addTab("Simulação", panelSimulate);
		tabbedPane.addTab("Código", panelCode);

		getContentPane().add(tabbedPane);

		model = new TreeModel(Arrays.asList(StructType.LISTA_S,
				StructType.LISTA_D, StructType.FILA, StructType.PILHA,
				StructType.ARVORE_BIN, StructType.ARVORE_B,
				StructType.ARVORE_AVL, StructType.ORDENACAO));
		JTree tree = new JTree();
		tree.setModel(model);
		contentPane.add(tree, BorderLayout.WEST);

		tree.addTreeSelectionListener(t -> {
			Object select = tree.getLastSelectedPathComponent();
			if (model.isLeaf(select)) {
				open((StructType) select);
			}
		});

		tree.setSelectionRow(1);
		open(StructType.LISTA_S);

		// pack();

	}

	public void open(StructType type) {
		// String folder = "br.edu.ufrb.estruturadedados.gui.";
		String fileDesc = type.text.toLowerCase().replace(" ", "_") + ".txt";
		try (Scanner s = new Scanner(getClass().getResourceAsStream(fileDesc))) {
			StringBuilder b = new StringBuilder();
			while (s.hasNextLine()) {
				String line = s.nextLine();
				if (!line.equals("{@code}")) {
					b.append(line + "\n");
				} else
					break;
			}

			panelWhat.setText(b.toString());

			b = new StringBuilder();
			while (s.hasNextLine()) {
				b.append(s.nextLine() + "\n");
			}

			panelCode.setText(b.toString());

			panelSimulate.start(type);
		}
	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu(getString("file"));
		menuBar.add(mnFile);

		JMenuItem mntmHelp = new JMenuItem(
				getString("MainFrame.mntmAbout.text"));
		mntmHelp.addActionListener(e -> JOptionPane
				.showMessageDialog(
						this, getString("MainFrame.mntmAbout.message"),
						getString("MainFrame.mntmAbout.text"), JOptionPane.INFORMATION_MESSAGE));
		mnFile.add(mntmHelp);

		JMenuItem mntmExit = new JMenuItem(getString("MainFrame.mntmExit.text"));
		mntmExit.addActionListener(e -> System.exit(0));
		mnFile.add(mntmExit);
	}

}
