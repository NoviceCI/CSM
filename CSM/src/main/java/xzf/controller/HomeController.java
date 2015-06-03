package xzf.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xzf.dao.UserDao;
import xzf.domain.User;

@Controller
public class HomeController {

	
	
	@Autowired
	UserDao userDao;
	
	
	@PostConstruct
	public void chechSession(){
		
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(User user) {
		return "login/login";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String auth(@Valid User user, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {

			return "login/login";

		}

		
		else {

			List<User> list = userDao.login(user.getUsername(),
					user.getPassword());
			System.out.print(list.size());

			if (list.size() < 1) {
				model.addAttribute("errorMessage",
						"Password Or UserName Invalid");
				return "login/login";

			} else {
				return "home";
			}

		}

	}

}
