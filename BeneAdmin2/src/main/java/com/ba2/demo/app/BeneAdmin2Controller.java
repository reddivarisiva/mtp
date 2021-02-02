package com.ba2.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ba2.demo.app.model.Demograph;

@Controller
public class BeneAdmin2Controller {

	@RequestMapping("/getBA2Info")
	public @ResponseBody Demograph getDemographicInfo() {
		Demograph demo = new Demograph();
		
		demo.setBa2ID(1);
		demo.setBa2Location("AZ");
		
		return demo;
	}
	
}
