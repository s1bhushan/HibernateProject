package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.Employee;
import com.utility.HibernateUtility;

public class empDAOImpl implements empDAO{
	public int addData(Employee emp) {
		int i=0;
		SessionFactory factory=HibernateUtility.getSessionFactory();
		
		
		Session session=factory.openSession();
		
		Transaction tx=null;
		
		try {
			tx = session.beginTransaction();
			session.save(emp);
			tx.commit();
			i++;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
			
		}
		return i;
	
	}
	
	public int DeleteData(int id) {
		int i=0;
		SessionFactory factory=HibernateUtility.getSessionFactory();

		
		Session session = factory.openSession();
		
		
		
		Transaction tx=session.beginTransaction();

		Employee emp = (Employee) session.get(Employee.class, id);
		if (emp != null) {

			session.delete(emp);
			tx.commit();
			i++;
		} else {
			System.out.println("Not Existed Data In database");
		}

		session.close();
		return i;
		  
	}

	
	public Employee ReadDatabyId(int id) {
		
		Employee emp = null;
		SessionFactory factory=HibernateUtility.getSessionFactory();

		try(Session session = factory.openSession()){
			 emp = (Employee) session.load(Employee.class, id);
			 return emp;

		}catch (Exception e) {
	        System.out.println("Error reading data: " + e);
	    }
		
		return emp;
		
	}
	

	
	public List<Employee> ReadData() {
	    List<Employee> listP = new ArrayList<Employee>();

	    SessionFactory factory = HibernateUtility.getSessionFactory();

	    try (Session session = factory.openSession()) {
	        String hql = "FROM Employee";  
	        Query<Employee> query = session.createQuery(hql, Employee.class);

	        listP = query.list(); 

	        System.out.println("All Employee fetched successfully");
	    } catch (Exception e) {
	        System.out.println("Error reading data: " + e);
	    }

	   
	    
	    return listP;  
	}
	
	

	public int UpdateData(Employee emp) {
		int i=0;
		SessionFactory factory=HibernateUtility.getSessionFactory();


		Session session = factory.openSession();

		Employee e1 = (Employee) session.get(Employee.class, emp.getId());
		
		if(e1!=null) {
			e1.setName(emp.getName());
			
			e1.setSalary(emp.getSalary());
			Transaction tx=session.beginTransaction();
			
			session.update(e1);
			
			tx.commit();
			i++;
		}
		else {
			System.out.println("Id Not Found");
			
		}
	
		session.close();
		return i;
		


	}
}
