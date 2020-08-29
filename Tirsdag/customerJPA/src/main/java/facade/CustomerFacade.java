/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author baske
 */
public class CustomerFacade {
     private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        Customer c1 = facade.addCustomer("Hans", "Hansen", new Date());
        Customer c2 = facade.addCustomer("Herman", "Hermansen", new Date());
        Customer c3 = facade.addCustomer("Jens", "Hermansen", new Date());
        //Find customer by ID
        System.out.println("Customer found by id: " + facade.findByID(c1.getId()).getFirstName() + " " + facade.findByID(c1.getId()).getLastName());
        //Find customer by last name
        System.out.println("Customer / customers found by last name: " + facade.findByLastName(c2.getLastName()).toString());
        //Find number of customers
        System.out.println("Number of customers: " + facade.getNumberOfCustomers());
        //all customers
        System.out.println("All customers: " + facade.getAllCustomers().toString());

    }

    /**
     * Here is a no argument constructor
     */
    private CustomerFacade() {
    }

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }


    public Customer addCustomer(String fName,String lName, Date date) {
        Customer customer = new Customer(fName, lName, new Date());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } finally {
            em.close();
        }
    }



        public List<Customer> findByLastName(String lastname) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select customer from Customer customer where customer.lastName = :lastname", Customer.class);
            return query.setParameter("lastname", lastname).getResultList();
        } finally {
            em.close();
        }
    } 
    
        public Customer findByID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }
    }
        public long getNumberOfCustomers(){
        EntityManager em = emf.createEntityManager();
        
        try{
         Query q1 = em.createQuery("SELECT COUNT(c) FROM Customer c");
        return (long) q1.getSingleResult();   
        } finally {
            em.close();
        }
        
        
        
        }

    /**
     * This method returns all customers from the DB
     */
    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("Select customer from Customer customer", Customer.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    } 
    
}
