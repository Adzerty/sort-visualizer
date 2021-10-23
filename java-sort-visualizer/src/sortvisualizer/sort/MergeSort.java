package sortvisualizer.sort;

import sortvisualizer.SortVisualizer;
import sortvisualizer.gui.Fenetre;

public class MergeSort implements Sort {

	@Override
	public void sort() {
		Thread t = new Thread() {
		      public void run() {
		    	 System.out.println("TRI DE FUSION");
	    	  	SortVisualizer sV = SortVisualizer.getInstance(); 	//Récupération de la classe métier
	    	  	Fenetre f = Fenetre.getInstance();					//Récupération de la classe vue
	    	  	sV.settSort(this);									//On affecte le thread de sort pour pouvoir le stopper en cas de reset
	    	  	
				int[] array2Sort = sV.getArray();					//On récupère le tableau à trier
				
				long start = System.currentTimeMillis();			//On récupère le temps au début du tri
				
				//Algorithme de tri de fusion
				mergeSort(array2Sort, 0, array2Sort.length-1);
				
				
				long finish = System.currentTimeMillis();			//On récupère le temps à la fin du tri
				long timeElapsed = finish - start;					//On calcule le temps écoulé
				f.lblTpsEcoule.setText("  "+timeElapsed/1000f+"s écoulées  "); 
				
				sV.setArray(array2Sort);
		      }
		    };
		t.start();

	}
	
	private void mergeSort(int[] array2Sort, int l, int r)
	{
		SortVisualizer sV = SortVisualizer.getInstance(); 
	  	Fenetre f = Fenetre.getInstance();	
	  	
		if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            mergeSort(array2Sort, l, m);
            mergeSort(array2Sort, m + 1, r);
  
            // Merge the sorted halves
            mergeArrays(array2Sort, l, m, r);
            
        	try {
				Thread.sleep(sV.TIME);				
			} catch (InterruptedException e) {}
			f.paintCanva();
        }
	}

	private void mergeArrays(int[] array2Sort, int l, int m, int r) {
		// Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = array2Sort[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array2Sort[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
            	array2Sort[k] = L[i];
                i++;
            }
            else {
            	array2Sort[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
        	array2Sort[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
        	array2Sort[k] = R[j];
            j++;
            k++;
        }
		
	}


}
