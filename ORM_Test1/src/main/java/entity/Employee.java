package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "emp_id", columnDefinition = "varchar(20)")
	private String id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "hire_date", nullable = false)
	private Date hireDate;

	@Column(name = "full_name", nullable = false, columnDefinition = "nvarchar(100)")
	private String name;

	// Tạo ra một bản riêng
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "phones", joinColumns = @JoinColumn(name = "emp_id"))
	@Column(name = "phone", nullable = false)
	private Set<String> phones;

	// Mappy chính nó
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;
	
	@OneToMany(mappedBy = "employee")
	private List<Assignment> assignments;

	public Employee(String id, String email, Date hireDate, String name, Set<String> phones, Employee manager) {
		super();
		this.id = id;
		this.email = email;
		this.hireDate = hireDate;
		this.name = name;
		this.phones = phones;
		this.manager = manager;
	}

	public Employee() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", hireDate=" + hireDate + ", name=" + name  + ", manager=" + manager + "]";
	}

}
