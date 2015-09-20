package xzf.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import xzf.domain.User;

@Controller
public class LoginController {

	@RequestMapping(value ="/auth")
	public String loginPage(User user,BindingResult bindingResult,Model model,Principal principal){
		if(principal!=null){
			return "redirect:dash";
		}
		return "login/login";
	}
	
	@RequestMapping(value= "/")
	public String redirectToDash(){
		return "redirect:dash";
	}
	
	@RequestMapping(value="/authfail")
	public String loginPageFail(User user,BindingResult bindingResult,Model model,Principal principal){
		if(principal!=null){
			return "redirect:dash";
		}
		model.addAttribute("errorMessage","USERNAME หรือ PASSWORD ไม่ถูกต้อง");
		return "login/login";
	}
}
