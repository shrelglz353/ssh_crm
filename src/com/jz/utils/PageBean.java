package com.jz.utils;

import java.util.List;

public class PageBean {
	private Integer currentPage;//当前页码
	private Integer totalCount;	//总记录数
	private Integer pageSize;	//每页记录大小
	private Integer totalPage;	//总页数
	private List list;			//详细信息
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		if(this.currentPage == null || this.currentPage < 0 ) {
			this.currentPage = 1;
		}
		this.pageSize = pageSize;
		if(this.pageSize == null) {
			this.pageSize = 3;
		}
		
		this.totalPage = (this.totalCount + this.pageSize-1)/this.pageSize;
		
		if(this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
		
	}
	//计算起始索引
	public int getStart() {
		return (this.currentPage-1)*this.pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
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
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", totalCount=" + totalCount + ", pageSize=" + pageSize
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}
	

}
