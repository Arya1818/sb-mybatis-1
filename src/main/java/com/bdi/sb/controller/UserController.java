package com.bdi.sb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bdi.sb.service.UserInfoService;
import com.bdi.sb.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
//	@Resource
//	private UserInfoMapper uiMapper;
//	
//	@GetMapping("/list")
//	public List<UserInfoVO> selectUserInfoList(){
//		return uiMapper.selectUserInfoList(null);
//	}
//	@GetMapping("/login")
//	public UserInfoVO doLogin(UserInfoVO ui) {
//		return uiMapper.doLogin(null);
//		
//	}
//	@PostMapping("/signup")
//	public int doSignup(UserInfoVO ui) {
//		return uiMapper.doSignup(null);
//		
//	}
//	@DeleteMapping("/delete")
//	public int deleteUser(UserInfoVO ui) {
//		return uiMapper.deleteUserInfos(null);
//		
//	}
//	@PutMapping("/update")
//	public int updateUSer(UserInfoVO ui) {
//		return uiMapper.updateUserInfo(null);
//		
//	}
	
	@Resource
	private UserInfoService uiService;
	
	@GetMapping("/users")
	public List<UserInfoVO> getUserInfoList(){
		return uiService.selectUserInfoList(null);
	}
	@PostMapping("/user/login")
	public UserInfoVO doLogin(@ModelAttribute UserInfoVO ui) {
		log.debug("user=>{}",ui);
		return uiService.doLogin(ui);
	}
	@PostMapping("/user/join")
	public int doSignup(@ModelAttribute UserInfoVO ui) {
		log.debug("user=>{}",ui);
		return uiService.doSignup(ui);
	}
}
