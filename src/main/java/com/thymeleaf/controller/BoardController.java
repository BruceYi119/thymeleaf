package com.thymeleaf.controller;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

	@GetMapping("/board/list")
	public String list(Model model) {
		model.addAttribute("tabIndex", 2);
		return "board/list";
	}

	@GetMapping("/board/add")
	public String add(Model model) {
		model.addAttribute("tabIndex", 3);
		return "board/add";
	}

	@GetMapping("/board/mod")
	public String mod(Model model) {
		model.addAttribute("tabIndex", 4);
		return "board/mod";
	}

	@GetMapping("/board/detail")
	public String detail(Model model) {
		model.addAttribute("tabIndex", 5);
		return "board/detail";
	}

//	@RequestMapping(value = "/board", method = RequestMethod.POST)
	@PostMapping("/board")
	public void addProc(PrintWriter out) {
		out.print("addProc");
	}

}