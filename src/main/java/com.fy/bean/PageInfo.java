package com.fy.bean;

public class PageInfo {
	
	/**第几页*/
	private Integer currentPage;
	/**每页几条*/
	private Integer pageSize;
	/**共几页*/
	private Integer totalPage;
	/**共几条*/
	private Integer totalSize;
	/**第多少条开始*/
	private Integer start;
	/**第多少条结束*/
	private Integer end;
	
	/**登录token*/
	private String rbacToken;
	/**权限token*/
	private String authToken;
	
	private Integer int_param0;//sql条件备用参数0-Integer
	private Integer int_param1;//sql条件备用参数1-Integer
	private Integer int_param2;//sql条件备用参数2-Integer
	private Integer int_param3;//sql条件备用参数3-Integer
	private String str_param0;//sql条件备用参数0-String
	private String str_param1;//sql条件备用参数1-String
	private String str_param2;//sql条件备用参数2-String
	private String str_param3;//sql条件备用参数3-String
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public String getRbacToken() {
		return rbacToken;
	}
	public void setRbacToken(String rbacToken) {
		this.rbacToken = rbacToken;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public Integer getInt_param0() {
		return int_param0;
	}
	public void setInt_param0(Integer int_param0) {
		this.int_param0 = int_param0;
	}
	public Integer getInt_param1() {
		return int_param1;
	}
	public void setInt_param1(Integer int_param1) {
		this.int_param1 = int_param1;
	}
	public Integer getInt_param2() {
		return int_param2;
	}
	public void setInt_param2(Integer int_param2) {
		this.int_param2 = int_param2;
	}
	public Integer getInt_param3() {
		return int_param3;
	}
	public void setInt_param3(Integer int_param3) {
		this.int_param3 = int_param3;
	}
	public String getStr_param0() {
		return str_param0;
	}
	public void setStr_param0(String str_param0) {
		this.str_param0 = str_param0;
	}
	public String getStr_param1() {
		return str_param1;
	}
	public void setStr_param1(String str_param1) {
		this.str_param1 = str_param1;
	}
	public String getStr_param2() {
		return str_param2;
	}
	public void setStr_param2(String str_param2) {
		this.str_param2 = str_param2;
	}
	public String getStr_param3() {
		return str_param3;
	}
	public void setStr_param3(String str_param3) {
		this.str_param3 = str_param3;
	}
	
}
