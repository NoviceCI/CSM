package xzf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import xzf.dao.CarDao;
import xzf.domain.Car;
import xzf.domain.Images;
import xzf.domain.JQueryDataTableParamModel;
import xzf.domain.jQueryDataTableResult;

@Controller
public class CarController {

	@Autowired
	CarDao carDao;
	
	

	@RequestMapping(value = "/car_dt")
	public @ResponseBody jQueryDataTableResult<Car> ajax(JQueryDataTableParamModel params) {
		
		jQueryDataTableResult<Car> dataTableResult = new jQueryDataTableResult<Car>();
		
		List<Car>  cars = carDao.findByKeyword(params.getsSearch(),
				params.getiDisplayStart(),params.getiDisplayLength());
		
		dataTableResult.setsEcho(params.getsEcho());
		dataTableResult.setiTotalRecords(carDao.countAll());
		dataTableResult.setiTotalDisplayRecords(carDao.countByKeyword(params.getsSearch()));
		dataTableResult.setAaData(cars);

 		return dataTableResult;
	}

	@RequestMapping(value = "/car_detail", method = RequestMethod.GET)
	public String showCarDetailPage(
			@RequestParam(value = "id", required = true) int id, Model model) {

		Car car = carDao.getCarDetail(id);

		Images images = car.getImageses().get(0);

		String bytesSring = "data:image/png;base64,"
				+ Base64Coder.encodeLines(images.getData());

		model.addAttribute("car", car);
		model.addAttribute("image", bytesSring);

		return "car/detail";
	}

	@RequestMapping(value = "car")
	public String showCarPage() {

		return "car/index";

	}

}
