package com.nareshit.dao;

import java.util.List;

import com.nareshit.entity.StudentEntity;

public interface StudentDAO {
	
	public void addStudent(StudentEntity studententity);

	public List<StudentEntity> listStudents();


}
