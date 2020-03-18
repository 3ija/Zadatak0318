package action.impl;

import javax.servlet.http.HttpServletRequest;

import action.AbstractAction;
import constants.ViewConstants;
import dao.UsersRepository;

public class AllAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request) {
		request.setAttribute("users", UsersRepository.getUsers());
		return ViewConstants.ALL;
	}

}
