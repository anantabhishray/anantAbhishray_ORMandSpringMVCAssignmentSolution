package com.greatlearning.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.customer.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionFactory;

	private Session session;

	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<Customer> findAll() {
		
		Transaction tx = session.beginTransaction();

		List<Customer> customers = session.createQuery("from Customer").list();

		tx.commit();

		return customers;
	}

	@Transactional
	public Customer findById(int id) {

		Customer customer = new Customer();

		
		Transaction tx = session.beginTransaction();

		customer = session.get(Customer.class, id);

		tx.commit();

		return customer;
	}

	@Transactional
	public void save(Customer theCustomer) {

		
		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(theCustomer);

		tx.commit();

	}

	@Transactional
	public void deleteById(int id) {

	
		Transaction tx = session.beginTransaction();

		Customer customer = session.get(Customer.class, id);

		session.delete(customer);

		tx.commit();

	}

	@Transactional
	public List<Customer> searchBy(String firstname, String email) {

		
		Transaction tx = session.beginTransaction();
		String query = "";
		if (firstname.length() != 0 && email.length() != 0)
			query = "from Customer where firstname like '%" + firstname + "%' or email like '%" + email + "%'";
		else if (firstname.length() != 0)
			query = "from Customer where firstname like '%" + firstname + "%'";
		else if (email.length() != 0)
			query = "from Customer where email like '%" + email + "%'";
		else
			System.out.println("Cannot search without input data");

		List<Customer> customer = session.createQuery(query).list();

		tx.commit();

		return customer;
	}

	@Transactional
	public void print(List<Customer> customer) {

		for (Customer b : customer) {
			System.out.println(b);
		}
	}

}