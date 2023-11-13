package qos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;
import qos.db.MemberDTO;
import qos.db.MemberMapper;

@Controller
public class AjaxController {

	@Resource
	MemberMapper mp;
	
	@RequestMapping("/ajax/idChk")
	@ResponseBody
	String idChk(MemberDTO dto) {
		
		System.out.println(mp.idChk(dto));
		
		return "";
	}
	
}
