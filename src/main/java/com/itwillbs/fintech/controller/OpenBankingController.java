package com.itwillbs.fintech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.fintech.vo.RequestTokenVO;

@Controller
public class OpenBankingController {
	
	@RequestMapping(value="/callback", method = RequestMethod.GET)
	public String getToken(RequestTokenVO requestTokenVO) throws Exception{
		//인증
		System.out.println(requestTokenVO.getCode() + "#####################");
		System.out.println(requestTokenVO.getScope() + "#####################");
		System.out.println(requestTokenVO.getClient_info() + "#####################");
		System.out.println(requestTokenVO.getState() + "#####################");
		
		//토큰발급
		
		//정보들고
		
		return "bank_main";
		
	}
	
	
}
