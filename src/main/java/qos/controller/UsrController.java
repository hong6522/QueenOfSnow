package qos.controller;

import java.time.Year;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import qos.db.MemberDTO;
import qos.db.MemberMapper;
import qos.db.ReservationDTO;

@Controller
@RequestMapping("/usr")
public class UsrController {
	
	@Resource
	MemberMapper mp;
	
	@RequestMapping("main")
	String main() {
		
		return "/usr/main";
	}
	
	
	@RequestMapping("/information")
	String information(HttpSession session) {
		
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
	@PostMapping("join")
	String join_com(Model mm , MemberDTO dto) {
		
		System.out.println(dto);
		
		System.out.println(mp.join(dto));
		
		mm.addAttribute("msg" ,"회원가입이 완료되었습니다.");
		mm.addAttribute("goUrl" , "/usr/login");
		
		return "alert";
	}
	
	
	@RequestMapping("wayCome")
	String wayCome() {
		
		return "/usr/wayCome";
	}
	
	@GetMapping("reservation/{Rmonth}")
	String reservation(Model mm , @PathVariable("Rmonth")int Rmonth) {
		int month;
		
		Calendar today = Calendar.getInstance();
		
		String title;
		
		String [] week = {"일","월","화","수","목","금","토"};
		
		month = today.get(Calendar.MONTH)+1;
		
		today.set(Calendar.MONTH,(month+Rmonth)-1);
		
		//today.set(today.get(Calendar.YEAR),Rmonth-1,today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.YEAR));
		
		Calendar startDay = (Calendar) today.clone();
		startDay.set(Calendar.DAY_OF_MONTH, 1);
		
		
        int start = startDay.get(Calendar.DAY_OF_WEEK);
        
        while (startDay.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
			startDay.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        int firstSun = startDay.get(Calendar.DAY_OF_MONTH);

		
		int last = today.getActualMaximum(Calendar.DATE);
		
		int now = today.get(Calendar.DATE);
		
		if((today.get(Calendar.MONTH)+1)%12==0) {
			title = today.get(Calendar.YEAR)+"년 "+12+"월";
		}
		else {
			title = today.get(Calendar.YEAR)+"년 "+(today.get(Calendar.MONTH)+1)%12+"월";
		}
		
		mm.addAttribute("month", month);
		mm.addAttribute("Rmonth", Rmonth);
		mm.addAttribute("start" , start);
		mm.addAttribute("last" , last);
		mm.addAttribute("now" , now);
		mm.addAttribute("week" , week);
		mm.addAttribute("title" , title);
		mm.addAttribute("firstSun" ,firstSun);
		System.out.println("첫번째 일요일"+firstSun);
		System.out.println("시작 요일"+start);
		
		System.out.println(7%7);
		return "/usr/reservation";
	}
}
