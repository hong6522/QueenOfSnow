package qos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usr")
public class UsrController {

	@RequestMapping("/information")
	String main() {
		
		return "/usr/information";
	}
	
	
}
