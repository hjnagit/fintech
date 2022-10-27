package com.itwillbs.fintech.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.itwillbs.fintech.vo.RequestTokenVO;
import com.itwillbs.fintech.vo.ResponseTokenVO;

@Service
public class OpenBankingApiClient {
	
	//변수 정의
	private String client_id="6f948a13-11af-4892-b746-ee67d358abf2";
	private String client_secret="4008271b-939d-4ee9-a981-5a132490eafc";
	private String redirect_uri="http://localhost:8088/fintech/callback";
	private String grant_type="authorization_code";
	
	//ajax를 보안상 못쓰는데 있어서 - 보안상으로...
	//REST 방식 API 요청
	private RestTemplate restTemplate;
	// 헤더 정보 관리 클래스
	private HttpHeaders httpHeaders;
	
	
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) {
		
		
		//요청 메세지 url
		//http url 	https://testapi.openbanking.or.kr/oauth/2.0/token
		//http method post
		//Contect-type  application/x-www-form-urlencoded; charset=UTF-8
			
		//필요한 값
		//code client_id client_secret refresh_token scope grant_type
		
		restTemplate = new RestTemplate();
		httpHeaders = new HttpHeaders();
		
		//Content-Type 지정 http header
		httpHeaders.add("Contect-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		
		requestTokenVO.setRequestToken(client_id, client_secret, redirect_uri, grant_type);
		//이러한 형태는 객체 전달 불가넝이라...
		//저장하려면 이것을 사용
		MultiValueMap<String, String> parameters 
					= new LinkedMultiValueMap<String, String>();
		parameters.add("code", requestTokenVO.getCode());
		parameters.add("client_id", requestTokenVO.getClient_id());
		parameters.add("client_secret", requestTokenVO.getClient_secret());
		parameters.add("redirect_uri", requestTokenVO.getRedirect_uri());
		parameters.add("grant_type", requestTokenVO.getGrant_type());
		
		//HttpHeader,HttpBody parameters 담아서 간다 => HttpEntity로 담는다
		HttpEntity<MultiValueMap<String, String>> param = 
				new HttpEntity<MultiValueMap<String,String>>(parameters, httpHeaders);
		
		
		
		String requestUrl = "https://testapi.openbanking.or.kr/oauth/2.0/token";
		
		
		return restTemplate.exchange(requestUrl, HttpMethod.POST, param, ResponseTokenVO.class).getBody();
	}
}
