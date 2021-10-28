package com.douzone.mysite.dto;

public class JsonResult {
	private String result; // success or fail
	private Object data; // success 시 data 셋팅
	private String message; // fail 면 error 메시지 던지기

	private JsonResult() {
	}

	private JsonResult(Object data) {
		result = "success";
		this.data = data;
		message= null;
	}

	private JsonResult(String message) {
		result = "fail";
		data = null;
		this.message = message;
	}
	
	public static JsonResult success(Object data) {
		return new JsonResult(data);
	}
	
	public static JsonResult fail(String message) {
		return new JsonResult(message);
	}

	// Jackson이 값을 가지고 오기 위해 GET이 필요함..
	public String getResult() {
		return result;
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}


	
	
}
