package sortvisualize.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PanelBar extends JPanel
{
	private List<Bar> bars =
			new LinkedList<Bar>();
	
	/**
	 * Add new bar to chart
	 * @param color color to display bar
	 * @param value size of bar
	 */
	public void addBar(Color color, int value)
	{
		bars.add(new Bar(color, value));
	}
	
	public void reset()
	{
		bars = new LinkedList<Bar>() ;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		// determine longest bar
		
		int max = Integer.MIN_VALUE;
		for (Bar b : bars)
		{
			max = Math.max(max, b.getValue());
		}
		
		// paint bars
		
		int width = Fenetre.getInstance().WIDTH_BAR;
		int x = Fenetre.getInstance().X_BAR;
		for (Bar b : bars)
		{
			Color color = b.getColor();
			int value = b.getValue();
			int height = (int) 
                            ((getHeight()-5) * ((double)value / max));
			g.setColor(color);
			g.fillRect(x, getHeight() - height, width, height);
			g.setColor(Color.black);
			g.drawRect(x, getHeight() - height, width, height);
			x += (width + 2);
		}
	}
}

