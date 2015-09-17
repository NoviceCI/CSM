package xzf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import xzf.domain.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addCustomer(Customer customer) {
		entityManager.unwrap(Session.class).save(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		entityManager.unwrap(Session.class).update(customer);

	}

	@Override
	public void deleteCustomer(Customer customer) {
		entityManager.unwrap(Session.class).delete(customer);
	}

	@Override
	public int countAll() {
		return ((Number) entityManager.unwrap(Session.class)
				.createCriteria(Customer.class)
				.setProjection(Projections.rowCount()).uniqueResult())
				.intValue();
	}

	@Override
	public int countByKeyword(String keyword) {
		return ((Number) entityManager
				.unwrap(Session.class)
				.createCriteria(Customer.class)
				.add(Restrictions.or(
						Restrictions.like("name", keyword, MatchMode.ANYWHERE),
						Restrictions.like("tel1", keyword, MatchMode.ANYWHERE),
						Restrictions.like("tel2", keyword, MatchMode.ANYWHERE)))
				.setProjection(Projections.rowCount()).uniqueResult())
				.intValue();
	}

	@Override
	public Customer getCustomerDetail(int id) {
		return (Customer) entityManager.unwrap(Session.class)
				.createCriteria(Customer.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findByKeyword(String keyword, int offset, int limit) {
		return entityManager.unwrap(Session.class)
				.createCriteria(Customer.class).setFirstResult(offset)
				.setMaxResults(limit).addOrder(Order.desc("id"))
				.add(Restrictions.or(
						Restrictions.like("name", keyword, MatchMode.ANYWHERE),
						Restrictions.like("tel1", keyword, MatchMode.ANYWHERE),
						Restrictions.like("tel2", keyword, MatchMode.ANYWHERE)))
				.list();
	}

}
