 package com.StudentManagement.FullStackApp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentManagement.FullStackApp.entity.Courses;
import com.StudentManagement.FullStackApp.entity.Student;

@Repository
public class DatabaseRepo implements DatabseService {

	@Autowired
	EntityManager entity;

	
	@Override
	public List<Student> getStudentList() {
		Session s = entity.unwrap(Session.class);

		Query<Student> theQuery = s.createQuery("from Student");

		List<Student> studentlist = theQuery.getResultList();
				
		return studentlist;
	}

	@Override
	public Student insertStudent(Student s) {
		// TODO Auto-generated method stub
		
		
		  Session session =entity.unwrap(Session.class);
		  
		  session.save(s);
		
		return s;
	}

	@Override
	public Student insertStudent(Student s, Courses c) {
		// TODO Auto-generated method stub

		Session session = entity.unwrap(Session.class);

		//s.addCourse(c);

		session.save(s);

		return s;
	}

	@Override
	public List<Student> deleteStudent(int id) {
		Session session = entity.unwrap(Session.class);
		/*
		 * Student s =new Student(); s.setId(id);
		 * 
		 * session.delete(s);
		 * 
		 */// TODO Auto-generated method stub
		
		Query theQuery= session.createQuery("delete from Student where id=:empid");
		
		theQuery.setParameter("empid",id);
		
		
		theQuery.executeUpdate();
		return this.getStudentList();
	}
	
	@Transactional
	public void deleteStudents(int id) {
		
		/*
		 * System.out.println("deleteStudents===>"); Session session =
		 * entity.unwrap(Session.class);
		 * 
		 * System.out.println("deleteStudents===>1");
		 * 
		 * Integer in = new Integer(id);
		 * 
		 * Query<Student> query
		 * =session.createQuery("delete from Student where id=:empid"); Query query =
		 * session.createQuery("delete Student where id =:ID");
		 * System.out.println("query===========================>");
		 * query.setParameter("ID", in);
		 * 
		 * System.out.println("deleteStudents===>query"+query);
		 * 
		 * int result = query.executeUpdate();
		 * 
		 * System.out.println("result===>"+result); query.executeUpdate();
		 */
		//Session session =entity.unwrap(Session.class);
//		Student s=new Student();
//		s.setId((Integer)id);
//		entity.remove(s);
//	
		
		Session currentSession = entity.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Student where id=:employeeId");
		theQuery.setParameter("employeeId", id);
		
		theQuery.executeUpdate();
		
	
	
	/*
	 * session.delete(s); System.out.println("student 2 is deleted");
	 */
		
	}

	@Override
	public Student updateStudent(int id) {
		// TODO Auto-generated method stub
			Session currentSession = entity.unwrap(Session.class);
		Student s= currentSession.get(Student.class, id);
		
		return s;
	}

	@Override
	public Student editStudent(Student s) {
		// TODO Auto-generated method stub
		
		Session session = entity.unwrap(Session.class);
		//Session session =sessionFactory.getCurrentSession();
		

		 session.update(s);
		
		
		return s;
		
		
	}
	

}
