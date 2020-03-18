package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersRepository;
import domain.User;

public class SessionManager {

	private static HashMap<Long, HttpSession> sessions = new HashMap();
	private static long counter = 0;
	private static List<User> active = new ArrayList<>();

	public static boolean authentication(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Boolean valid = (Boolean) session.getAttribute("login");
		if (valid == null) {
			return false;
		}
		return valid;
	}

	public static boolean destory(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			user.setPrijavljen(false);
			System.out.println("Odlogovan korisnik " + user.getUsername());
		}
		try {
			for (User tempUser : UsersRepository.getUsers()) {
				if (tempUser.getUsername().equals(user.getUsername())) {
					tempUser.setPrijavljen(false);
				}
			}
		} catch (Exception e) {

		}
		session.invalidate();
		return true;
	}

	public static boolean init(User user, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		sessions.put(++counter, session);
		session.setAttribute("counter", ++counter);
		session.setAttribute("login", true);
		session.setAttribute("user", user);
		for (User us : UsersRepository.getUsers()) {
			if (user.getUsername().equals(us.getUsername())) {
				us.setPrijavljen(true);
				System.out.println("Ulogovan korisnik " + user.getUsername());
			}
		}
		return true;
	}

	/*
	 * public static List<User> getActive(){ active.clear(); sessions.forEach((lo,
	 * session) -> { try { User temp = (User) session.getAttribute("user"); if(temp
	 * != null) active.add(temp); } catch(Exception e) { } } ); return active; }
	 */
	public static List<User> getActive2() {
		List<User> users = UsersRepository.getUsers();
		List<User> ret = new ArrayList<User>();
		for (User user : users) {
			if (user.isPrijavljen()) {
				ret.add(user);
			}
		}
		return ret;
	}

}
