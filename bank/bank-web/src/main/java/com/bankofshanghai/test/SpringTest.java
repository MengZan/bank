package com.bankofshanghai.test;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.FileCopyUtils;

public class SpringTest {

	public static void main3(String[] args) {
		// Spring JDBC
		TestDao dao = new TestDao();
		String configPath = "classpath:spring/test.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		dao.setJdbcTemplate(jdbcTemplate);
		AdminUser user = new AdminUser();
		user.setUsername("ZZ");
		user.setPassword("111");
		dao.addUser(user);
		AdminUser user2 = dao.getUserById((long)3);
		System.out.println(user2.getUsername());
	}

	public static void main2(String[] args) {
		// AOP
		String configPath = "classpath:spring/test.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter) ctx.getBean("waiter");
		Seller seller = (Seller) ctx.getBean("seller");
		waiter.greetTo("MM");
		waiter.serveTo("MM");
		waiter.getTips(10);
		seller.greetTo("ZZ");
	}

	public static void main(String[] args) throws IOException {
		// 资源读取
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("classpath:sql/file.txt");
		EncodedResource er = new EncodedResource(resource, "UTF-8");
		String content = FileCopyUtils.copyToString(er.getReader());
		
	}
}
