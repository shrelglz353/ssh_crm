package com.jz.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.jz.domain.Customer;
import com.jz.service.CustomerService;
import com.jz.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Logger logger = LogManager.getLogger(CustomerAction.class);
	//模型驱动
	private Customer customer = new Customer();
	
	//属性驱动（Spring自动装配时使用）
	private CustomerService cs;
	//属性驱动 (前台from表单提交时，在customer字段没有找到的其他属性，进行属性驱动接受)
	private Integer currentPage;
	private Integer pageSize;
	

	//客户列表参数
	public String  list() {
		
		//离线查询
		DetachedCriteria dc  = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCust_name())) {//在忽略空格的情况下，内容是否为空
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));//将条件加入
		}
		//调用service得到分页数据
		//debug日志
		logger.fatal("currentPage="+currentPage+" pageSize="+ pageSize +
				"条件："+customer.getCust_name());
		
		PageBean pc = cs.getPageBean(dc,currentPage,pageSize);
		//调用将数据放入request域中
		ActionContext.getContext().put("pageBean", pc);
		return "list";
	}

	
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}
	

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	@Override
	public Customer getModel() {
		return customer;
	}
}
