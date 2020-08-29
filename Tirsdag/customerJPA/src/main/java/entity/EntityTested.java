/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author baske
 */
public class EntityTested {
    public static void main(String[] args) {
               EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
EntityManager em = emf.createEntityManager();
Customer customer1 = new Customer("jens","jensen",new Date());
Customer customer2 = new Customer("bent","bentsen", new Date());
try {
      em.getTransaction().begin();
      em.persist(customer1);
      em.persist(customer2);
      em.getTransaction().commit();
      //Verify that books are managed and has been given a database id
      System.out.println(customer1.getId());
      System.out.println(customer2.getId());
       	 
    	}finally{
        	em.close();
    	}
}
 
    
    
    
}
