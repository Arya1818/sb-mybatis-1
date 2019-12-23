package com.bdi.sb.util;

import cc.duduhuo.util.digest.Digest;

public class SHAUtil {
	
	private final static String SALT_KEY="dmsdo";
	
	public static String getSHA(String source) {
		String target = Digest.sha256Hex(source+SALT_KEY);  //뒤에다붙인것, 앞에붙여도됨!
		return target;
		
		//이렇게 여기다 만들어두고 로그인할때, 회원가입 할때  암호화를 하겠다?
	
	}
	public static void main(String[] args) {
		String pwd1 = SHAUtil.getSHA("1234");
		System.out.println(pwd1);
		String pwd2 = SHAUtil.getSHA("123456789");
		System.out.println(pwd2);
	}
}
