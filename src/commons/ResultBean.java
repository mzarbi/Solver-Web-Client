package commons;




public class ResultBean {
	
	
	public int region_id ;
	public int time_id ;
	public int tech_id ;
	public double cost ;
	public double revenu ;
	public double ROI ;
	public boolean checked ;
	
	public String name ;
	public String region ;
	
	public ResultBean()
	{
		
	}
	public ResultBean(int region_id, int time_id, int tech_id, double cost,
			double revenu, double rOI, boolean checked) {
		super();
		this.region_id = region_id;
		this.time_id = time_id;
		this.tech_id = tech_id;
		this.cost = cost;
		this.revenu = revenu;
		this.ROI = rOI;
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "ResultBean [region_id=" + region_id + ", time_id=" + time_id
				+ ", tech_id=" + tech_id + ", cost=" + cost + ", revenu="
				+ revenu + ", ROI=" + ROI + ", checked=" + checked + "]";
	}

	public void prints() {
		System.out.println(this.toString() + "\n");
	}
	
	public boolean equals(ResultBean bn){
		
		if (bn.region_id == this.region_id &&
			bn.time_id == this.time_id &&
			bn.tech_id == this.tech_id &&
			bn.cost == this.cost &&
			bn.revenu == this.revenu &&
			bn.checked == this.checked){
			return true ;
		}
		
		return false ;
	}
	
	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}

	public int getTime_id() {
		return time_id;
	}

	public void setTime_id(int time_id) {
		this.time_id = time_id;
	}

	public int getTech_id() {
		return tech_id;
	}

	public void setTech_id(int tech_id) {
		this.tech_id = tech_id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getRevenu() {
		return revenu;
	}

	public void setRevenu(double revenu) {
		this.revenu = revenu;
	}

	public double getROI() {
		return ROI;
	}

	public void setROI(double rOI) {
		ROI = rOI;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	
	
	
}
