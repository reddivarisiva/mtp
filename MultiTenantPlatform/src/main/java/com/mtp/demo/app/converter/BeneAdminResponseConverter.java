package com.mtp.demo.app.converter;

import com.mtp.demo.app.model.Demographic;
import com.mtp.demo.app.util.BeneAdminSystem;

public interface BeneAdminResponseConverter{
	
	public Demographic convert(BeneAdminSystem beneAdminSys);

}
