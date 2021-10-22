package sortvisualizer.sort;

import sortvisualize.gui.Fenetre;
import sortvisualizer.SortVisualizer;

public class BubbleSort implements Sort {

	@Override
	public void sort() {
		Thread t = new Thread() {
		      public void run() {
		    	  SortVisualizer sV = SortVisualizer.getInstance();
		  		int[] array2Swap = sV.getArray();
		  		
		  		boolean sorted = false;
		  		
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
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		  				}
		  				
		  				Fenetre f = Fenetre.getInstance();
		  				f.paintCanva();
		  			}
		  		}
		  		
		  		sV.setArray(array2Swap);
		      }
		    };
		t.start();
		
	}

}
