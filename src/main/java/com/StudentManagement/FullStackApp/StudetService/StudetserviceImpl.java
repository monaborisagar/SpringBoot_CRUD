package com.StudentManagement.FullStackApp.StudetService;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.FullStackApp.dao.DatabseService;
import com.StudentManagement.FullStackApp.entity.Courses;
import com.StudentManagement.FullStackApp.entity.Student;

@Service
public class StudetserviceImpl implements StudentDetail {

	
	private DatabseService databaseService;
	
	@Autowired
	public StudetserviceImpl(DatabseService databaseService) {
		this.databaseService = databaseService;
	}


	@Override
	@Transactional 
	public List<Student> getStudentList() {
		
			return databaseService.getStudentList();		
	}


	@Override
	@Transactional 
	public Student insertStudent(Student s) {
		// TODO Auto-generated method stub
		
		
		return databaseService.insertStudent(s);
	}


	@Override
	@Transactional 
	public Student insertStudentadd(Student s, Courses c) {
		// TODO Auto-generated method stub
		return databaseService.insertStudent(s,c);
	}
	@Transactional 
	public List<Student> deleteStudent(int id) {
		
		
		
		return databaseService.deleteStudent(id);
		
	}

	
	public void deleteStudents(int id) {
		
		databaseService.deleteStudents(id);
		
	}


	@Override
	@Transactional 
	public Student updateStudent(int id) {
		// TODO Auto-generated method stub
		return databaseService.updateStudent(id);
	}


	@Override
	@Transactional 
	public Student editStudent(Student s) {
		// TODO Auto-generated method stub
		return databaseService.editStudent(s);
	}

}
