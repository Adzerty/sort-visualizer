package sortvisualizer.sort;

import sortvisualizer.SortVisualizer;
import sortvisualizer.gui.Fenetre;

public class QuickSort implements Sort {

	@Override
	public void sort() {
		Thread t = new Thread() {
		      public void run() {
	    	  	SortVisualizer sV = SortVisualizer.getInstance(); 	//Récupération de la classe métier
	    	  	Fenetre f = Fenetre.getInstance();					//Récupération de la classe vue
	    	  	sV.settSort(this);									//On affecte le thread de sort pour pouvoir le stopper en cas de reset
	    	  	
				int[] array2Sort = sV.getArray();					//On récupère le tableau à trier
				
				long start = System.currentTimeMillis();			//On récupère le temps au début du tri
				
				//Algorithme de tri de fusion
				quickSort(array2Sort, 0, array2Sort.length-1);
				
				
				long finish = System.currentTimeMillis();			//On récupère le temps à la fin du tri
				long timeElapsed = finish - start;					//On calcule le temps écoulé
				f.lblTpsEcoule.setText("  "+timeElapsed/1000f+"s écoulées  "); 
				
				sV.setArray(array2Sort);
		      }
		    };
		t.start();

	}

	private void quickSort(int[] array2Sort, int low, int high) {
		SortVisualizer sV = SortVisualizer.getInstance(); 
	  	Fenetre f = Fenetre.getInstance();
		if (low < high) 
	    {
	          
	        // pi is partitioning index, arr[p]
	        // is now at right place 
	        int pi = partition(array2Sort, low, high);
	  
	        // Separately sort elements before
	        // partition and after partition
	        quickSort(array2Sort, low, pi - 1);
	        quickSort(array2Sort, pi + 1, high);
	        
	        try {
				Thread.sleep(sV.TIME);				
			} catch (InterruptedException e) {}
			f.paintCanva();
	    }
		
	}
	
	private int partition(int[] arr, int low, int high)
	{
	      
	    // pivot
	    int pivot = arr[high]; 
	      
	    // Index of smaller element and
	    // indicates the right position
	    // of pivot found so far
	    int i = (low - 1); 
	  
	    for(int j = low; j <= high - 1; j++)
	    {
	          
	        // If current element is smaller 
	        // than the pivot
	        if (arr[j] < pivot) 
	        {
	              
	            // Increment index of 
	            // smaller element
	            i++; 
	            swap(arr, i, j);
	        }
	    }
	    swap(arr, i + 1, high);
	    return (i + 1);
	}
	
	// A utility function to swap two elements
	private void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
}
