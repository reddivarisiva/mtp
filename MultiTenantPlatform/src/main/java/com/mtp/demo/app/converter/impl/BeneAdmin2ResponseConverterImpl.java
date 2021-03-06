package com.mtp.demo.app.converter.impl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.mtp.demo.app.converter.BeneAdminResponseConverter;
import com.mtp.demo.app.model.Demographic;
import com.mtp.demo.app.util.BeneAdminSystem;	

@Component("ba2ResponseConverterImpl")
public class BeneAdmin2ResponseConverterImpl implements BeneAdminResponseConverter{

	@Override
	public Demographic convert(BeneAdminSystem beneAdminSys) {
		Demographic demograph = new Demographic();
		long id;
		String location = "";
		
		JSONParser parser = new JSONParser(); 
		JSONObject json;
		try {
			json = (JSONObject) parser.parse(beneAdminSys.getResponseData());
			id = (Long)json.get("ba2ID");
			location = (String)json.get("ba2Location");
			demograph.setID(id);
			demograph.setLocation(location);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return demograph;
	}

}