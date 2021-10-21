package com.douzone.mysite.vo;

public class GalleryVo {
	private String comments;
	private String url;
	
	@Override
	public String toString() {
		return "GalleryVo [comments=" + comments + ", url=" + url + "]";
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
