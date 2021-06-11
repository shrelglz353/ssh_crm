package com.jz.web.action;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.jz.domain.BaseDict;
import com.jz.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport {
	
	private Logger logger = LogManager.getLogger(BaseDictAction.class);
	private String dict_type_code;
	
	private BaseDictService baseDictService;
	@Override
	public String execute() throws Exception {
		logger.fatal("dict_type_code="+dict_type_code);
		//获得list
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		logger.fatal(list);
		//转换为json
		String json = JSONArray.fromObject(list).toString();
		
		logger.fatal(json);
//		在action通过response向前台发送数据
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	
}
