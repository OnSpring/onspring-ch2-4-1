package com.bookonspring.booklog;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post") // ①
public class PostController {
	@Autowired // ②
	private PostDao postDao;

	@GetMapping(value = "/write") // ③
	public String form(Post post) {
		return "form";
	}

	@PostMapping(value = "/write") // ④
	public String write(Post post) {
		post.setCreatedAt(new Date()); // ⑤
		return "redirect:/post/" + postDao.save(post).getId(); // ⑥
	}

	@RequestMapping("/{id}")
	public String view(Model model, @PathVariable int id) {
		Post post = postDao.findOne(id); // ⑦
		model.addAttribute("post", post);
		return "post";
	}
}
