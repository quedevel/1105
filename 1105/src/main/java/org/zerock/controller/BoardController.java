package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	
	private BoardMapper boardMapper;
	
	@GetMapping("/register")
	public void registerGET(){}
	
//    @PostMapping("/register")
//    public String registerPOST(BoardVO vo){
//        boardMapper.insert(vo);
//        return "redirect:list";
//    }
	
	@GetMapping("/list")
	public void list(
//			@RequestParam(defaultValue = "1") int page,
//			@RequestParam(defaultValue = "10") int amount,
//			String keyword,
//			String[] types,
			@ModelAttribute("dto")PageDTO dto,
			Model model
			) {
		
		// @ModelAttribute 은 파라미터에 사용하고 전달받은 데이터를 다시 전달 해줄때 사용한다.
		log.info("dto =      "+dto);
		
		
//		List<BoardVO> list = boardMapper.selectList((page-1)*10, amount);
//		model.addAttribute("list", list);
//		log.info(list);
		
		List<BoardVO> list = boardMapper.searchList(dto);
		model.addAttribute("list", list);
		log.info(list);
	}
	
}
