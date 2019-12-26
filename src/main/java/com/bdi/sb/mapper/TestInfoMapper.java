package com.bdi.sb.mapper;

import java.util.List;
import java.util.Map;

import com.bdi.sb.vo.TestInfoVO;

public interface TestInfoMapper {

	public List<TestInfoVO> selectTestInfoList(TestInfoVO test);
	public TestInfoVO selectOneTest(TestInfoVO test);
	public int totalTestInfoCount(TestInfoVO test);
	public int insertTest(TestInfoVO test);
	public int updateTest(TestInfoVO test);
	public int deleteTest(List<String> tiNums);

}
