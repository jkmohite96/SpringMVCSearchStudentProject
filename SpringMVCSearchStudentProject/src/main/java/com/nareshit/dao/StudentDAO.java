package com.nareshit.dao;

import java.util.List;

import com.nareshit.dto.SearchParams;
import com.nareshit.dto.SearchResults;
import com.nareshit.entity.StudentEntity;

public interface StudentDAO {
	
	public void addStudent(StudentEntity studententity);

	List<SearchResults> searchStudents(SearchParams searchParams);


}
