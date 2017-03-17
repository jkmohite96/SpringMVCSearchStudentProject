package com.nareshit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.dao.StudentDAO;
import com.nareshit.entity.StudentEntity;

@Service("studentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO studentDao;

	public void addStudent(StudentEntity studententity) {
		studentDao.addStudent(studententity);
	}

	public List<StudentEntity> listStudents() {
		return this.studentDao.listStudents();
	}

}
