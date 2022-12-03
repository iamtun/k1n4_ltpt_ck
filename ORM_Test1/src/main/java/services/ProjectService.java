package services;

import java.rmi.Remote;

import entity.Project;

public interface ProjectService extends Remote {
	public boolean addProject(Project project) throws Exception;

	public Project finProjectById(String id) throws Exception;

	public Project findProjectByName(String name) throws Exception;

	public boolean upateProject(Project project) throws Exception;

	public boolean deleteProject(String id) throws Exception;
}
