package dao;

import java.util.ArrayList;
import java.util.List;

import domain.User;

public class UsersRepository {

	private static List<User> users = new ArrayList<User>();
	
	public static List<User> getUsers(){
		return users;
	}
	
	static {
		users.add(new User("root","root","root","root"));
	}
	
	public static String addUser(User user) {
		for(User temp : users) {
			if(temp.getUsername().equals(user.getUsername())) {
				return "Greska unesti username vec postoji!";
			}
		}
		users.add(user);
		return "Uspesno dodat!";
	}
	
	
	
}
