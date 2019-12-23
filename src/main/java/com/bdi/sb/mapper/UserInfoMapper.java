package com.bdi.sb.mapper;

import java.util.List;

import com.bdi.sb.vo.UserInfoVO;

public interface UserInfoMapper {

	public List<UserInfoVO> selectUserInfoList(UserInfoVO ui);
	public UserInfoVO doLogin(UserInfoVO ui);
	
	public int doSignup(UserInfoVO ui);
	public int deleteUserInfos(UserInfoVO ui);
	public int updateUserInfo(UserInfoVO ui);
		

}
