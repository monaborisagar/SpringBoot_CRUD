package com.StudentManagement.FullStackApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;


/*
 * @JsonTypeName("students")
 * 
 * @JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use =
 * JsonTypeInfo.Id.NAME)
 */
@Entity
@Table(name="Student")
public class Student implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private  int id;
	
	@Column(name="first_name")
	private  String firstname;

	@Column(name="last_name")
	private  String lastname;

	 @JsonManagedReference 
	  @OneToMany(mappedBy = "student" ,cascade = CascadeType.ALL)
	  public List<Courses> course;

	
		 
		public List<Courses> getCourse() {
		return course;
	}
	public void setCourse(List<Courses> course) {
		this.course = course;
	}
			public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	/*
	 * public void addCourse(Courses c) {
	 * 
	 * if(c==null) {
	 * 
	 * Couses= new ArrayList<Courses>(); }
	 * 
	 * 
	 * this.Couses.add(c);
	 * 
	 * 
	 * }
	 */
	
	
}
