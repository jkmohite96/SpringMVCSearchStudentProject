package com.nareshit.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.entity.StudentEntity;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addStudent(StudentEntity studententity) {
		Session session=sessionFactory.getCurrentSession();
		   Transaction trans=session.beginTransaction();
		   session.save(studententity);
		   trans.commit();
	}


	public List<StudentEntity> listStudents() {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction trans=session.beginTransaction();
		List<StudentEntity> studentsList = session.createQuery("from StudentEntity").list();
		trans.commit();
		return studentsList;
	}

}
