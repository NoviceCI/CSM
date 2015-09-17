package xzf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xzf.domain.Customer;
import xzf.domain.JQueryDataTableParamModel;
import xzf.domain.jQueryDataTableResult;
import xzf.service.CarService;
import xzf.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value= "customer")
	public String showCustomerPage(){
		return "customer/index";
	}
	
	@RequestMapping(value= "customer_dt")
	public @ResponseBody jQueryDataTableResult<Customer> ajax (JQueryDataTableParamModel params){
		
		jQueryDataTableResult<Customer> dataTableResult = new jQueryDataTableResult<Customer>();
		
		List<Customer> customers = customerService.findByKeyword(params.getsSearch(),
				params.getiDisplayStart(),params.getiDisplayLength());
		
		dataTableResult.setsEcho(params.getsEcho());
		dataTableResult.setiTotalRecords(customerService.countAll());
		dataTableResult.setiTotalDisplayRecords(customerService.countByKeyword(params.getsSearch()));
		dataTableResult.setAaData(customers);
		return dataTableResult;
	}
	
	
	
	
}
