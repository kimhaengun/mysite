package com.douzone.mysite.vo;

public class SiteVo {
	private Long no; //no
	private String title; //타이틀 (Mysite)
	private String welcome; //인사말
	private String profile; //이미지 url
	private String description; //내용
	
	@Override
	public String toString() {
		return "SiteVo [no=" + no + ", title=" + title + ", welcome=" + welcome + ", profile=" + profile
				+ ", description=" + description + "]";
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWelcome() {
		return welcome;
	}
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
