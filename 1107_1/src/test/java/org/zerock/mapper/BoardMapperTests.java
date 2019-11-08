package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	BoardMapper mapper;
	
	@Test
	public void insertTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("한글");
		vo.setContent("한글쓰");
		vo.setWriter("user...");
		
		
		log.info(mapper);
		log.info(mapper.insert(vo));
		
		
	}
}
