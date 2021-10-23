package sortvisualizer.gui;

import java.awt.Color;

public class Bar {
	private Color color;
	private int value;
	
	public Bar(Color c, int v) {
		this.color = c;
		this.value = v;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getValue() {
		return value;
	}
}
