package com.bdi.sb.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bdi.sb.service.TestInfoService;
import com.bdi.sb.vo.TestInfoVO;

@RestController
public class TestController {

	@Resource
	private TestInfoService tiService;
	
	@GetMapping("/tests")
	public Map<String,Object> getTests(@ModelAttribute TestInfoVO test){
		return tiService.selectTestInfoList(test);
		 
	}	
	@GetMapping("/tests/view")
	public TestInfoVO getOneTest(@ModelAttribute TestInfoVO test){
		return tiService.selectOneTest(test);
		 
	}	
	@PostMapping("/tests")
	public int insertTest(@RequestBody TestInfoVO test){
		return tiService.insertTest(test);
	}
	
	@PutMapping("/tests")
	public Map<String,Object> updateTest(@RequestBody TestInfoVO test){
		return tiService.updateTest(test);
	}
	@DeleteMapping("/tests")
	public Map<String,Object> deleteTest(@RequestBody List<String> tiNums){
		return tiService.deleteTest(tiNums);
	}
}
