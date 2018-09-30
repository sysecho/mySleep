package com.sysecho.mysleep.response;

public class ResponseData {
	private boolean success;
	
	private String msg;
	
	private String code;
	
	private Integer total;
	
	private Object rows;
	
	public ResponseData(){
		
	}
	
	public ResponseData(boolean success,String msg,String code){
		this.success = success;
		this.msg = msg;
		this.code = code;
	}	

	public ResponseData(boolean success,String msg,String code,Object rows,Integer total){
		this.success = success;
		this.msg = msg;
		this.rows = rows;
		this.total = total;
	}
	

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	
	
}
