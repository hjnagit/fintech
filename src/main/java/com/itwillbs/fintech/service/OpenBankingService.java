package com.itwillbs.fintech.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.fintech.vo.RequestTokenVO;
import com.itwillbs.fintech.vo.ResponseTokenVO;

@Service
public class OpenBankingService {
	
	//OpenBankingApiClient 객체생성
	@Inject
	private OpenBankingApiClient openBankingApiClient;
	
	
	
	//토큰 발급 요청
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) {
		
		return openBankingApiClient.requestToken(requestTokenVO);
	}
	
	
	
	
	
	
}
