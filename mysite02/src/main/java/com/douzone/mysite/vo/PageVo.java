package com.douzone.mysite.vo;

public class PageVo {
	private Long totalCount;
	private Long leftCount;
	private Long count;
	private Long rightCount;
	private Long viewCount;
	
	@Override
	public String toString() {
		return "PageVo [totalCount=" + totalCount + ", leftCount=" + leftCount + ", count=" + count + ", rightCount="
				+ rightCount + ", viewCount=" + viewCount + "]";
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public Long getLeftCount() {
		return leftCount;
	}
	public void setLeftCount(Long leftCount) {
		this.leftCount = leftCount;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getRightCount() {
		return rightCount;
	}
	public void setRightCount(Long rightCount) {
		this.rightCount = rightCount;
	}
	public Long getViewCount() {
		return viewCount;
	}
	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}
	
	
}
