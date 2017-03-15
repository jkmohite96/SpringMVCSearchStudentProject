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

import com.nareshit.dto.SearchParams;
import com.nareshit.dto.SearchResults;
import com.nareshit.entity.StudentEntity;
@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<SearchResults> searchStudents(SearchParams searchParams) {
		List<SearchResults> searchResultsList = null;
		Session session = sessionFactory.openSession();
		StringBuffer sb = new StringBuffer("select studentId,name,email,mobile,course,city,state from Student ");
		if (searchParams != null) {
			boolean isFirst = true;
			if (searchParams.getStudentId() != null) {
				sb.append(" where studentId=" + searchParams.getStudentId());
				isFirst = false;
			}
			if (searchParams.getName() != null && searchParams.getName().trim().length() > 0) {
				if (isFirst) {
					sb.append(" where name like '" + searchParams.getName() + "'");
					isFirst = false;
				} else {
					sb.append(" And name like '" + searchParams.getName() + "'");
					isFirst = false;
				}
			}
			if (searchParams.getCourse() != null && searchParams.getCourse().trim().length() > 0) {
				if (isFirst) {
					sb.append(" where course like '" + searchParams.getCourse() + "'");
					isFirst = false;
				} else {
					sb.append(" And course like '" + searchParams.getCourse() + "'");
					isFirst = false;
				}
			}
			if (searchParams.getMobile() != null && searchParams.getMobile().trim().length() > 0) {
				if (isFirst) {
					sb.append(" where mobile like '" + searchParams.getMobile() + "'");
					isFirst = false;
				} else {
					sb.append(" And mobile like '" + searchParams.getMobile() + "'");
					isFirst = false;
				}
			}
			SQLQuery sqlQuery = session.createSQLQuery(sb.toString());
			sqlQuery.addScalar("studentId", StandardBasicTypes.INTEGER);
			sqlQuery.addScalar("name", StandardBasicTypes.STRING);
			sqlQuery.addScalar("email", StandardBasicTypes.STRING);
			sqlQuery.addScalar("mobile", StandardBasicTypes.STRING);
			sqlQuery.addScalar("course", StandardBasicTypes.STRING);
			sqlQuery.addScalar("city", StandardBasicTypes.STRING);
			sqlQuery.addScalar("state", StandardBasicTypes.STRING);
			sqlQuery.setResultTransformer(Transformers.aliasToBean(SearchResults.class));
			searchResultsList = sqlQuery.list();

		} // end of main-if
		return searchResultsList;
	}

	public void addStudent(StudentEntity studententity) {

	//	sessionFactory.getCurrentSession().saveOrUpdate(studententity);
		
		Session session=sessionFactory.getCurrentSession();
		   Transaction trans=session.beginTransaction();
		   session.save(studententity);
		   trans.commit();

	}

}
