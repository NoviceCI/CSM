package xzf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xzf.dao.CustomerDao;
import xzf.domain.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired 
	CustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}

	@Override
	public int countAll() {
		return customerDao.countAll();
	}

	@Override
	public int countByKeyword(String keyword) {
		return customerDao.countByKeyword(keyword);
	}

	@Override
	public Customer getCustomerDetail(int id) {
		return customerDao.getCustomerDetail(id);
	}

	@Override
	public List<Customer> findByKeyword(String keyword, int offset, int limit) {
		return customerDao.findByKeyword(keyword, offset, limit);
	}

}
