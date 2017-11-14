package commons;

import java.util.ArrayList;

public class TArray extends ArrayList<DArray>{
	
	public int [] to1D(){
		int [] arr = new int [this.size()*this.get(0).size()] ;
		int c = 0 ;
		for (int i = 0 ; i < this.size();i++){
			for (int j= 0 ; j < this.get(0).size();j++){
				arr[c] = this.get(i).get(j) ;
				c++;
			}
		}
		return arr;
		
	}

}
