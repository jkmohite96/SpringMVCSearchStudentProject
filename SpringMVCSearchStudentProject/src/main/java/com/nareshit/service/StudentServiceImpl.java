package com.nareshit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.dao.StudentDAO;
import com.nareshit.dto.SearchParams;
import com.nareshit.dto.SearchResults;
import com.nareshit.entity.StudentEntity;
@Service("studentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentServiceImpl implements StudentService {
    @Autowired
	private StudentDAO studentDao;
	
	public List<SearchResults> searchStudents(SearchParams searchParams) {
		  List<SearchResults> list= studentDao.searchStudents(searchParams);
		return list;
		
	}

	public void addStudent() {
		//employeeDao.addEmployee(employee);
	}

	public void addStudent(StudentEntity studententity) {
		// TODO Auto-generated method stub
		studentDao.addStudent(studententity);
		
	}

}
