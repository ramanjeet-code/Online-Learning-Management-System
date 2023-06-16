package Entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;
@Entity
@Table(name = "students")
public class Student {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(name = "name", nullable = false)
	    private String name;

	    @Column(name = "email", nullable = false, unique = true)
	    private String email;

	    @Column(name = "password", nullable = false)
	    private String password;
	    
	    @Column(name = "date_of_birth")
	    private LocalDate dateOfBirth;
	    @Column(name = "address")
	    private String address;
	    @Column(name = "contact_number")
	    private String contactNumber;
	    @Column(name = "enrollment_date")
	    private Date enrollmentDate;
	     @Column(name = "is_active")
	    private boolean isActive;
	public Student(String name, String email, String password, LocalDate dateOfBirth, String address,
				String contactNumber, Date enrollmentDate, boolean isActive) {
			this.name = name;
			this.email = email;
			this.password = password;
			this.dateOfBirth = dateOfBirth;
			this.address = address;
			this.contactNumber = contactNumber;
			this.enrollmentDate = enrollmentDate;
			this.isActive = isActive;
		}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", dateOfBirth="
				+ dateOfBirth + ", address=" + address + ", contactNumber=" + contactNumber + ", enrollmentDate="
				+ enrollmentDate + ", isActive=" + isActive + "]";
	}

}
