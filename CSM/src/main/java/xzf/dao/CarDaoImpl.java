package xzf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import xzf.domain.Car;
@Repository
public class CarDaoImpl implements CarDao {

	@PersistenceContext
	private EntityManager entityManager;


	@Override
	public Car getCarDetail(int id) {
		return (Car) entityManager
				.unwrap(Session.class)
				.createCriteria(Car.class)
				.add(Restrictions.eq("id",id))
				.setFetchMode("customer",FetchMode.JOIN)
				.setFetchMode("imageses",FetchMode.JOIN)
				.uniqueResult();
				
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Car> findByKeyword(String keyword, int offset, int limit) {
		return entityManager
				.unwrap(Session.class)
				.createCriteria(Car.class)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.addOrder(Order.desc("id"))
				.add(Restrictions.like("registerNumber", keyword,
						MatchMode.ANYWHERE)).list();
	}
	
	
	@Override
	public int countByKeyword(String keyword) {
		return ((Number) entityManager
				.unwrap(Session.class)
				.createCriteria(Car.class)
				.add(Restrictions.like("registerNumber", keyword,
						MatchMode.ANYWHERE))
				.setProjection(Projections.rowCount()).uniqueResult())
				.intValue();
	}

	@Override
	public Integer countAll() {
		return ((Number) entityManager.unwrap(Session.class)
				.createCriteria(Car.class)
				.setProjection(Projections.rowCount()).uniqueResult())
				.intValue();
	}

}
