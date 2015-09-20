package xzf.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.xalan.xsltc.compiler.sym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xzf.dao.UserDao;
import xzf.domain.User;


@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		
		User user = userDao.findByUserName(arg0);
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new UserGrantedAuthority());
		
		if(user==null){
			System.out.print("UsernameNotFound !!");
			throw new UsernameNotFoundException("UserName Not Found");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), true, true, true, true,
				grantedAuthorities
				);
	}
	
	private class UserGrantedAuthority implements GrantedAuthority{

		/**
		 * 
		 */
		private static final long serialVersionUID = 2494359383575248383L;

		@Override
		public String getAuthority() {
			// TODO Auto-generated method stub
			return "ROLE_USER";
		}
		
	}
	
	

	

}
