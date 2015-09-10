package xzf.dao;

import java.util.List;

import xzf.domain.Car;

public interface CarDao {

	
	public Car getCarDetail (int id);
	
	public Integer countAll();
	
	public int countByKeyword(String keyword);
	
	public List<Car> findByKeyword(String keyword,int offset,int limit);
	
	
}
