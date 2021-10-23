package sortvisualizer.sort;

import sortvisualizer.SortVisualizer;
import sortvisualizer.gui.Fenetre;

public class InsertionSort implements Sort {

	@Override
	public void sort() {
		System.out.println("INSERTION");
		Thread t = new Thread() {
		      public void run() {
	    	  	SortVisualizer sV = SortVisualizer.getInstance(); 	//Récupération de la classe métier
	    	  	Fenetre f = Fenetre.getInstance();					//Récupération de la classe vue
	    	  	sV.settSort(this);									//On affecte le thread de sort pour pouvoir le stopper en cas de reset
	    	  	
				int[] array2Sort = sV.getArray();					//On récupère le tableau à trier
				
				long start = System.currentTimeMillis();			//On récupère le temps au début du tri
				
				int n = array2Sort.length;
		        for (int i = 1; i < n; ++i) {
		            int key = array2Sort[i];
		            int j = i - 1;
		 
		            /* Move elements of arr[0..i-1], that are
		               greater than key, to one position ahead
		               of their current position */
		            while (j >= 0 && array2Sort[j] > key) {
		            	array2Sort[j + 1] = array2Sort[j];
		                j = j - 1;
		                try {
							Thread.sleep(sV.TIME);				
						} catch (InterruptedException e) {}
						f.paintCanva();
		            }
		            array2Sort[j + 1] = key;
		            
		            
		        }
				
				
				long finish = System.currentTimeMillis();			//On récupère le temps à la fin du tri
				long timeElapsed = finish - start;					//On calcule le temps écoulé
				f.lblTpsEcoule.setText("  "+timeElapsed/1000f+"s écoulées  "); 
				
				sV.setArray(array2Sort);
		      }
		    };
		t.start();

	}

}
