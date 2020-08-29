/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Employee;
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
public class EmployeeFacade {

    private static EntityManagerFactory emf;
    private static EmployeeFacade instance;
    
 /*   public static void main(String[] args) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        EmployeeFacade facade = EmployeeFacade.getEmployeeFacade(emf);
        try {
           

            em.getTransaction().begin();
             em.createQuery("DELETE FROM Employee").executeUpdate();
            Employee e1 = new Employee("Hans Hansen", "Doven vej 3", 23525);
            em.persist(e1);
            Employee e2 = new Employee("Inger Hansen", "Doven vej 3", 20000);
            em.persist(e2);
            Employee e3 = new Employee("Hans Bentsen", "Doven vej 8", 23525);
            em.persist(e3);
            
            em.getTransaction().commit();
            
            System.out.println("find med id " + findByID(1));
            System.out.println("find med navn " + EmployeeFacade.findByName("Hans Hansen"));
            System.out.println("alle medarbejdere " + EmployeeFacade.getAllEmployees());
            Employee anders = EmployeeFacade.CreateEmployee("anders", "kovej", 1783);
            System.out.println("Anders er født: " + anders.toString());
        
        } finally {
            em.close();
            emf.close();
        }
    }
*/
    private EmployeeFacade() {
    }

    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    public static Employee findByID(int id) {
        
        EntityManager em;
        em = emf.createEntityManager();
        String hej = "Hej";
        System.out.println(hej);
        try {
            Employee employee = em.find(Employee.class, id);
            return employee;
        } finally {
            em.close();
        }
    }

    //Her returnerer jeg en liste fordi at det kunne ske at der er to personer der hedder Sebastian Hansen for eksempel
    public static List<Employee> findByName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query
                    = em.createQuery("Select e from Employee e where e.Name = :name", Employee.class);
            return query.setParameter("name", name).getResultList();
        } finally {
            em.close();
        }
    }

    public static List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> query
                    = em.createQuery("Select e from Employee e", Employee.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public static Employee CreateEmployee(String Name, String adress, int salary) {
        Employee employee = new Employee(Name, adress, salary);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        } finally {
            em.close();
        }
    }

    private static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}

