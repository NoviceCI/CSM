package xzf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xzf.dto.DashInfo;
import xzf.service.DashService;


@Controller
public class DashController {
	
	@Autowired
	DashService dashService;

	@RequestMapping(value ="dash")
	public String showDashPage(){
		return "dash/index";
	}
	
	@RequestMapping(value ="getDashInfo")
	public @ResponseBody DashInfo getCarInfoJsonData(){
		return dashService.getDashInfo();
	}
	
	
}
