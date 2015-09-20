package xzf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import scala.util.parsing.json.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;

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
	
	@RequestMapping(value ="getSeverInfo")
	public @ResponseBody String getServerInfo(HttpServletRequest HttpServletRequest){
		
		String serverName = HttpServletRequest.getServerName();
		String portNumber = String.valueOf(HttpServletRequest.getServerPort());
		String serverInfo = HttpServletRequest.getServletContext().getServerInfo();
		String serverAttr = (String) HttpServletRequest.getServletContext().getAttribute("attribute");
		
		JsonObject object = new JsonObject();
		
		object.addProperty("serveName",serverName);
		object.addProperty("portNumber",portNumber);
		object.addProperty("serverInfo",serverInfo);
		object.addProperty("serverAttr",serverAttr);
		
		return  object.toString();
						
						
		
		
	}
	
}
