package springSearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homeController {

	
	@RequestMapping("/welcome")
	public String useInterceptor(@RequestParam ("userName") String name ,Model model) {
		
		System.out.println(name);
		model.addAttribute("message","Invlaid name");
		
		
		return "welcome";
		
	}
	
}
