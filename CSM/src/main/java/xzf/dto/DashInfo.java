package xzf.dto;

import java.util.List;

public class DashInfo {

	List<PieChart> pieCharts ;
	
	int totalCar ,totalCustomer ;

	public List<PieChart> getPieCharts() {
		return pieCharts;
	}

	public void setPieCharts(List<PieChart> pieCharts) {
		this.pieCharts = pieCharts;
	}

	public int getTotalCar() {
		return totalCar;
	}

	public void setTotalCar(int totalCar) {
		this.totalCar = totalCar;
	}

	public int getTotalCustomer() {
		return totalCustomer;
	}

	public void setTotalCustomer(int totalCustomer) {
		this.totalCustomer = totalCustomer;
	}
	
}
