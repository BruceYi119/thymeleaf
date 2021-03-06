package com.thymeleaf.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thymeleaf.component.Paging;
import com.thymeleaf.mapper.BoardMapper;
import com.thymeleaf.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper boardMapper;
	@Autowired
	private Paging paging;

	@GetMapping({ "/board/list", "/board/list/{pageParam}" })
	public String list(Model model, @PathVariable("pageParam") Optional<Integer> pageParam) {
		Integer page = pageParam.isPresent() ? pageParam.get() : 1;
		paging.setRest(true);
		paging.setPaging(page, boardMapper.getTotal(), "/board/list/");
		model.addAttribute("num", paging.getStartRow());
		model.addAttribute("list", boardMapper.getAll(paging.getStartRow(), paging.getViewCnt()));
		model.addAttribute("paging", paging.getPageHtml());
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
		model.addAttribute("vo", boardMapper.getOne(bno));
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

	@PutMapping("/board")
	public String modProc(BoardVO vo) {
		boardMapper.mod(vo);
		return "redirect:/board/detail/" + vo.getBno();
	}

	@DeleteMapping("/board")
	@ResponseBody
	public String del(@PathParam("bno") Integer bno) {
		if (boardMapper.del(bno) == 1)
			return "succ";
		else
			return "fail";
	}

}