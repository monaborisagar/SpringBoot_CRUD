package com.StudentManagement.FullStackApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagement.FullStackApp.StudetService.StudentDetail;
import com.StudentManagement.FullStackApp.entity.Courses;
import com.StudentManagement.FullStackApp.entity.Student;


@RestController
//@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:8083/")
public class WebRestcontroller {

	private StudentDetail studentDetail;
	
	@Autowired
	public WebRestcontroller(StudentDetail studentDetail) {
		this.studentDetail = studentDetail;
	}

	//@GetMapping("/hello")
	@RequestMapping("/")
	public String   hello() {
	return  "hello";
	
	}
	
	
	
	@ResponseBody
	@GetMapping("/list")
	public List<Student> getStudentList() {
	return  studentDetail.getStudentList();
	
	}
	
	@PostMapping("/add")
	public Student insert(@RequestBody Student s) {
		
		s.setId(0);
		System.out.println("=============="+s.toString());
		
		
		return studentDetail.insertStudent(s);
	}
	
	
	/*
	 * @DeleteMapping("/remove/{id}") public List<Student> delete(@PathVariable int
	 * id) {
	 * 
	 * //s.setId(0);
	 * 
	 * System.out.println("id======"+id);
	 * 
	 * return studentDetail.deleteStudent(id); }
	 */
	
	

	@DeleteMapping("/removes/{id}")
	public void deletes(@PathVariable int id) {
		
		//s.setId(0);
		
		System.out.println("id======"+id);
		
		studentDetail.deleteStudents(id);
	}
	
	@GetMapping("/update/{id}")
	public Student Update(@PathVariable int id) {
		
		
		
		return  studentDetail.updateStudent(id);
	}
	
	
	@PutMapping("/edit/{id}")
	public Student edit(@RequestBody Student s,@PathVariable int id) {
	
		System.out.println("id====>"+s.getId());
		
		
		return  studentDetail.editStudent(s);
	}
	
	
	
	
}

