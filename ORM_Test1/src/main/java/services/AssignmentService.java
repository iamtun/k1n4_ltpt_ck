package services;

import java.rmi.Remote;

import entity.Assignment;

public interface AssignmentService extends Remote{
	public boolean addAssignMent(Assignment assignment) throws Exception;
}
