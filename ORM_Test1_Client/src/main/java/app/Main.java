package app;

import java.rmi.Naming;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import entity.Assignment;
import entity.Employee;
import entity.Project;
import services.AssignmentService;
import services.EmployeeService;
import services.ProjectService;

public class Main {
	public static void main(String[] args) {
		try {
			ProjectService projectService =  (ProjectService) Naming.lookup("rmi://localhost:8989/ProjectService");
			EmployeeService employeeService = (EmployeeService) Naming.lookup("rmi://localhost:8989/EmployeeService");
			AssignmentService assignmentService =  (AssignmentService) Naming.lookup("rmi://localhost:8989/AssignmentService");
			
			Project project = projectService.finProjectById("PR_02");
			Employee employee = employeeService.findEmployeeById("EM_01");
			Assignment assignment = new Assignment(employee, project, 5);
			boolean isCreated = assignmentService.addAssignMent(assignment);
			System.out.println(isCreated);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
