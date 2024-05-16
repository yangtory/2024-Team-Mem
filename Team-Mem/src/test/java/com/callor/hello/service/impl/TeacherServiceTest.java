package com.callor.hello.service.impl;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*-mapper.xml")
public class TeacherServiceTest {


	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateTCode() {
		String tCode = "T0001";
			String prefix = tCode.substring(0,1);
			tCode = tCode.substring(1);
			tCode = String.format("%s%04d", prefix, Integer.valueOf(tCode)+1);
		
		return;
	}

}
