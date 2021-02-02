package com.mtp.demo.app.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BeneAdminService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private List<BeneAdminSystem> beneAdminInfo; 
	
	public BeneAdminService() {
		beneAdminInfo = new ArrayList<>();
		beneAdminInfo.add(new BeneAdminSystem("BA1", "DemograhicInfo", "http://localhost:8083/getBA1Info", null, null, "JSON"));
		beneAdminInfo.add(new BeneAdminSystem("BA2", "DemograhicInfo", "http://localhost:8084/getBA2Info", null, null, "JSON"));
	}
	
	public BeneAdminSystem getDetailsFromRest(String baName, String operation) throws ParseException{
		
		BeneAdminSystem beneInfo = findBeneInfoForSys(baName, operation);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
		
		String response = restTemplate.exchange(beneInfo.getUrl(), HttpMethod.GET, entity, String.class).getBody();
		
		beneInfo.setResponseData(response);
		
		return beneInfo;
		
	}

	private BeneAdminSystem findBeneInfoForSys(String baName, String operation) {
		return beneAdminInfo.stream()
				  .filter(baInfo -> baName.equals(baInfo.getName()) && operation.equals(baInfo.getOperation()))
				  .findAny()
				  .orElse(null);
	}

	
	
}
