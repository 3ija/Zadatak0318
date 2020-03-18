package controller;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import action.factory.ActionFactory;
import action.impl.LoginAction;
import constants.ViewConstants;

public class ApplicationController {
	
	public String processRequest(String pathInfo, HttpServletRequest request) {
		/* u zavisnosti od pathinfo, kreirati klasu koja je potrebna za obradu zahteva*/
		
		String page = ViewConstants.HOME;//default error page
		
		AbstractAction action = ActionFactory.createActionFactory(pathInfo);
		//if action = null, nije mapiran url na akciju
		if(action != null) {
			page = action.execute(request);
		}else {
			request.setAttribute("error", "Action " + request.getPathInfo() + " is not mapped to action!");
		}
		
		return page;
	}

}
