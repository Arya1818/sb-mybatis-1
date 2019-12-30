package com.bdi.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bdi.sb.service.TestInfoService;
import com.bdi.sb.vo.TestInfoVO;


@Controller
@RequestMapping("/testv")	//http메서드 다 가능! 지정하고싶다면 value="/testv", method=RequestMethod.GET 이렇게
public class TestInfoViewController {

	@Autowired
	private TestInfoService tiService;
	
	@GetMapping("tests")
	public String getTestInfoList(@ModelAttribute TestInfoVO test, Model m) {
		m.addAttribute("rMap",tiService.selectTestInfoList(test));
		return "/views/test/list";
	}
	
}
