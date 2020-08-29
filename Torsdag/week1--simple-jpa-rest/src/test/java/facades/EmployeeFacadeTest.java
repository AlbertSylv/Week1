package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author baske
 */
public class EmployeeFacadeTest {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        EmployeeFacade facade = EmployeeFacade.getEmployeeFacade(emf);
     Employee e1 = new Employee("Hans Hansen", "Doven vej 3", 23525);
    Employee e2 = new Employee("Inger Hansen", "Doven vej 3", 20000);
     Employee e3 = new Employee("Hans Bentsen", "Doven vej 8", 23525);
    public EmployeeFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    

    
    
    @Before
    public void setUp() {                
        try {
            

            em.getTransaction().begin();
            em.createQuery("DELETE FROM Employee").executeUpdate();
            
            em.persist(e1);
            
            em.persist(e2);
            
            em.persist(e3);
            
            em.getTransaction().commit();
        
        } finally {
            em.close();
            emf.close();
        }
    }

    /**
     * Test of findByID method, of class EmployeeFacade.
     */
    @Test
    public void testFindByID() {
        System.out.println("findByID");
        int id = 1;
        
        Employee expResult = e1;
        Employee result = EmployeeFacade.findByID(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findByName method, of class EmployeeFacade.
     */
    @Test
    public void testFindByName() {
        System.out.println("findByName");
        String name = "";
        
        List<Employee> expResult = null;
        List<Employee> result = EmployeeFacade.findByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEmployees method, of class EmployeeFacade.
     */
    @Test
    public void testGetAllEmployees() {
        System.out.println("getAllEmployees");
        EmployeeFacade instance = null;
        List<Employee> expResult = null;
        List<Employee> result = instance.getAllEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CreateEmployee method, of class EmployeeFacade.
     */
    @Test
    public void testCreateEmployee() {
        System.out.println("CreateEmployee");
        String Name = "";
        String adress = "";
        int salary = 0;
        EmployeeFacade instance = null;
        Employee expResult = null;
        Employee result = instance.CreateEmployee(Name, adress, salary);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
