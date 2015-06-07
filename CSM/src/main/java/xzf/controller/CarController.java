package xzf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xzf.dao.CarDao;
import xzf.domain.Car;

@Controller
public class CarController {

	@Autowired
	CarDao carDao ;
	
	
	
	
	@RequestMapping(value="/getcars")
	public @ResponseBody List<Car> getCarsJson(){

		return carDao.getCars();
	}
	
	@RequestMapping(value="car")
	public String showCarPage(){
		
		return "car/index";
		
	}
	
	
	
}
