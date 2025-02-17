package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Fashion;
import com.model.Laptop;
import com.model.Mobile;
import com.utility.HibernateUtility;

public class customerDAOImpl implements customerDAO{

	
	@Override
	public void saveFashion(Fashion fashion) {
		
		SessionFactory factory=HibernateUtility.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.save(fashion);
		
		tx.commit();
		
		session.close();
		System.out.println("Fashion  Added Succes ! ! !");
		
	}
	
	@Override
	public void saveMobile(Mobile mobile) {
		
		SessionFactory factory=HibernateUtility.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.save(mobile);
		
		tx.commit();
		
		session.close();
		System.out.println("Mobile Added Succes ! ! !");
		
	}
	
	@Override
	public void saveLaptop(Laptop laptop) {
		
		SessionFactory factory=HibernateUtility.getSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		session.save(laptop);
		
		tx.commit();
		
		session.close();
		System.out.println("Laptop Added Succes ! ! !");
		
	}
	
	
}
