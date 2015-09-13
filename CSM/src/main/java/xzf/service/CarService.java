package xzf.service;

import java.util.List;

import xzf.domain.Car;
import xzf.dto.CarInfo;

public interface CarService {

	
	public CarInfo getCarDetail (int id);

	public Integer countAll();
	
	public int countByKeyword(String keyword);
	
	public List<Car> findByKeyword(String keyword,int offset,int limit);	
	
	
}
