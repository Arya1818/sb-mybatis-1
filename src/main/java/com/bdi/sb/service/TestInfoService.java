package com.bdi.sb.service;

import java.util.List;
import java.util.Map;

import com.bdi.sb.vo.TestInfoVO;

public interface TestInfoService {

	public Map<String,Object> selectTestInfoList(TestInfoVO test);
	public TestInfoVO selectOneTest(TestInfoVO test);
	public int insertTest(TestInfoVO test);
	public  Map<String,Object> updateTest(TestInfoVO test);
	public Map<String,Object> deleteTest(List<String> tiNums);
	
}
