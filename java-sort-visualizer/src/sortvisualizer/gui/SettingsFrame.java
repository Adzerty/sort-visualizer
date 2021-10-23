package sortvisualizer.gui;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import sortvisualizer.SortVisualizer;
import sortvisualizer.sort.BubbleSort;

import java.awt.GridLayout;
import java.util.Hashtable;
import java.awt.Font;

public class SettingsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JSlider sliderSizeArray;
	private JSlider sliderWidthBar;
	private JSlider sliderXBar;
	private JSlider sliderTime;


	private static SettingsFrame instance;
	private SortVisualizer sV = SortVisualizer.getInstance();


	private final int FRAME_WIDTH 	= 300;
	private final int FRAME_HEIGHT 	= 900;
	
	
	private final int SLIDER_SIZE_ARRAY_MIN = 0;
	private final int SLIDER_SIZE_ARRAY_MAX = 5000;
	private final int SLIDER_SIZE_ARRAY_VAL = 200;
	
	private final int SLIDER_WIDTH_BAR_MIN = 0;
	private final int SLIDER_WIDTH_BAR_MAX = 100;
	private final int SLIDER_WIDTH_BAR_VAL = 8;
	
	private final int SLIDER_X_BAR_MIN = 1;
	private final int SLIDER_X_BAR_MAX = 250;
	private final int SLIDER_X_BAR_VAL = 20;
	
	private final int SLIDER_TIME_MIN = 0;
	private final int SLIDER_TIME_MAX = 1000;
	private final int SLIDER_TIME_VAL = 1;
	
	
	private JLabel lblArray = new JLabel("Nombre de barres : " + SLIDER_SIZE_ARRAY_VAL);
	private JLabel lblBar = new JLabel("Largeur des barres : " + SLIDER_WIDTH_BAR_VAL + "px");
	private JLabel lblX = new JLabel("Décalage à gauche des barres : " + SLIDER_X_BAR_VAL + "px");
	private JLabel lblTime = new JLabel("Pas de temps : " + SLIDER_TIME_VAL + "ms");
	
	public SettingsFrame()
	{
		this.setTitle("Paramètres");
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLocation(1600,20);
		this.setResizable(false);
		this.setLayout(new GridLayout(8,1));
		
		initSliders();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static SettingsFrame getInstance() {
		if(instance == null)
		{
			return instance = new SettingsFrame();
		}
		return instance;
	}
	
	private void initSliders()
	{
		sliderSizeArray 	= new JSlider(SLIDER_SIZE_ARRAY_MIN, SLIDER_SIZE_ARRAY_MAX, SLIDER_SIZE_ARRAY_VAL);
		sliderWidthBar 		= new JSlider(SLIDER_WIDTH_BAR_MIN, SLIDER_WIDTH_BAR_MAX, SLIDER_WIDTH_BAR_VAL);
		sliderXBar 			= new JSlider(SLIDER_X_BAR_MIN, SLIDER_X_BAR_MAX, SLIDER_X_BAR_VAL);
		sliderTime 			= new JSlider(SLIDER_TIME_MIN, SLIDER_TIME_MAX, SLIDER_TIME_VAL);
		
		sliderSizeArray.setMajorTickSpacing(100);
		sliderSizeArray.setPaintTicks(true);
		//Create the label table
		Hashtable<Integer, JLabel> labelTableSize = new Hashtable<>();
		labelTableSize.put( SLIDER_SIZE_ARRAY_MIN , new JLabel(""+SLIDER_SIZE_ARRAY_MIN) );
		labelTableSize.put( SLIDER_SIZE_ARRAY_MAX/2 , new JLabel(""+SLIDER_SIZE_ARRAY_MAX/2) );
		labelTableSize.put( SLIDER_SIZE_ARRAY_MAX , new JLabel(""+SLIDER_SIZE_ARRAY_MAX) );
		sliderSizeArray.setLabelTable( labelTableSize );
		sliderSizeArray.setPaintLabels(true);
		sliderSizeArray.addChangeListener(ce ->{
			lblArray.setText("Nombre de barres : " + sliderSizeArray.getValue());
			sV.ARRAY_SIZE = sliderSizeArray.getValue();
			sV.reload();
		});    
		
		sliderWidthBar.setMajorTickSpacing(10);
		sliderWidthBar.setPaintTicks(true);
		//Create the label table
		Hashtable<Integer, JLabel> labelTableWidth = new Hashtable<>();
		labelTableWidth.put( SLIDER_WIDTH_BAR_MIN , new JLabel(""+SLIDER_WIDTH_BAR_MIN) );
		labelTableWidth.put( SLIDER_WIDTH_BAR_MAX/2 , new JLabel(""+SLIDER_WIDTH_BAR_MAX/2) );
		labelTableWidth.put(  SLIDER_WIDTH_BAR_MAX , new JLabel(""+SLIDER_WIDTH_BAR_MAX) );
		sliderWidthBar.setLabelTable( labelTableWidth );
		sliderWidthBar.setPaintLabels(true);
		sliderWidthBar.addChangeListener(ce -> {
			lblBar.setText("Largeur des barres : " + sliderWidthBar.getValue() + "px");
			Fenetre f = Fenetre.getInstance();
			f.WIDTH_BAR = sliderWidthBar.getValue();
			f.paintCanva();
		});
		
		
		
		sliderXBar.setMajorTickSpacing(10);
		sliderXBar.setPaintTicks(true);
		//Create the label table
		Hashtable<Integer, JLabel> labelTableX = new Hashtable<>();
		labelTableX.put( SLIDER_X_BAR_MIN , new JLabel(""+SLIDER_X_BAR_MIN) );
		labelTableX.put( SLIDER_X_BAR_MAX/2 , new JLabel(""+SLIDER_X_BAR_MAX/2) );
		labelTableX.put( SLIDER_X_BAR_MAX , new JLabel(""+SLIDER_X_BAR_MAX) );
		sliderXBar.setLabelTable( labelTableX );
		sliderXBar.setPaintLabels(true);
		sliderXBar.addChangeListener(ce -> {
			lblX.setText("Décalage à gauche des barres : " + sliderXBar.getValue() + "px");
			Fenetre f = Fenetre.getInstance();
			f.X_BAR = sliderXBar.getValue();
			f.paintCanva();
		});
		
		sliderTime.setMajorTickSpacing(100);
		sliderTime.setPaintTicks(true);
		//Create the label table
		Hashtable<Integer, JLabel> labelTableTime = new Hashtable<>();
		labelTableTime.put( SLIDER_TIME_MIN , new JLabel(""+SLIDER_TIME_MIN) );
		labelTableTime.put( SLIDER_TIME_MAX/2 , new JLabel(""+SLIDER_TIME_MAX/2) );
		labelTableTime.put( SLIDER_TIME_MAX , new JLabel(""+SLIDER_TIME_MAX) );
		sliderTime.setLabelTable( labelTableTime );
		sliderTime.setPaintLabels(true);
		sliderTime.addChangeListener(ce ->{
			lblTime.setText("Pas de temps : " + sliderTime.getValue()+"ms");
			sV.TIME = sliderTime.getValue();
		});
		
		add(sliderSizeArray);
		add(lblArray);
		add(sliderWidthBar);
		add(lblBar);
		add(sliderXBar);
		add(lblX);
		add(sliderTime);
		add(lblTime);
	}

}
