package sortvisualize.gui;

import java.awt.Color;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import sortvisualizer.SortVisualizer;

public class Fenetre extends JFrame {
	
	private ButtonGroup sortGroup;
	private JRadioButtonMenuItem menuBubble;
	private JRadioButtonMenuItem menuMerge;
	private JRadioButtonMenuItem menuQuick;
	
	private SortVisualizer sV = SortVisualizer.getInstance();
	
	Color[] colors = {Color.red, Color.blue, Color.green, Color.yellow, Color.magenta, Color.black};
	
	private static final long serialVersionUID = 1L;
	
	//Constantes de paramétrages
	private final int FRAME_WIDTH 	= 1080;
	private final int FRAME_HEIGHT 	= 720;
	
	
	public Fenetre()
	{
		this.setTitle("Sort visualizer");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocation(0,0);
		this.setResizable(false);
		
		initMenus();
		initCanva();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		JButton reset = new JButton("Reset");
		
		JButton reload = new JButton("Reload");
		reload.addActionListener(ae -> repaint());

		
		sortGroup = new ButtonGroup();
	
		menuBubble = new JRadioButtonMenuItem("Bubble sort");
		menuMerge = new JRadioButtonMenuItem("Merge sort");
		menuQuick = new JRadioButtonMenuItem("Quick sort");
		
		menuBubble.setSelected(true);
		
		algo.add(menuBubble);
		algo.add(menuMerge);
		algo.add(menuQuick);
		
		sortGroup.add(menuBubble);
		sortGroup.add(menuMerge);
		sortGroup.add(menuQuick);
		
		
		barre.add(algo);
		barre.add(start);
		barre.add(reset);
		barre.add(reload);
	
	
		setJMenuBar(barre);
	}
	
	/**
	 * initCanva
	 * Cree un panel qui va permettre de visualiser le tri
	 */
	private void initCanva() 
	{
		
		PanelBar chart = new PanelBar();
		
		int[] array = sV.getArray();
		for(int i = 0; i < array.length; i++)
		{
			chart.addBar(new Color(0f, 0.009f * array[i], 0.01f * array[i]), array[i]);
		}
		

		
		add(chart);
	}

}
