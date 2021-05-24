package com.jz.utils;

import java.lang.reflect.ParameterizedType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ����Ϊlog4j2����д������
 * ʹ��ʱ��A extends Mylog4j2<T>
 * 		a.getLogger ��� Logger ���в���
 * */
 public class Mylog4j2<T> {
	
	 public Logger getLogger() {
		Class <T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]; 
		//�õ���ǰ���͵Ĵ��з������͵ĸ��ࣨ�������class��
		ParameterizedType ptClass = (ParameterizedType) getClass().getGenericSuperclass();
		//�������ʱ�ڵķ������ͣ���Ϊ���Ϳ����ж�����������±꣩(T��class)
		Class clazz = (Class) ptClass.getActualTypeArguments()[0];
		//����logger
		return LogManager.getLogger(clazz);
	}

}
