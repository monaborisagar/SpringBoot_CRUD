package com.StudentManagement.FullStackApp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.StudentManagement.FullStackApp.dao.DatabaseRepo;
import com.StudentManagement.FullStackApp.dao.DatabseService;
import com.StudentManagement.FullStackApp.entity.Courses;
import com.StudentManagement.FullStackApp.entity.Student;

import antlr.collections.impl.LList;

@SpringBootTest
class FullStackAppApplicationTests {
	/*
	 * @Autowired DatabseService dd;
	 */
	
	@Autowired
	EntityManager entity;
	
	@Test
	void contextLoads() {
		Student aa = new Student();
		aa.setFirstname("mona");
		aa.setLastname("bor");
		List<Courses> list1 = new ArrayList<Courses>();
		Courses cr = new Courses();
		
		cr.setCourseName("java");
		cr.setStudent(aa);
	   list1.add(cr);
		/*
		 * Courses cr1 = new Courses(); cr1.setId(1); cr1.setCourseName("angular");
		 * cr1.setStudent(aa); list1.add(1, cr1);
		 */
	
		aa.setCourse(list1);
		
		//dd.insertStudent(aa);
		DatabseService dd = new  DatabaseRepo();
		dd.insertStudent(aa);
		
	}

}
