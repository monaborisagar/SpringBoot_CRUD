package com.StudentManagement.FullStackApp.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;


@Entity
@Table(name="course")
public class Courses implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="course_id")
		private int id;
		
		@Column(name="course_name")
		private String courseName;
		
		@JsonBackReference
		@ManyToOne(cascade=  CascadeType.ALL)
		@JoinColumn(name="fk_user_id")
		private Student student;
		
		
		public Courses() {
		}
		public Student getStudent() {
			return student;
		}
		public void setStudent(Student student) {
			this.student = student;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			
			this.courseName = courseName;
		}

	
}
