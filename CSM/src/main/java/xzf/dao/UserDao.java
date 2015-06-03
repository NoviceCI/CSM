package xzf.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import xzf.domain.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long>{

	@Query("select u from User u where u.username = ?1 and u.password = ?2 ")
	List<User> login(String userName,String password);
	
}
