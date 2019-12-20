package com.bdi.sb.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("ui")
@Data

public class UserInfoVO {
	private Integer uiNum;
	private Integer[] uiNums;
	private String uiName;
	private String uiId;
	private String uiPwd;
	private String credat;
	private String cretim;
	private String moddat;
	private String modtim;
	private String active;
	private String serchStr;
	private String[] search;
	
}
