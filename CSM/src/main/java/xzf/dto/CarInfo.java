package xzf.dto;

import java.util.List;

import xzf.domain.Car;
import xzf.domain.Customer;

public class CarInfo {

	Car car ;
	Customer customer ;
	List<String> images ;
	
	
	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public CarInfo(Car car, Customer customer) {
		this.car = car;
		this.customer = customer;
	}
	
	public CarInfo() {

	}
	
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
