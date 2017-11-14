package commons;



import java.util.ArrayList;
import java.util.Random;

public class ResultBeanList extends ArrayList<ResultBean>{
	
	/**
	 * @author medzied
	 */
	private static final long serialVersionUID = 1L;

	public ResultBeanList(){
		
	}
	
	public ResultBean getBean(int i, int j, int k){
		
		
		for (ResultBean bn : this){
			
			if (bn.region_id == i && 
				bn.time_id == j &&
				bn.tech_id == k){
				
				return bn ;
			}
		}
		
		return null;
		
	}
	
	public double getAllCosts() {
		double x = 0 ;
		for (ResultBean b : this) {
			x += b.getCost() ;
		}
		return x ;
	}
	
	public double getAllRevenus() {
		double x = 0 ;
		for (ResultBean b : this) {
			x += b.getRevenu() ;
		}
		return x ;
	}
	public ResultBeanList getByYear(int i){
		
		ResultBeanList tmp = new ResultBeanList() ;
		
		for (ResultBean bn : this){
			
			if (bn.time_id == i){
				tmp.add(bn) ;
			}
		}
		
		return tmp;
		
	}
	
	
	public ResultBeanList getByRegion(int i){
		
		ResultBeanList tmp = new ResultBeanList() ;
		
		for (ResultBean bn : this){
			
			if (bn.region_id == i){
				tmp.add(bn) ;
			}
		}
		
		return tmp;
		
	}
	
	public ResultBeanList getByTech(int i){
		
		ResultBeanList tmp = new ResultBeanList() ;
		
		for (ResultBean bn : this){
			
			if (bn.tech_id == i){
				tmp.add(bn) ;
			}
		}
		
		return tmp;
		
	}
	
	public ResultBeanList getChecked(){
		
		ResultBeanList tmp = new ResultBeanList() ;
		
		for (ResultBean bn : this){
			
			if (bn.checked == true){
				tmp.add(bn) ;
			}
		}
		
		return tmp;
		
	}
	
	public ResultBeanList getUnChecked(){
		
		ResultBeanList tmp = new ResultBeanList() ;
		
		for (ResultBean bn : this){
			
			if (bn.checked == false){
				tmp.add(bn) ;
			}
		}
		
		return tmp;
		
	}
	
	public ResultBeanList getByCloseCost(ResultBean B,double percentage){
		
		ResultBeanList voisinage = new ResultBeanList() ;
		
		for (ResultBean bn : this){
			
			if (bn.cost < B.cost*(1 + percentage) &&
				bn.cost > B.cost*(1 - percentage) &&
				bn.equals(B) == false){
				voisinage.add(bn) ;
			}
		}
		return voisinage ;
	}
	
	public ResultBeanList getByCloseRevenu(ResultBean B,double percentage){
		
		ResultBeanList voisinage = new ResultBeanList() ;
		
		for (ResultBean bn : this){
			
			if (bn.revenu < B.revenu*(1 + percentage) &&
				bn.revenu > B.revenu*(1 - percentage) &&
				bn.equals(B) == false){
				voisinage.add(bn) ;
			}
		}
		return voisinage ;
	}
	
	public ResultBeanList getByCloseROI(ResultBean B,double percentage){
		
		ResultBeanList voisinage = new ResultBeanList() ;
		
		for (ResultBean bn : this){
			
			if (bn.ROI < B.ROI*(1 + percentage) &&
				bn.ROI > B.ROI*(1 - percentage) &&
				bn.equals(B) == false){
				voisinage.add(bn) ;
			}
		}
		return voisinage ;
	}
	public ResultBean getMaxCost(){
		
		double max = -10000000000000.0 ;
		ResultBean maxB = null ;
		
		for (ResultBean bn : this){
			
			if (bn.cost > max){
				maxB = bn ;
				max = bn.cost ;
			}
		}
		return maxB ;
	}
	
	public ResultBean getMinCost(){
		
		double min = 10000000000000.0 ;
		ResultBean minB = null ;
		
		for (ResultBean bn : this){
			
			if (bn.cost < min){
				minB = bn ;
				min = bn.cost ;
			}
		}
		return minB ;
	}
	
	public ResultBean getMaxRevenu(){
		
		double max = -10000000000000.0 ;
		ResultBean maxB = null ;
		
		for (ResultBean bn : this){
			
			if (bn.revenu > max){
				maxB = bn ;
				max = bn.cost ;
			}
		}
		return maxB ;
	}
	
	public ResultBean getMinRevenu(){
		
		double min = 10000000000000.0 ;
		ResultBean minB = null ;
		
		for (ResultBean bn : this){
			
			if (bn.revenu < min){
				minB = bn ;
				min = bn.cost ;
			}
		}
		return minB ;
	}
	
	public ResultBean getMaxROI(){
		
		double max = -10000000000000.0 ;
		ResultBean maxB = null ;
		
		for (ResultBean bn : this){
			
			if (bn.ROI > max){
				maxB = bn ;
				max = bn.cost ;
			}
		}
		return maxB ;
	}
	
	public ResultBean getMinROI(){
		
		double min = 10000000000000.0 ;
		ResultBean minB = null ;
		
		for (ResultBean bn : this){
			
			if (bn.ROI < min){
				minB = bn ;
				min = bn.cost ;
			}
		}
		return minB ;
	}
	
	
	
	
	
	public int getRegionCount(){
		return this.getByYear(0).getByTech(0).size() ;
	}
	
	public int getTechCount(){
		return this.getByYear(0).getByRegion(0).size() ;
	}
	
	public int getTemporalHorizon(){
		return this.getByTech(0).getByRegion(0).size() ;
	}
	
	public void prints(){
		for (ResultBean bn : this){
			
			bn.prints() ;
		}
	}
	
	public ResultBeanList generate(){
		
		ResultBeanList ls = new ResultBeanList() ;
		ResultBean tmp = null ;
		for (int i = 0 ; i < 10;i++){
			for (int j = 0 ; j < 5;j++){
				for (int k = 0 ; k < 3;k++){
					
					Random rand = new Random();
					double cost = 1000 + rand.nextInt((10000 - 1000) + 1);
					
					rand = new Random();
					double revenu = 1000 + rand.nextInt((10000 - 1000) + 1);
					
					 rand = new Random();
					 boolean checked = rand.nextBoolean();
					
					tmp = new ResultBean(i, j, k, cost, revenu, revenu - cost, checked) ;
					tmp.name = "name" ;
					ls.add(tmp) ;
				}
			}
		}
		
		
		return ls;
		
	}
	

}
