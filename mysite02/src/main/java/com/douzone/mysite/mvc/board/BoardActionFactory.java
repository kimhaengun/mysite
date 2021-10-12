package com.douzone.mysite.mvc.board;

import com.douzone.mysite.mvc.main.MainAction;
import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		Action action = null;
		
		if("list".equals(actionName)) {
			action = new BoardListFormAction();
		}else if("writeform".equals(actionName)) {
			action = new BoardWriteFormAction();
		}else if("write".equals(actionName)) {
			action = new BoardWriteAction();
		}else {
			action = new MainAction();
		}
		
		return action;
	}

}
