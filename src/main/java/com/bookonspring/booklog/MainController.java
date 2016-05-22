package com.bookonspring.booklog;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String viewMain(Model model) {
		model.addAttribute("title", "On Spring Blog");
		model.addAttribute("message", "Hello, World!");
		model.addAttribute("date", new Date());
		return "main";
	}
}
