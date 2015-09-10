package xzf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xzf.domain.Car;

@Repository
public class CarDaoImpl implements CarDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Car getCarDetail(int id) {
		// TODO Auto-generated method stub

		/*
		 * sessionFactory.getCurrentSession() .createCriteria(Car.class)
		 * .add(Restrictions.like("registerNumber",keyword,MatchMode.ANYWHERE))
		 * .list();
		 */
		return null;
	}

	@Transactional
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
