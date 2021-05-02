package com.jz.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jz.dao.UserDao;
import com.jz.domain.User;
import com.jz.service.UserService;

//Hibernate进行测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	
	
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	
	//hibernate基础配置测试
	@Test
	public void fun1() {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_code("tom");
		u.setUser_name("哈哈");
		u.setUser_password("123");
		u.setUser_state('1');
		session.save(u);
		
		tx.commit();
		session.close();
		sf.close();
	}
	//hibernate加载配置 方案一 测试
	@Test
	public void fun2() {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_code("jz");
		u.setUser_name("aa");
		u.setUser_password("123");
		session.save(u);
		
		tx.commit();
		session.close();
		
	}
	//hibernate加载配置 方案二 测试
	@Test
	public void fun3() {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setUser_code("jz2222");
		u.setUser_name("aa");
		u.setUser_password("123");
		session.save(u);
		
		tx.commit();
		session.close();
		
	}
	//测试hibernate模板（Spring对hibernate的封装）
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	public void fun4() {
		User u = ud.getByUserCode("jz");
		System.out.println(u);
	}
	
	
	//对事务进行测试
	@Resource(name="userService")
	private UserService us;
	@Test
	public void fun5() {
		User u = new User();
		u.setUser_code("cxj");
		u.setUser_name("jiege");
		u.setUser_password("22");
		us.saveUser(u);
	}
}
