package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@Controller("/board/*")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/register")
	public String getRegister() {
		return "/board/register";
	}
	
	@PostMapping("/register")
	public String postRegister(BoardVO vo) {
		service.register(vo);
		return "redirect:/board/list";
	}
}

