package sortvisualizer;

import java.util.Random;

import sortvisualizer.sort.Sort;

/**
 * 
 * @author Adrien
 * Classe métier de mon application
 */
public class SortVisualizer {
	private final int ARRAY_SIZE 	= 10;
	private final int MAX_VALUE 	= 100;
	private final int MIN_VALUE		= 1;
	
	//Design pattern singleton
	private static SortVisualizer instance;
	
	private int[] array;
	
	private Sort sortAlgorithm;
	
	private SortVisualizer(){
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
	
	public void setArray(int[] array) {
		this.array = array;
	}
	
	public void setSortAlgorithm(Sort sortAlgorithm) {
		this.sortAlgorithm = sortAlgorithm;
	}
	
	public Sort getSortAlgorithm() {
		return sortAlgorithm;
	}
}
