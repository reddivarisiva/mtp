package com.ba1.demo.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ba1.demo.app.model.Demograph;

@Controller
public class BeneAdmin1Controller {

	@RequestMapping("/getBA1Info")
	public @ResponseBody Demograph getDemographicInfo() {
		Demograph demo = new Demograph();
		
		demo.setBa1ID(1);
		demo.setBa1Location("NY");
		
		return demo;
	}
	
}
