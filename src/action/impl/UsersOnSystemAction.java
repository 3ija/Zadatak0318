package action.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import constants.ViewConstants;
import dao.UsersRepository;
import domain.User;
import util.SessionManager;

public class UsersOnSystemAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request) {
		
		boolean auth = SessionManager.authentication(request);
		if(!auth) {
			return ViewConstants.LOGIN;
		}
		
	
		
		request.setAttribute("users", SessionManager.getActive());
		
		//request.setAttribute("users", SessionManager.getActive2());
		
		return ViewConstants.USERS_ON_SYSTEM;
		
	}

}
