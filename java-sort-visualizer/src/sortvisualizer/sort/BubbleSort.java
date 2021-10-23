package sortvisualizer.sort;

import sortvisualizer.SortVisualizer;
import sortvisualizer.gui.Fenetre;

public class BubbleSort implements Sort {

	@Override
	public void sort() {
		Thread t = new Thread() {
		      public void run() {
	    	  	SortVisualizer sV = SortVisualizer.getInstance();		//R�cup�ration de la classe m�tier
	    	  	Fenetre f = Fenetre.getInstance();						//R�cup�ration de la classe vue
	    	  	sV.settSort(this);										//On affecte le thread de sort pour pouvoir le stopper en cas de reset
	    	  
	    	  	
				int[] array2Sort = sV.getArray();						//On r�cup�re le tableau � trier
				
				boolean sorted = false;
				
				long start = System.currentTimeMillis();				//On r�cup�re le temps au d�but du tri
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
				long finish = System.currentTimeMillis();				//On r�cup�re le temps � la fin du tri
				long timeElapsed = finish - start;						//On calcule le temps �coul�
				f.lblTpsEcoule.setText("  "+timeElapsed/1000f+"s �coul�es  ");
				
				sV.setArray(array2Sort);
		      }
		    };
		t.start();
		
	}

}
