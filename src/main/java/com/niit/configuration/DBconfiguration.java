package com.niit.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.ProductDao;
import com.niit.dao.ProductDaoImpl;
import com.niit.services.ProductServices;
import com.niit.services.ProductServicesImpl;

@Configuration
@EnableTransactionManagement
public class DBconfiguration {
	@Bean(name="getBasicData")
	public DataSource getDataSource() {
		BasicDataSource getBasicData=new BasicDataSource();
		getBasicData.setDriverClassName("org.h2.Driver");
		getBasicData.setUrl("jdbc:h2:tcp://localhost/~/kuhu1");
		getBasicData.setUsername("sa");
		getBasicData.setPassword("sa");
		return getBasicData;	
	}
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder local=new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2dialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		local.addProperties(hibernateProperties);
		Class classes[]=new Class[]{};
		return local.addAnnotatedClasses(classes).buildSessionFactory();
	}
	@Bean
	public HibernateTransactionManager hibTransManagement(){
		return new HibernateTransactionManager(sessionFactory());
	}
	@Bean(name="productDAO")
	public ProductDao getProductDao() {
		System.out.println("---Product bean is created---");
		return new ProductDaoImpl();
	}
	@Bean(name="productService")
	public ProductServices getProductServices() {
		System.out.println("---Product srvice is created---");
		return new ProductServicesImpl();
	}
}
