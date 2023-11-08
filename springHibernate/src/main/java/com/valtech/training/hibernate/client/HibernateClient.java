package com.valtech.training.hibernate.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.hibernate.Account;
import com.valtech.training.hibernate.Address;
import com.valtech.training.hibernate.AtmTx;
import com.valtech.training.hibernate.BankAccount;
import com.valtech.training.hibernate.BankAccountId;
import com.valtech.training.hibernate.ChequeTx;
import com.valtech.training.hibernate.Customer;
import com.valtech.training.hibernate.Employee;
//import com.valtech.training.hibernate.RegAddress;
import com.valtech.training.hibernate.Registration;
import com.valtech.training.hibernate.TellerTx;
import com.valtech.training.hibernate.Tx;

public class HibernateClient {

	public static void main(String[] args) throws Exception, Exception {
		DateFormat df = new SimpleDateFormat("dd-MM-yyy");
		AnnotationConfiguration cfg = new AnnotationConfiguration();
//		This will automatically load the hibernate.properties file and check for the config
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Tx.class).addAnnotatedClass(ChequeTx.class).addAnnotatedClass(AtmTx.class)
				.addAnnotatedClass(TellerTx.class);
		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Address.class);
		cfg.addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Registration.class);
		cfg.addAnnotatedClass(BankAccount.class);
		SessionFactory sesFac = cfg.buildSessionFactory();
		Session session1 = sesFac.openSession();
		Transaction tx = session1.beginTransaction();

		session1.persist(new BankAccount(new BankAccountId("Savings", 1), 1112121));
		
		BankAccountId id = new BankAccountId("Savings", 1);
		BankAccount bankAccount1 =(BankAccount)session1.load(BankAccount.class, id);
		
//		Customer customer1 = new Customer("Akhil", 22);
//		session1.save(customer1);
//		Address address1 = new Address("Nirvana Country", "Gurgaon", "122018");
//		address1.setCustomer(customer1);
//		customer1.setAddress(address1);
//		session1.save(address1);
//
//		Account account1 = new Account(100000, "Savings");
//		Tx tx1 = new Tx(1000);
//		Tx tx2 = new ChequeTx(2000, 1232421, 3121212);
//		Tx tx3 = new TellerTx(3000, 123, 345);
//		Tx tx4 = new AtmTx(5000, 789);
//		
//		Account account2 = new Account(200000, "Current");
//		Tx tx5 = new ChequeTx(2500, 14123412, 123123);
//		
//		Customer customer2 = new Customer("Murali", 21);
//		Address address2 = new Address("JP Nagar", "Bangalore", "560070");
//		Customer customer3 = new Customer("Chandana", 22);
//		Address address3 = new Address("Lingarajapuram", "Bangalore", "560084");
//		
//		session1.persist(account1);
//		session1.persist(tx1);
//		session1.persist(tx2);
//		session1.persist(tx3);
//		session1.persist(tx4);
//		
//		session1.persist(account2);
//		session1.persist(tx5);
//		session1.persist(customer2);
//		session1.persist(customer3);
//		session1.persist(address2);
//		session1.persist(address3);
//
//		account1.addTx(tx1);
//		account1.addTx(tx2);
//		account1.addTx(tx3);
//		account1.addTx(tx4);
//		account1.addTx(tx5);
//		
//		customer2.setAddress(address2);
//		address2.setCustomer(customer2);
//		customer3.setAddress(address3);
//		address3.setCustomer(customer3);
//		
//		account1.addCustomer(customer1);
//		account1.addCustomer(customer2);
//		account1.addCustomer(customer3);
//		account2.addCustomer(customer1);
//		account2.addCustomer(customer2);

//		org.hibernate.Query query = session1
//				.createQuery("SELECT DISTINCT c FROM Customer c join c.accounts a join a.txs t where t.amount > ?");
//		query.setFloat(0, 3000);
//		query.list().forEach(t-> System.out.println(t));

		
//		Query query = session1.getNamedQuery("Tx.findAllByCityAndAmountGreaterThan");
		Query query = session1
				.createQuery("SELECT t from Tx t JOIN t.account.customers c WHERE c.address.city = ? AND t.amount > ?");
		query.setString(0, "Gurgaon");
		query.setFloat(1, 3000);
		query.list().forEach(t -> System.out.println(t));

//		session1.createQuery("SELECT DISTINCT tx.account FROM Tx tx").list().forEach(t -> System.out.println(t));

//		session1.persist(new Employee("Akhil", df.parse("28-05-2001"), 52000, 'M', true));
//		int id = (Integer)session1.save(new Employee("Akhil", df.parse("28-05-2001"), 52000, 'M', true));
//		persist method means create 

//		Employee e = (Employee)session1.get(Employee.class, 1);
//		System.out.println(e.getClass().getName());
//		e.setName("Akhil3");

//		session1.merge(e);

		System.out.println("Loading...");

		tx.commit();
		session1.close();
		sesFac.close();
	}

}
