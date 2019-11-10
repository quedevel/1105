package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardMapperTests extends TimeMapperTests{
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testListSearch() {
		
		// 1 page 10 amount
		PageDTO dto = new PageDTO();
		dto.setPage(2);
		dto.setAmount(20);
		dto.setKeyword("1");
		dto.setType("T");
		List<BoardVO> list = null;
		(list = mapper.listPage(dto)).forEach(vo -> {
			log.info(vo);
		});
		
		log.info(list.size());
		
		log.info(mapper.getPage(dto));
		
	}
	
	@Test
	public void testListPage() {
		
		// 1 page 10 amount
		PageDTO dto = new PageDTO();
		dto.setPage(2);
		dto.setAmount(20);
		List<BoardVO> list = null;
		(list = mapper.listPage(dto)).forEach(vo -> {
			log.info(vo);
		});
		
		log.info(list.size());
		
		log.info(mapper.getPage(dto));
		
	}

	@Test
	public void testInsert() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("한글쓰");
		vo.setContent("한글내용쓰.");
		vo.setWriter("user00");
		
		log.info("BoardVO: "+vo);
		log.info("insert result code: "+mapper.insert(vo));
	}
}
