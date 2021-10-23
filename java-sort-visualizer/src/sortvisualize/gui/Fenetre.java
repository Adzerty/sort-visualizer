package sortvisualize.gui;

import java.awt.Color;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import sortvisualizer.SortVisualizer;
import sortvisualizer.sort.BubbleSort;

public class Fenetre extends JFrame {
	
	private static Fenetre instance;
	
	private ButtonGroup sortGroup;
	private JRadioButtonMenuItem menuBubble;
	private JRadioButtonMenuItem menuMerge;
	private JRadioButtonMenuItem menuQuick;
	
	private SortVisualizer sV = SortVisualizer.getInstance();
	
	private PanelBar chart;
	public JLabel lblTpsEcoule = new JLabel("  0s écoulée  ");
		
	private static final long serialVersionUID = 1L;
	
	//Constantes de paramétrages
	private final int FRAME_WIDTH 	= 1600;
	private final int FRAME_HEIGHT 	= 900;
	
	public int WIDTH_BAR = 8;
	public int X_BAR = 20;
	
	
	private Fenetre()
	{
		this.setTitle("Sort visualizer");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocation(0,20);
		this.setResizable(false);
		
		initMenus();
		initCanva();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static Fenetre getInstance() {
		if(instance == null)
		{
			return instance = new Fenetre();
		}
		return instance;
	}
	
	/**
	 * initMenus
	 * Cree une JMenuBar avec tous 
	 */
	
	private void initMenus()
	{
		JMenuBar barre = new JMenuBar();
		JMenu algo = new JMenu("Algorithmes");
		
		JButton start = new JButton("Trier");
		start.addActionListener(ae -> sV.getSortAlgorithm().sort());

		JButton reset = new JButton("Reset");
		reset.addActionListener(ae -> sV.reload());
		

		
		sortGroup = new ButtonGroup();
	
		menuBubble = new JRadioButtonMenuItem("Bubble sort");
		menuBubble.addActionListener(ae -> sV.setSortAlgorithm(new BubbleSort()));
		
		menuMerge = new JRadioButtonMenuItem("Merge sort");
		menuQuick = new JRadioButtonMenuItem("Quick sort");
		
		menuBubble.setSelected(true);
		sV.setSortAlgorithm(new BubbleSort());
		
		algo.add(menuBubble);
		algo.add(menuMerge);
		algo.add(menuQuick);
		
		sortGroup.add(menuBubble);
		sortGroup.add(menuMerge);
		sortGroup.add(menuQuick);
		
		
		barre.add(algo);
		barre.add(start);
		barre.add(reset);
		barre.add(lblTpsEcoule);
	
	
		setJMenuBar(barre);
	}
	
	/**
	 * initCanva
	 * Cree un panel qui va permettre de visualiser le tri
	 */
	
	private void initCanva()
	{
		chart = new PanelBar();
		paintCanva();
		add(chart);
		repaint();
	}
	
	public void paintCanva() 
	{
		int[] array = sV.getArray();
		chart.reset();
		for(int i = 0; i < array.length; i++)
		{
			chart.addBar(new Color(0f, 0.009f * array[i], 0.01f * array[i]), array[i]);
		}
		
		repaint();
	}

}
