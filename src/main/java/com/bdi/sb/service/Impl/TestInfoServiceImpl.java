package com.bdi.sb.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bdi.sb.mapper.TestInfoMapper;
import com.bdi.sb.service.TestInfoService;
import com.bdi.sb.vo.PageVO;
import com.bdi.sb.vo.TestInfoVO;

@Service
public class TestInfoServiceImpl implements TestInfoService {
	
	@Resource
	private TestInfoMapper tiMapper;
	

	@Override
	public Map<String,Object> selectTestInfoList(TestInfoVO test) {
		int startNum = test.getPage().getPage() *10 -10;
		test.getPage().setStartNum(startNum);
		Integer totalCount = tiMapper.totalTestInfoCount(test);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("list", tiMapper.selectTestInfoList(test));
		PageVO page = test.getPage();
		page.setTotalCount(totalCount);
		rMap.put("page", page);
		return rMap;
	}


	@Override
	public int insertTest(TestInfoVO test) {
		
		return tiMapper.insertTest(test);
	}


	@Override
	public Map<String,Object> updateTest(TestInfoVO test) {
		int cnt = tiMapper.updateTest(test);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("result", "false");
		rMap.put("msg", "업데이트실패");
		if(cnt==1) {
			if(tiMapper.updateTest(test)==1) {
				rMap.put("result", "true");
				rMap.put("msg", "업데이트성공");
			}
		}
		return rMap;
	}


	@Override
	public Map<String,Object> deleteTest(List<String> tiNums) {
		int cnt = tiMapper.deleteTest(tiNums);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg", "삭제실패");
		if(cnt==1) {
			if(tiMapper.deleteTest(tiNums)==1) {
				rMap.put("msg", "삭제성공");
			}
		}
		return rMap;
	}


	@Override
	public TestInfoVO selectOneTest(TestInfoVO test) {
		
		return tiMapper.selectOneTest(test);
	}


}
