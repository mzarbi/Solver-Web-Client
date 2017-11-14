import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.sun.org.apache.xml.internal.security.Init;

import SPwebClients.FullHttpResponse;
import SPwebClients.HttpRequester;
import commons.Connector;
import commons.LPUtils;
import commons.ResultBean;
import commons.ResultBeanList;
import commons.Utils;

public class main {

	public static void main(String[] args) {
		
		// Create Solver Instance
		LPUtils lpu = new LPUtils() ;
		init(lpu) ;
		double[][][][] tab = lpu.Conv(lpu.ROI , lpu.costs) ;
		
		HttpRequester httpRequester = new HttpRequester();
		String url = "http://localhost:5000/Simulation" ;
        Map<String, String> params = new LinkedHashMap<String, String>();
		
        String uuid = UUID.randomUUID().toString();
        params.put("session",uuid) ;
       
       
        String data = "" ;
        System.out.println(Arrays.deepToString(tab));
        data += Arrays.deepToString(tab) + "&" ;
        data += String.valueOf(lpu.annualBudget) + "&" ;
        data += String.valueOf(lpu.ppy)  ;
        params.put("data", data) ;
		FullHttpResponse response = httpRequester.call(url, "POST", params);
		
		
		String resp = response.getResponse() ;
		
		System.out.println(resp);
		
		/*
		ResultBeanList list = parse(resp, lpu) ;
		
		list.getChecked().prints();
		System.out.println("#########");
		list.getUnChecked().prints();*/
		//list.getUnChecked().prints();

	}
	
	public static void init (LPUtils lpu) {
		// Configurations
		lpu.RegionCount = 2 ;
		lpu.TemporalHorizon = 3 ;
		lpu.TechCount = 3 ;
		lpu.annualBudget = 100000 ;
		lpu.ppy = 7 ;

		// Add Regions
		//lpu.regions = Connector.loadDataSet("data1");
		
		// Add Costs
		lpu.C_ONT_Unitary = 200 ;
		lpu.FiberCost = 7000 ;
		lpu.TrenchCost = 1000 ;
		lpu.miniMSANCost = 1500 ;
		lpu.CivilEngineering = 1 ;
		
		lpu.init();
	}
	public static boolean idxFound(int i, int j, int k, int [][] arr){
			
			boolean res = false ;
			for (int i1 = 0 ; i1 < arr.length; i1++){
				if (arr[i1][0] == i && arr[i1][1] == j && arr[i1][2] == k){
					res = true ;
					break;
				}
			}
			return res ;
		}
	/*
	public static void fromFile(double [][] regions){
		FileReader fileR = null;
		try {
			fileR = new FileReader("data.txt");
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
	}*/
	public static ResultBeanList parse(String resp,LPUtils u){
		String[] s = resp.split("&")[1].split(",") ;
		int [][] idxs = new int[s.length][3] ; 
		
		int i1 = 0 ;
		
		for (String ss : s){
			
			String s_ = ss.substring(1) ;
			String[] s__ = s_.split("_") ;
			int j1 = 0 ;
			for (String d : s__){
				
				idxs[i1][j1] = Integer.parseInt(d);
				j1++;
			}
			i1++ ;
		}
		
		ResultBeanList list = new ResultBeanList() ;
		
		ResultBean tmp = null ;
		for (int i = 0 ; i < u.RegionCount;i++){
			for (int j = 0 ; j < u.TemporalHorizon;j++){
				for (int k = 0 ; k < u.TechCount;k++){
					if(idxFound(i,j,k, idxs)){
						tmp = new ResultBean(i, j, k, u.costs[i][j][k] ,
																 u.revenus[i][j][k],
																 u.revenus[i][j][k] - u.costs[i][j][k],
																 true) ;
					}else{
						tmp = new ResultBean(i, j, k, u.costs[i][j][k] ,
																 u.revenus[i][j][k], 
																 u.revenus[i][j][k] - u.costs[i][j][k],
																 false) ;
					}
					
					list.add(tmp) ;
					
				}
			}
		}
		return list ;
	}
	
	public static double[][][] generate(LPUtils u){
		
		double[][][] s = new double[u.RegionCount][u.TemporalHorizon][u.TechCount] ;
		for( int i = 0 ; i < u.RegionCount;i++) {
			for (int j = 0 ; j < u.TemporalHorizon ; j++) {
				for (int k = 0 ; k < u.TechCount; k++) {
					double random = new Random().nextDouble();
					double start = 7999 + 9000/(j + 1) ;
					double end  =  7999 ;
					double val = start + (random * (end - start));
					
					s[i][j][k] = Math.ceil(val) ;
				}
			}
		}
		return s ;
	}

}
