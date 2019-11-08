package org.zerock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;
import org.zerock.dto.PageMaker;
import org.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;

	@GetMapping("/register")
	public void registerGET() {
		log.info("get register...................");

	}

	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo") @Valid BoardVO vo, BindingResult bind, RedirectAttributes rttr) {
		
		if(bind.hasErrors()) {
			log.info("error exists");
			return "/board/register";
		}
		
		rttr.addFlashAttribute("msg", service.register(vo) ? "SUCCESS" : "false");
		
		return "redirect:/board/list";
	}

	@GetMapping("/list")
	public void listGET(PageDTO dto, Model model) {
		log.info("get list...................");

		model.addAttribute("list", service.getList(dto));

		int total = service.getListCount(dto);

		PageMaker pg = new PageMaker(dto, total);
		model.addAttribute("pg", pg);
	}
	
	// @ModelAttribute()
	@GetMapping("/read")
	public void readGET(@ModelAttribute("dto")PageDTO dto, Model model) {
		log.info("read get.......................................");
		log.info(service.findByBno(dto.getBno()));
		model.addAttribute("board", service.findByBno(dto.getBno()));
		
	}
	
	

}