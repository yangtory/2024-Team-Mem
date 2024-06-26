package com.callor.hello.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.hello.dao.DashDao;
import com.callor.hello.service.DashService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DashServiceImpl implements DashService{
	
	private final DashDao dashDao;
	@Autowired
    public DashServiceImpl( DashDao dashDao) {
        super();
        this.dashDao = dashDao;
    }


	@Override
	public List<Map<String, Object>> getMonthlyTotal(String ccode) {
		List<Map<String, Object>> resultList = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            String month = String.format("%02d", i); // 월을 2자리 숫자로 포맷팅
            String startDate = "2024-" + month + "-01";
            String endDate = "2024-" + month + "-31";

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("ccode", ccode);
            paramMap.put("startDate", startDate);
            paramMap.put("endDate", endDate);
            
            Map<String, Object> result = dashDao.getMonthlyTotal(paramMap);
            resultList.add(result);
        }
        return resultList;
	}


	@Override
	public List<Integer> getMonthlyUser(String ccode) {

	    List<Integer> resultList = new ArrayList<>();

	    for (int i = 1; i <= 12; i++) {
	        String month = String.format("%02d", i); // 월을 2자리 숫자로 포맷팅
	        String startDate = "2024-" + month ;
	        log.debug("Start DATE{}", startDate);

	        Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("ccode", ccode);
	        paramMap.put("startDate", startDate);
	        
	        Integer result = dashDao.getMonthlyUser(paramMap); // 수정된 부분
	        resultList.add(result);
	        log.debug("resultList {} ", resultList);
	    }
	    return resultList;
	}

		

}
