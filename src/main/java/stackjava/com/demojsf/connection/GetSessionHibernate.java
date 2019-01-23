package stackjava.com.demojsf.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import stackjava.com.demojsf.model.Category;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.criteria.CriteriaBuilder;

import org.apache.log4j.Logger;

@ManagedBean
@SessionScoped
public class GetSessionHibernate {

//	public final static Logger logger = Logger.getLogger(GetSessionHibernate.class);

	// Method Used To Create The Hibernate's SessionFactory Object
	public static SessionFactory getSessionFactory() {
		// Creating Configuration Instance & Passing Hibernate Configuration
		// File
		Configuration configObj = new Configuration();
		configObj.configure("hibernate.cfg.xml");

		// Since Hibernate Version 4.x, Service Registry Is Beingcung Used
		ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder()
				.applySettings(configObj.getProperties()).build();

		// Creating Hibernate Session Factory Instance
		SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);
		return factoryObj;
	}
	
	

	public Integer createRecord(Object e) {
		Session sessionObj = getSessionFactory().openSession();

		// Creating Transaction Object
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(e);

		// Transaction Is Committed To Database
		transObj.commit();

		// Closing The Session Object
		sessionObj.close();
//		logger.info("Successfully Created " + e.toString());
		return 1;
	}

	public Integer deleteRecord(Object e) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction tranObj = sessionObj.beginTransaction();
		sessionObj.delete(e);
		tranObj.commit();
		sessionObj.close();
		return 1;
	}

	public Integer updateRecord(Object e) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction tranObj = sessionObj.beginTransaction();
		sessionObj.update(e);
		tranObj.commit();
		sessionObj.close();
		return 1;
	}

}
