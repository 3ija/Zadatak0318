package action.factory;

import action.AbstractAction;
import action.impl.AddAction;
import action.impl.AllAction;
import action.impl.HomeAction;
import action.impl.LoginAction;
import action.impl.UsersOnSystemAction;

public class ActionFactory {
	public static AbstractAction createActionFactory(String actionName) {
		AbstractAction action = null;
		System.out.println("ActionFactory klasa, string actionName = " + actionName);
		
		if(actionName.equalsIgnoreCase("/login")) {
			action = new LoginAction();
		}
		
		if(actionName.equalsIgnoreCase("/home")) {
			action = new HomeAction();
		}
		
		if(actionName.equalsIgnoreCase("/all")) {
			action = new AllAction();
		}
		
		if(actionName.equalsIgnoreCase("/add")) {
			action = new AddAction();
		}
		
		if(actionName.equalsIgnoreCase("/usersOnSystem")) {
			action = new UsersOnSystemAction();
		}
		
		
		return action;
	}
}
