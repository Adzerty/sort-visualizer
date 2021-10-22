package sortvisualize.gui;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Fenetre extends JFrame {
	
	private JCheckBoxMenuItem menuBubble;
	private JCheckBoxMenuItem menuMerge;
	private JCheckBoxMenuItem menuQuick;
	
	private static final long serialVersionUID = 1L;
	
	private final int FRAME_WIDTH 	= 1080;
	private final int FRAME_HEIGHT 	= 720;
	
	
	
	
	public Fenetre()
	{
		this.setTitle("Test");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocation(0,0);
		this.setResizable(false);
		
		initMenus();
		
		
		
		this.setVisible(true);
	}
	
	/**
	 * initMenus
	 * Cree une JMenuBar avec tous 
	 */
	
	private void initMenus()
	{
		JMenuBar barre = new JMenuBar();
		JMenu algo = new JMenu("Algorithmes");
		
		
		menuBubble = new JCheckBoxMenuItem("Bubble sort");
		menuMerge = new JCheckBoxMenuItem("Merge sort");
		menuQuick = new JCheckBoxMenuItem("Quick sort");
		/*
		ecouteurStyle = new EcouteurStyle();
		menuGras.addActionListener(ecouteurStyle);
		menuItalique.addActionListener(ecouteurStyle);
		menuRouge.addActionListener(ecouteurStyle);
		style.add(menuGras);
		style.add(menuItalique);
		style.add(menuRouge);
		barre.add(style);
		*/
		
		setJMenuBar(barre);
	}

}
