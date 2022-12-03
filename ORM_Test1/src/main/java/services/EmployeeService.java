package services;

import java.rmi.Remote;
import java.util.List;

import entity.Employee;

public interface EmployeeService extends Remote{
	public boolean addEmployee(Employee employee) throws Exception;
	public boolean updateEmployee(Employee employee) throws Exception;
	public List<Employee> getEmployees() throws Exception;
	public Employee findEmployeeById(String id) throws Exception;
}
