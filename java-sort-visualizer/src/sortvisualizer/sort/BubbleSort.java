package sortvisualizer.sort;

import sortvisualizer.SortVisualizer;
import sortvisualizer.gui.Fenetre;

public class BubbleSort implements Sort {

	@Override
	public void sort() {
		Thread t = new Thread() {
		      public void run() {
	    	  	SortVisualizer sV = SortVisualizer.getInstance();
	    	  	Fenetre f = Fenetre.getInstance();
	    	  	sV.settSort(this);
	    	  	
				int[] array2Swap = sV.getArray();
				
				boolean sorted = false;
				
				long start = System.currentTimeMillis();
				while(!sorted) {
					sorted = true;
					
					for(int i = 0; i<array2Swap.length-1; i++) {
						int j = i+1;
						if(array2Swap[i] > array2Swap[j]) {
							sorted = false;
							int valTemp = array2Swap[i];
							array2Swap[i] = array2Swap[j];
							array2Swap[j] = valTemp;
							
							try {
								Thread.sleep(sV.TIME);
							} catch (InterruptedException e) {}
						}
						
						
						f.paintCanva();
					}
				}
				long finish = System.currentTimeMillis();
				long timeElapsed = finish - start;
				f.lblTpsEcoule.setText("  "+timeElapsed/1000f+"s écoulées  ");
				
				sV.setArray(array2Swap);
		      }
		    };
		t.start();
		
	}

}
