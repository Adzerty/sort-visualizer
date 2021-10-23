package sortvisualizer.sort;

import sortvisualizer.SortVisualizer;
import sortvisualizer.gui.Fenetre;

public class BubbleSort implements Sort {

	@Override
	public void sort() {
		Thread t = new Thread() {
		      public void run() {
	    	  	SortVisualizer sV = SortVisualizer.getInstance();		//Récupération de la classe métier
	    	  	Fenetre f = Fenetre.getInstance();						//Récupération de la classe vue
	    	  	sV.settSort(this);										//On affecte le thread de sort pour pouvoir le stopper en cas de reset
	    	  
	    	  	
				int[] array2Sort = sV.getArray();						//On récupère le tableau à trier
				
				boolean sorted = false;
				
				long start = System.currentTimeMillis();				//On récupère le temps au début du tri
				while(!sorted) {
					sorted = true;
					
					for(int i = 0; i<array2Sort.length-1; i++) {
						int j = i+1;
						if(array2Sort[i] > array2Sort[j]) {
							sorted = false;
							int valTemp = array2Sort[i];
							array2Sort[i] = array2Sort[j];
							array2Sort[j] = valTemp;
							
							try {
								Thread.sleep(sV.TIME);				
							} catch (InterruptedException e) {}
						}
						
						
						f.paintCanva();
					}
				}
				long finish = System.currentTimeMillis();				//On récupère le temps à la fin du tri
				long timeElapsed = finish - start;						//On calcule le temps écoulé
				f.lblTpsEcoule.setText("  "+timeElapsed/1000f+"s écoulées  ");
				
				sV.setArray(array2Sort);
		      }
		    };
		t.start();
		
	}

}
