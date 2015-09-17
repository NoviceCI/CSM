package xzf.dao;

import java.util.List;

import xzf.domain.Car;

public interface CarDao {

	
	public Car getCarDetail (int id);
	
	public int countAll();
	
	public int countByKeyword(String keyword);
	
	public List<Car> findByKeyword(String keyword,int offset,int limit);
	
	public int countBytype(String typeCode);
	
	public List<String> getCarTypeCode();
	
	
}
