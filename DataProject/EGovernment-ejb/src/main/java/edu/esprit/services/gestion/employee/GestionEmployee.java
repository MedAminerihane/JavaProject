package edu.esprit.services.gestion.employee;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Employee;

/**
 * Session Bean implementation class GestionEmployee
 */
@Stateless
public class GestionEmployee implements GestionEmployeeRemote, GestionEmployeeLocal {

@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public GestionEmployee() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Boolean addEmployee(Employee employee) {
		try {
			entityManager.persist(employee);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteEmployee(Employee employee) {
		try {
			entityManager.remove(entityManager.merge(employee));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		try {
			entityManager.merge(employee);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Employee findEmployeeByCin(String cin) {
		Employee employee=null;
		try {
			Query queryEmployeeByCin = entityManager.createQuery(
				    "SELECT OBJECT(e) FROM Employee e WHERE e.cin = :cin"
				);
			queryEmployeeByCin.setParameter("cin", cin);
			employee = (Employee) queryEmployeeByCin.getSingleResult();
			return employee; 
		} catch (Exception e) {
		}
		return employee;

	}

	@Override
	public List<Employee> findAllEmployee() {
		Query query=entityManager.createQuery("select e from Employee e");
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public Employee authentificate(String login, String pwd) {
		Employee employee=null;
		Query query = entityManager.createQuery("select e from Employee e where e.login=:l and e.password=:p");
		System.out.println(login+" "+pwd);
		query.setParameter("l", login).setParameter("p", pwd);
		try {
			employee = (Employee) query.getSingleResult();
		} catch (Exception e) {
			employee = null;
		}
		return employee;
	}

	@Override
	public Employee FindAllEmployeeById(int id) {
		Employee employee=null;
		Query query = entityManager.createQuery("select e from Employee e where e.idEmployee=:id ");
		query.setParameter("id", id);
		try {
			employee = (Employee) query.getSingleResult();
		} catch (Exception e) {
			employee = null;
		}
		return employee;
	}
    
}
