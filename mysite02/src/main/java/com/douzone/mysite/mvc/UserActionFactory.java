package com.douzone.mysite.mvc;

import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		Action action = null;
		if("joinform".equals(actionName)) {
			action = new JoinFormAction();
			
		}else if("join".equals(action)){
//			action = new JoinAction();
		}
		else {
			action = new MainAction();
		}
		
		return action;
	}

}
