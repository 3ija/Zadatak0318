package action.impl;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import constants.ViewConstants;
import dao.UsersRepository;
import domain.User;
import util.SessionManager;

public class AddAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request) {
		
		boolean auth = SessionManager.authentication(request);
		if(!auth) {
			return ViewConstants.LOGIN;
		}
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			
			User addUser = new User(username, password, firstname, lastname);
			String err = UsersRepository.addUser(addUser);
			request.setAttribute("err", err);
			return ViewConstants.ADD;
		} else {
			return ViewConstants.ADD;
		}
	}

}
