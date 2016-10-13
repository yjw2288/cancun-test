package com.cancun.web;

import com.cancun.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

	@Value("${team.name}")
	private String teamName;

	@Autowired
	private ArticleRepository articleRepository;

	private static final int RANDOM = (int) (Math.random() * 100);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "/ok", method = RequestMethod.GET)
	public String ok() {
		return teamName;
	}

	@ResponseBody
	@RequestMapping(value = "/random", method = RequestMethod.GET)
	public String random() {
		return "random : " + RANDOM;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
}
