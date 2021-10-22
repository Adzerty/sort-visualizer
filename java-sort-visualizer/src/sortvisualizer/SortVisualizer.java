package sortvisualizer;

import java.util.Random;

/**
 * 
 * @author Adrien
 * Classe métier de mon application
 */
public class SortVisualizer {
	private final int ARRAY_SIZE 	= 50;
	private final int MAX_VALUE 	= 100;
	private final int MIN_VALUE		= 1;
	
	//Design pattern singleton
	private static SortVisualizer instance;
	
	private int[] array;
	
	public SortVisualizer(){
		Random r = new Random();
		array = new int[ARRAY_SIZE];
		
		for(int i = 0; i<ARRAY_SIZE; i++){
			int value = r.nextInt(MAX_VALUE-MIN_VALUE) + MIN_VALUE;
			array[i] = value;
		}		
	}

	public static SortVisualizer getInstance() {
		if(instance == null)
		{
			return instance = new SortVisualizer();
		}
		return instance;
	}
	
	public int[] getArray() {
		return array;
	}
}
