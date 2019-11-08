package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = { @Autowired })
	BoardMapper mapper;
	
	@Override
	public void register(BoardVO vo) {
		log.info(mapper);
		log.info("..........................");
		
		mapper.insert(vo);
	}

}
