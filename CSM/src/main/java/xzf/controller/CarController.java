package xzf.controller;

import java.awt.Image;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import xzf.dao.CarDao;
import xzf.domain.Car;
import xzf.domain.Images;

@Controller
public class CarController {

	@Autowired
	CarDao carDao;


	@RequestMapping(value = "/ajax")
	public @ResponseBody HashMap<String, List<Car>> ajax() {

		HashMap<String, List<Car>> map = new HashMap<String, List<Car>>();

		map.put("data", carDao.getCars());

		return map;
	}
	
	@RequestMapping(value="/car_detail",method = RequestMethod.GET)
	public String showCarDetailPage(@RequestParam(value="id",required=true) int id,Model model){
		
		Car car = carDao.getCarDetail(id).get(0);
		
		Images images = (Images) car.getImageses();
		
		//String base64ImageData = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(images.getData()).toString();
		
		
		model.addAttribute("car",car);
		//model.addAttribute("image",base64ImageData);
		
		return "car/detail";	
	}
	

	@RequestMapping(value = "car")
	public String showCarPage() {

		return "car/index";

	}

}
