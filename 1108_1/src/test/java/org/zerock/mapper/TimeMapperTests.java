package org.zerock.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.loading.LoadingTests;

import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests extends LoadingTests {
	
	@Autowired
	TimeMapper mapper;
	
	@Test
	public void testTime() {
		log.info("getTime  =                    "+mapper.getTime());
		log.info("getTime2 =                    "+mapper.getTime2());
	}

	
}
