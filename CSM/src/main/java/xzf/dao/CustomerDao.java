package xzf.dao;

import java.util.List;

import xzf.domain.Customer;

public interface CustomerDao {

	public void addCustomer(Customer customer) ;
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
	
	public int countAll();
	
	public int countByKeyword(String keyword);
	
	public Customer getCustomerDetail(int id);
	
	public List<Customer> findByKeyword(String keyword,int offset,int limit);
}
