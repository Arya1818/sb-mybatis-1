package com.bdi.sb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdi.sb.mapper.UserInfoMapper;
import com.bdi.sb.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	@GetMapping("/hellos")
	public List<String> hellos(){
		List<String> strList = new ArrayList<>();
		strList.add("주눅들게");
		strList.add("하지마세요");
		return strList;
	}	
}
