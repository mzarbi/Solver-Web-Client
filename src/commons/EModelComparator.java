package commons;

import java.util.Comparator;

public class EModelComparator implements Comparator<EModel> {
	
	    public int compare(EModel c1, EModel c2) {
	        return c1.getPrice() - c2.getPrice() ;
	    }
}
