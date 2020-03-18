package view;

import java.util.HashMap;
import java.util.Map;

import constants.PageConstants;
import constants.ViewConstants;

public class ViewResolver {

	private Map<String, String> pages;

	public ViewResolver() {
		pages = new HashMap<String, String>() {
			{
				put(ViewConstants.HOME, PageConstants.PAGE_HOME);
				put(ViewConstants.LOGIN, PageConstants.PAGE_LOGIN);
				put(ViewConstants.ALL, PageConstants.PAGE_ALL);
				put(ViewConstants.ADD, PageConstants.PAGE_ADD);
				put(ViewConstants.USERS_ON_SYSTEM, PageConstants.PAGE_USERS_ON_SYSTEM);
			}
		};
	}

	public String getPage(String view) {
		if (pages.containsKey(view))
			return pages.get(view);
		return null;
	}

}
