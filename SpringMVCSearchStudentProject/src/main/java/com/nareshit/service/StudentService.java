package com.nareshit.service;

import java.util.List;

import com.nareshit.dto.SearchParams;
import com.nareshit.dto.SearchResults;
import com.nareshit.entity.StudentEntity;

public interface StudentService {

	public List<SearchResults> searchStudents(SearchParams searchParams);
	public void addStudent(StudentEntity studententity);
}
