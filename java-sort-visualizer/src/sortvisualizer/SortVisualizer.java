package sortvisualizer;

import java.util.Random;

import sortvisualize.gui.Fenetre;
import sortvisualizer.sort.Sort;

/**
 * 
 * @author Adrien
 * Classe métier de mon application
 */
public class SortVisualizer {
	public int ARRAY_SIZE 	= 150;
	public int MAX_VALUE 	= 100;
	public int MIN_VALUE	= 1;
	public int TIME 		= 1;
	
	private Thread tSort;
	
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
	
	public void reload() {
		if(tSort != null)stopThreadSort();
		Random r = new Random();
		array = new int[ARRAY_SIZE];
		
		for(int i = 0; i<ARRAY_SIZE; i++){
			int value = r.nextInt(MAX_VALUE-MIN_VALUE) + MIN_VALUE;
			array[i] = value;
		}
		
		Fenetre f = Fenetre.getInstance();
		f.paintCanva();
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
	
	public void settSort(Thread tSort) {
		this.tSort = tSort;
	}
	
	public void stopThreadSort()
	{
		this.tSort.stop();
	}
}
