  
package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;

@Repository
public interface BoardService {

	public boolean register(BoardVO vo);
	public List<BoardVO> getList(PageDTO dto);
	public int getListCount(PageDTO dto);
	public BoardVO findByBno(Integer bno);
}