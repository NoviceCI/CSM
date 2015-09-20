package xzf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
import xzf.dao.CarDao;
import xzf.domain.Car;
import xzf.domain.Customer;
import xzf.domain.Images;
import xzf.domain.JQueryDataTableParamModel;
import xzf.domain.jQueryDataTableResult;
import xzf.dto.CarInfo;
import xzf.service.CarService;

@Controller
public class CarController {

	@Autowired
	CarService carService;
	

	@RequestMapping(value = "/car_dt")
	public @ResponseBody jQueryDataTableResult<Car> ajax(JQueryDataTableParamModel params) {
		
		jQueryDataTableResult<Car> dataTableResult = new jQueryDataTableResult<Car>();
		
		List<Car>  cars = carService.findByKeyword(params.getsSearch(),
				params.getiDisplayStart(),params.getiDisplayLength());
		
		dataTableResult.setsEcho(params.getsEcho());
		dataTableResult.setiTotalRecords(carService.countAll());
		dataTableResult.setiTotalDisplayRecords(carService.countByKeyword(params.getsSearch()));
		dataTableResult.setAaData(cars);

 		return dataTableResult;
	}

	@RequestMapping(value = "/getCarInfo", method = RequestMethod.GET)
	public String showCarDetailPage(
			@RequestParam(value = "key", required = true) int id,Model model) {

		//CarInfo carInfo = 

		/*Images images = car.getImageses().get(0);

		String bytesSring = "data:image/png;base64,"
				+ Base64Coder.encodeLines(images.getData());
		*/
		
		model.addAttribute("carInfo",carService.getCarDetail(id));
		
		return "car/dialog";
	}

	@RequestMapping(value = "/car")
	public String showCarPage() {
		return "car/index";
	}

}
