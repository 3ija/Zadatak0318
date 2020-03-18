package action.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import constants.ViewConstants;
import dao.UsersRepository;
import domain.User;
import util.SessionManager;

public class LoginAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request) {
		
		if(request.getMethod().equalsIgnoreCase("POST")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User loginUser = new User(username, password);
			
			List<User> users = UsersRepository.getUsers();
			for(User userTemp : users) {
				if(userTemp.getUsername().equals(username) && userTemp.getPassword().equals(password)) {
					SessionManager.init(loginUser, request);
					return ViewConstants.HOME;
				}
			}
			request.setAttribute("err", "Korisnik ne postoji!");
			return ViewConstants.LOGIN;
			
		} else {
			SessionManager.destory(request);
			return ViewConstants.LOGIN;
		}
		
	}

}
