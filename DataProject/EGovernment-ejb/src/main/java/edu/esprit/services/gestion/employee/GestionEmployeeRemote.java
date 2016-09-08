package edu.esprit.services.gestion.employee;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.Employee;

@Remote
public interface GestionEmployeeRemote {
	
	Boolean addEmployee(Employee employee);
	Boolean deleteEmployee(Employee employee);
	Boolean updateEmployee(Employee employee);
	Employee findEmployeeByCin(String cin);
	List<Employee> findAllEmployee();
	Employee authentificate(String login,String pwd);
	Employee FindAllEmployeeById(int id);
	
}
