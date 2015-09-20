package xzf.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import xzf.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public User findByUserName(String userName) {
		return (User) entityManager.unwrap(Session.class)
				.createCriteria(User.class)
				.add(Restrictions.eq("username",userName))
				.uniqueResult();
	}

}
