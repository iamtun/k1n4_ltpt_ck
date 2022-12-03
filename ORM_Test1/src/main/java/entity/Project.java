package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Project implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "prj_id", columnDefinition = "varchar(20)")
	private String id;
	
	private double budget;

	@Column(columnDefinition = "nvarchar(100)")
	private String location;

	@Column(name = "project_name", columnDefinition = "nvarchar(100)", nullable = false)
	private String name;

	@Column(name = "start_date")
	private Date startDate;
	
	@OneToMany(mappedBy = "project")
	private List<Assignment> assignments;

	public Project(String id, double budget, String location, String name, Date startDate) {
		super();
		this.id = id;
		this.budget = budget;
		this.location = location;
		this.name = name;
		this.startDate = startDate;
	}

	public Project() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", budget=" + budget + ", location=" + location + ", name=" + name + ", startDate="
				+ startDate + "]";
	}

}
