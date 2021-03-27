package com.StudentManagement.FullStackApp.dao;


import java.util.List;



import com.StudentManagement.FullStackApp.entity.Courses;
import com.StudentManagement.FullStackApp.entity.Student;


public interface DatabseService {

	public List<Student> getStudentList();
	
	

	public Student insertStudent(Student s);



	public Student insertStudent(Student s, Courses c);



	public List<Student> deleteStudent(int id);
	
	public void deleteStudents(int id);



	public Student updateStudent(int id);



	public Student editStudent(Student s);
}
