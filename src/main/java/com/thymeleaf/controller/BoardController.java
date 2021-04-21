package com.thymeleaf.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.thymeleaf.mapper.BoardMapper;
import com.thymeleaf.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper boardMapper;

	@GetMapping("/board/list")
	public String list(Model model) {
		model.addAttribute("list", boardMapper.getAll());
		model.addAttribute("tabIndex", 2);
		return "board/list";
	}

	@GetMapping("/board/add")
	public String add(Model model) {
		model.addAttribute("tabIndex", 3);
		return "board/add";
	}

	@GetMapping("/board/mod/{bno}")
	public String mod(Model model, @PathVariable("bno") Integer bno) {
		model.addAttribute("tabIndex", 4);
		return "board/mod";
	}

	@GetMapping("/board/detail/{bno}")
	public String detail(Model model, @PathVariable("bno") Integer bno) {
		model.addAttribute("vo", boardMapper.getOne(bno));
		model.addAttribute("tabIndex", 5);
		return "board/detail";
	}

//	@RequestMapping(value = "/board", method = RequestMethod.POST)
	@PostMapping("/board")
	public String addProc(BoardVO vo) {
		boardMapper.add(vo);
		return "redirect:/board/list";
	}

}