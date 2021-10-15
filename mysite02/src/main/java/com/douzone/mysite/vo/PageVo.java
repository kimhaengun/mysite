package com.douzone.mysite.vo;

public class PageVo {
	private Long totalCount;//총 게시물 수
	private Long count; // 
	private Long viewCount; //뿌려지는 페이징 수
	private Long firstViewCount; //시작 페이지
	private Long endViewCount; // 끝 페이지
	private Long page; //현재 페이지
	@Override
	public String toString() {
		return "PageVo [totalCount=" + totalCount + ", count=" + count + ", viewCount=" + viewCount
				+ ", firstViewCount=" + firstViewCount + ", endViewCount=" + endViewCount + ", page=" + page + "]";
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getViewCount() {
		return viewCount;
	}
	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}
	public Long getFirstViewCount() {
		return firstViewCount;
	}
	public void setFirstViewCount(Long firstViewCount) {
		this.firstViewCount = firstViewCount;
	}
	public Long getEndViewCount() {
		return endViewCount;
	}
	public void setEndViewCount(Long endViewCount) {
		this.endViewCount = endViewCount;
	}
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}

	
	
}
