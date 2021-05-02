package com.jz.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.jz.domain.Customer;
import com.jz.service.CustomerService;
import com.jz.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	
	private Customer customer = new Customer();
	
	private CustomerService cs;

	private Integer currentPage;
	private Integer pageSize;
	

	//�ͻ��б����
	public String  list() {
		//���߲�ѯ
		DetachedCriteria dc  = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCust_name())) {//�ں��Կո������£������Ƿ�Ϊ��
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));//����������
		}
		//����service�õ���ҳ����
		PageBean pc = cs.getPageBean(dc,currentPage,pageSize);
		//���ý����ݷ���request����
		ActionContext.getContext().put("pageBean", pc);
		return "list";
	}

	
	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	@Override
	public Customer getModel() {
		return customer;
	}
}
