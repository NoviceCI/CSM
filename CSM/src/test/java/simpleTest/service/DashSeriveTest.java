package simpleTest.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import simpleTest.AbstractTest;
import xzf.dao.CarDao;
import xzf.domain.Car;
import xzf.service.DashService;

@Transactional
public class DashSeriveTest extends AbstractTest {

	@Autowired
	DashService dashService ;
	
	@Autowired
	CarDao carDao ;
	
	@Test
	public void testDashInfo(){
		
		
		
		System.out.print("x");
		
	}
	
	
}
