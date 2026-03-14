package com.klu.hibernate_CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory sf = md.getSessionFactoryBuilder().build();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
      //Insert
//        Employee e1=new Employee();
//        e1.setId(1);
//        e1.setName("Srithar");
//        s.save(e1);
//        
//        Employee e2=new Employee();
//        e2.setId(2);
//        e2.setName("Kannan");
//        s.save(e2);
        //update:-
//        Employee e = new Employee();
//        e.setId(1);
//        e.setName("Thaswin");
//        s.update(e);
//        
//        Employee e=new Employee();
//        e.setId(2);
//        s.delete(e);
//        		
     
        List<Employee> list=s.createQuery("from Employee", Employee.class).list();
        for (Employee e : list) {
        	System.out.println(e.getId()+" "+e.getName());
        }
        System.out.println("Display success");
        
        t.commit();
        s.close();
        
        System.out.println("Insert Success");
        
    }
}
