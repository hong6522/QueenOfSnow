package qos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;
import qos.db.MemberDTO;
import qos.db.MemberMapper;
import qos.db.ReservationDTO;
import qos.db.ReservationMapper;
import qos.instance.ReserCalendar;

@Controller
public class AjaxController {

	@Resource
	MemberMapper mp;
	
	@Resource
	ReservationMapper rp;
	
	@RequestMapping("/ajax/idChk")
	@ResponseBody
	String idChk(MemberDTO dto) {
		
		System.out.println(mp.idChk(dto));
		
		return "";
	}
	
	@RequestMapping("/ajax/reserChk")
	@ResponseBody
	List<ReservationDTO> reserChk(ReservationDTO dto) {
		
		List<ReservationDTO> Rlist = rp.reserChk(dto);
		
		return Rlist;
	}
	
	@RequestMapping("/ajax/openCalendar/{Rmonth}")
	@ResponseBody
	ReserCalendar openCalendar(@PathVariable int Rmonth) {
		
		ReserCalendar calendar = new ReserCalendar(Rmonth);
		
		return calendar;
	}
	
	
	
}
