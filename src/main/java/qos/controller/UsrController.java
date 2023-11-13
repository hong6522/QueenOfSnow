package qos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import qos.db.MemberDTO;
import qos.db.MemberMapper;

@Controller
@RequestMapping("/usr")
public class UsrController {
	
	@Resource
	MemberMapper mp;

	@RequestMapping("/information")
	String information(HttpSession session) {
		
		System.out.println(session.getAttribute("id"));
		return "/usr/information";
	}
	
	
	@GetMapping("login")
	String login() {
		
		return "/usr/login";
	}
	
	@PostMapping("login")
	String loginCom(Model mm,MemberDTO dto ,HttpSession session) {
		
		MemberDTO mdto = mp.login(dto);
		
		if(mdto == null) {
			mm.addAttribute("msg" , "ID 혹은 PW 오류입니다.");
			mm.addAttribute("goUrl" , "/usr/login");
			return "alert";
		}
		
		session.setAttribute("id", mdto.getId());

		mm.addAttribute("msg" , mdto.getName()+" 님 환영합니다.");
		mm.addAttribute("goUrl" , "/usr/information");
		return "alert";
		
	}
	
	@RequestMapping("logout")
	String logout(Model mm , HttpSession session) {
		
		session.removeAttribute("id");
		session.invalidate();
		
		mm.addAttribute("msg" , "로그아웃 되었습니다.");
		mm.addAttribute("goUrl" , "/usr/login");
		return "alert";
	}
	
	
	@GetMapping("join")
	String join() {
		
		return "/usr/join";
	}
	
	
}
