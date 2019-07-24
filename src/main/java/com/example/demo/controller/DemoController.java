package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.domain.entity.Members;
import com.example.demo.domain.service.MembersService;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	MembersService membersService;

	@RequestMapping(method = RequestMethod.GET)
	public String test(Model model) {
		Members members = membersService.getMemersById(1);
		model.addAttribute("msg", "サンプルメッセージ！");
		model.addAttribute(members);

		return "/index";
	}
}
