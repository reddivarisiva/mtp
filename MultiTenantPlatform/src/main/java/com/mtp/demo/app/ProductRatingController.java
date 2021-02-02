package com.mtp.demo.app;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtp.demo.app.converter.BeneAdminResponseConverter;
import com.mtp.demo.app.model.Demographic;
import com.mtp.demo.app.util.BeneAdminService;
import com.mtp.demo.app.util.BeneAdminSystem;

@Controller
public class ProductRatingController {

	@Autowired
	private BeneAdminService beneAdminService;
	
	@Autowired
	@Qualifier("ba1ResponseConverterImpl")
	private BeneAdminResponseConverter ba1ResponseConverterImpl;
	
	@Autowired
	@Qualifier("ba2ResponseConverterImpl")
	private BeneAdminResponseConverter ba2ResponseConverterImpl;
	
	@RequestMapping("/getDemographicInfo")
	public @ResponseBody Demographic getDemographicInfo(@RequestParam String baName, @RequestParam String operation) throws ParseException {
		
		BeneAdminSystem beneAdminSys = beneAdminService.getDetailsFromRest(baName, operation);
		
		return ba2ResponseConverterImpl.convert(beneAdminSys);
	    
	}
	
}
