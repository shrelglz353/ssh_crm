package com.jz.utils;

import java.util.List;

public class PageBean {
	private Integer currentPage;//��ǰҳ��
	private Integer totalCount;	//�ܼ�¼��
	private Integer pageSize;	//ÿҳ��¼��С
	private Integer totalPage;	//��ҳ��
	private List list;			//��ϸ��Ϣ
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
	//������ʼ����
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
