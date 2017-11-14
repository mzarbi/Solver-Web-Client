package commons;

public class Utils {
	
	public void printRegions(int idx,double[][] regions){
		
		 String [] labs = {
		 "Penetration",
		 "Population",
		 "GPON_PORTS",
		 "NearestRouter",
         "PC_Existing",
         "MeanHouseWidth",
         "MeanHouseLength",
         "Urbanization",
         "HousesInRow",
         "HousesInColumn",
         "VerticalHouses",
         "HorizentalHouses",
         "IncludeADSLRevenus",
         "SocialClass"} ;
      		 
		System.out.println("Displaying Region (" + String.valueOf(idx) + ") Info");
		for (int i = 0 ; i < 14 ; i++){
			
			System.out.println("\t" + labs[i] + " : " + String.valueOf(regions[idx][i]));
		}
	}
	
	public void printFin(int i, int j, int k, double[][][] costs,String caption){
		System.out.println();
		System.out.println("["+ caption + "] Region= " + String.valueOf(i) + 
						   " TimeStamp= " + String.valueOf(j) + 
						   " Technology= " + String.valueOf(k) + 
						   " Value= " + String.valueOf(costs[i][j][k]/100) + " kTND");
	}
	
	public void prints(int i,int k,double[][][] costs,double[][][] revenus, double[][][] roi) {
		
		System.out.println("Region " + i + " Technology " + k);
		final Object[][] table = new String[4][];
		table[0] = new String[] {"Attribute","Year 0", "Year 1", "Year 2"};
		table[1] = new String[] { "Costs", String.valueOf((int)(costs[i][0][k])/100) + " kTND", String.valueOf((int)(costs[i][1][k])/100) + " kTND", String.valueOf((int)(costs[i][2][k])/100) + " kTND" };
		table[2] = new String[] { "Revenus", String.valueOf((int)(revenus[i][0][k])/100) + " kTND", String.valueOf((int)(revenus[i][1][k])/100) + " kTND", String.valueOf((int)(revenus[i][2][k]/100)) + " kTND" };
		table[3] = new String[] { "ROI", String.valueOf((int)(roi[i][0][k])/100) + " kTND", String.valueOf((int)(roi[i][1][k])/100) + " kTND", String.valueOf((int)(roi[i][2][k])/100) + " kTND" };
		for (final Object[] row : table) {
		    System.out.format("%25s%25s%25s%25s\n", row);
		}
	}
	
	public void printFin(int i, int j, double[][][] costs,String caption){
		System.out.println();
		System.out.println("["+ caption + "] Region= " + String.valueOf(i) + 
						   " TimeStamp= " + String.valueOf(j) + 
						   " Value= " + String.valueOf(costs[i][j][0]) + ","
						   			  + String.valueOf(costs[i][j][1]) + ","
						   			  + String.valueOf(costs[i][j][2]));
	}

	public void prints(int i, int k, LPUtils lpu) {
		
		double[][][] costs = lpu.costs ; 
		double[][][] revenus = lpu.revenus ;
		double[][][] roi = lpu.ROI ;
		System.out.println("Region :" + i + " Technology :" + k + " Population :" + lpu.regions[i][1] + " Clients :" + (int)(lpu.regions[i][1]*lpu.regions[i][0])  );
		final Object[][] table = new String[4][];
		table[0] = new String[] {"Attribute","Year 0", "Year 1", "Year 2"};
		table[1] = new String[] { "Costs", String.valueOf((int)(costs[i][0][k])/100) + " kTND", String.valueOf((int)(costs[i][1][k])/100) + " kTND", String.valueOf((int)(costs[i][2][k])/100) + " kTND" };
		table[2] = new String[] { "Revenus", String.valueOf((int)(revenus[i][0][k])/100) + " kTND", String.valueOf((int)(revenus[i][1][k])/100) + " kTND", String.valueOf((int)(revenus[i][2][k]/100)) + " kTND" };
		table[3] = new String[] { "ROI", String.valueOf((int)(roi[i][0][k])/100) + " kTND", String.valueOf((int)(roi[i][1][k])/100) + " kTND", String.valueOf((int)(roi[i][2][k])/100) + " kTND" };
		for (final Object[] row : table) {
		    System.out.format("%25s%25s%25s%25s\n", row);
		}
		
	}

}
