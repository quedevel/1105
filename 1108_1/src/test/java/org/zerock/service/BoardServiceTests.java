package org.zerock.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.TimeMapperTests;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardServiceTests extends TimeMapperTests {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);
		log.info(service);
	}
	
	@Test
	public void testRegister() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("�ѱ��׽�Ʈ��");
		vo.setContent("�ѱ��� �׽�Ʈ�մϴ�.");
		vo.setWriter("�׽���");
		
		boolean result = service.register(vo);
		
		assertTrue(result);
	}
}
