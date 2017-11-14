package commons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Connector {
	
	public static String path = "src/dataSets/" ;
	
	public static double[][] loadDataSet(String filename) {
		
		
		System.out.println(path + filename);
		
		double [][] regions = null ;
		
		FileReader fileR = null;
		try {
			fileR = new FileReader(path + filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader r = new BufferedReader(fileR) ;
		
		String st = null;
		try {
			st = r.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st = st.replace("{", "");
		String[] s0 = st.split("},\\s");
		int length = s0.length;
		String[][] a = new String[length][];
		for (int i = 0; i < length; i++) {
		    a[i] = s0[i].replace("}", "").split(",\\s");
		}
		regions = new double[a.length][a[0].length] ;
		for (int i = 0 ; i < a.length ; i++) {
			for (int j = 0 ; j < a[0].length ; j++) {
				regions[i][j] = Double.parseDouble(a[i][j]) ;
			}
		}
		
		return regions ;
	}

}
