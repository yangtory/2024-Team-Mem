package com.callor.hello.dao;

import java.util.Map;


public interface DashDao {

	Map<String, Object> getMonthlyTotal(Map<String, Object> paramMap);
	Integer getMonthlyUser(Map<String, Object> paramMap);
	
}
