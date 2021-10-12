package com.douzone.mysite.mvc.guestbook;

import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

public class GuestBookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		Action action = null;
		if("list".equals(actionName)) {
			action = new GuestBookListAction();
		}else if("write".equals(actionName)) {
			action = new GuestBookWriteAction();
		}else if("deleteform".equals(actionName)) {
			action = new GuestBookDeleteFormAction();
		}else if("delete".equals(actionName)) {
			action = new GuestBookDeleteAction();
		}
		return action;
	}

}
