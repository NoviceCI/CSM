package xzf.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import xzf.domain.Car;


@Transactional
public interface CarDao extends CrudRepository<Car, Long>{

	@Query("select c from Car c")
	List<Car> getCars();
	
	@Query("select c from Car c ")
	List<Car> getCarsDataTable();
	
	@Query("select c from Car c inner join c.imageses inner join c.customer where c.id=?1")
	List<Car> getCarDetail(int id);
}
