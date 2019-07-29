package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.entity.Members;
import com.example.demo.domain.entity.Test;
import com.example.demo.domain.service.MembersService;
import com.example.demo.domain.service.TestService;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	MembersService membersService;

	@Autowired
	TestService testService;

	@ModelAttribute
	public TestForm setup() {
		return new TestForm();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String test(Model model) {
		Members members = membersService.getMemersById(1);
		model.addAttribute("msg", "サンプルメッセージ！");
		model.addAttribute(members);

		return "/index";
	}

	@RequestMapping(value = "test/testList", method = RequestMethod.GET)
	public String mybatis(Model model, @PageableDefault(page = 0, value = 2) Pageable pageable) {
		System.out.println("aaadfd" + pageable);
		Page<Test> tests = testService.getTestAll(pageable);
		model.addAttribute("msg", "list");
		model.addAttribute("page", tests);
		model.addAttribute("url", "/test/testList");

		return "test/testList";
	}

	@RequestMapping(value = "test/paging", method = RequestMethod.GET)
	public String mybatis(@RequestParam("page") String page, Model model,
			@PageableDefault(page = 0, value = 2) Pageable pageable) {
		System.out.println("aaadfd" + pageable);
		Page<Test> tests = testService.getTestAll(pageable);
		model.addAttribute("msg", "list");
		model.addAttribute("page", tests);
		model.addAttribute("url", "/test/testList");

		return "test/testList";
	}

	@RequestMapping(value = "test/detail", method = RequestMethod.GET)
	public String findById(@RequestParam("id") String id, Model model, TestForm testForm) {
		System.out.println("id:" + id);
		Test test = testService.getTestById(Integer.valueOf(id));
		testForm.setId(test.getId());
		testForm.setProducts(test.getProducts());
		testForm.setMode("2");
		model.addAttribute("msg", "list");
		return "test/testDetail";
	}

	@RequestMapping(value = "test/create", method = RequestMethod.GET)
	public String create(Model model, TestForm testForm) {
		testForm.setMode("1");
		return "test/testDetail";
	}

	@RequestMapping(value = "test/update", method = RequestMethod.POST)
	public String update(Model model, TestForm testForm) {
		System.out.println("id:" + testForm.getId());
		System.out.println("products:" + testForm.getProducts());
		System.out.println("mode:" + testForm.getMode());
		if ("1".equals(testForm.getMode())) {
			testService.insert(testForm.getId(), testForm.getProducts());
		} else {
			testService.update(testForm.getId(), testForm.getProducts());
		}

		return "redirect:testList";
	}

	@RequestMapping(value = "test/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") String id, Model model) {
		System.out.println("id:" + id);

		testService.deleteById(Integer.valueOf(id));

		return "redirect:testList";
	}

	@RequestMapping(value = "test/deleteAll", method = RequestMethod.GET)
	public String callTestProcedure(Model model) {
		testService.callTestProcedure();
		return "redirect:testList";
	}

}
