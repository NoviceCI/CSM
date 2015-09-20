package xzf.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import xzf.domain.User;


public interface UserDao  {


	public User findByUserName(String userName);
	
}
