package qos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usr")
public class UsrController {

	@RequestMapping("/main")
	String main() {
		
		return "/usr/mainPage";
	}
	
	
}
