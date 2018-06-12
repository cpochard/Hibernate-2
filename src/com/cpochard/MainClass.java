package com.cpochard;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		
		testOneToOneUnilateral();
		testOneToOneBilateral();
		testManyToOneUnilateral();
		
	}
	
	public static void testOneToOneUnilateral () {
		Appartement appart = new Appartement (3, 40, "blanc");
		Canape canap1 = new Canape (2, "bleu");
		appart.setCanape(canap1);
		
		Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(appart);
		System.out.println(appart);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static void testOneToOneBilateral () {
		Appartement appart = new Appartement (5, 60, "gris");
		Canape canap1 = new Canape (4, "rouge");
		appart.addCanape(canap1);
		
		Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(appart);
		System.out.println(appart);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static void testManyToOneUnilateral () {
		Territoire territoire = new Territoire ("plaine", 60);
		Animal kiki = new Animal ("kiki", "pigeon", 2);
		Animal loulou = new Animal ("loulou", "chiot", 1);
		territoire.getAnimaux().add(kiki);
		territoire.getAnimaux().add(loulou);
		
		Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(territoire);
		System.out.println(territoire);
		
		session.getTransaction().commit();
		session.close();
	}

}
