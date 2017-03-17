package com.nareshit.service;

import java.util.List;

import com.nareshit.entity.StudentEntity;

public interface StudentService {

	public void addStudent(StudentEntity studententity);
	public List<StudentEntity> listStudents();

}
