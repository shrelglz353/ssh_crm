package com.jz.utils;

import java.lang.reflect.ParameterizedType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 本类为log4j2的自写工具类
 * 使用时：A extends Mylog4j2<T>
 * 		a.getLogger 获得 Logger 进行操作
 * */
 public class Mylog4j2<T> {
	
	 public Logger getLogger() {
		Class <T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
		//得到当前类型的带有泛型类型的父类（即本类的class）
		ParameterizedType ptClass = (ParameterizedType) getClass().getGenericSuperclass();
		//获得运行时期的泛型类型（因为泛型可以有多个，所以有下标）(T的class)
		Class clazz = (Class) ptClass.getActualTypeArguments()[0];
		//返回logger
		return LogManager.getLogger(clazz);
	}

}
