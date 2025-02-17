package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.model.Order;
import com.utility.HibernateUtility;

public class foodDAOImpl implements foodDAO {

	@Override
	public int addData(Order food) {
		int i = 0;
		SessionFactory factory = HibernateUtility.getSessionFactory();

		Session session = factory.openSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(food);
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

	@Override
	public int DeleteData(int id) {
		int i = 0;
		SessionFactory factory = HibernateUtility.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Order food = (Order) session.get(Order.class, id);
		if (food != null) {

			session.delete(food);
			tx.commit();
			i++;
		} else {
			System.out.println("Not Existed Data In database");
		}

		session.close();
		return i;

	}

	@Override
	public List<Order> ReadData() {
		List<Order> list = new ArrayList<>();
		SessionFactory factory = HibernateUtility.getSessionFactory();

		try (Session session = factory.openSession()) {
			String hql = "FROM Order";
			Query<Order> query = session.createQuery(hql, Order.class);

			list = query.list();

			System.out.println("All Food fetched successfully");
		} catch (Exception e) {
			System.out.println("Error reading data: " + e);
		}

		return list;
	}

	@Override
	public int UpdateData(Order food) {
		int i = 0;
		SessionFactory factory = HibernateUtility.getSessionFactory();

		Session session = factory.openSession();

		Order e1 = (Order) session.get(Order.class, food.getId());

		if (e1 != null) {
			e1.setName(food.getName());
			e1.setProduct_name(food.getProduct_name());
			e1.setQty(food.getQty());
			e1.setPrice(food.getPrice());
			Transaction tx = session.beginTransaction();

			session.update(e1);

			tx.commit();
			i++;
		} else {
			System.out.println("Id Not Found");

		}

		session.close();
		return i;
	}

	@Override
	public Order ReadDatabyId(int id) {
		Order food = null;
		SessionFactory factory = HibernateUtility.getSessionFactory();

		try (Session session = factory.openSession()) {

			Order e1 = (Order) session.get(Order.class, id);

			if (e1 != null) {

				food = new Order(id, e1.getName(), e1.getProduct_name(), e1.getQty(), e1.getPrice());

				return food;

			} else {
				System.out.println("Id Not Found");

			}

		} catch (Exception e) {
			System.out.println("Error reading data: " + e);
		}

		return food;
	}

	@Override
	public boolean checkStudent(Order food) {
		// TODO Auto-generated method stub
		return false;
	}

}
