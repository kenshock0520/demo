package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.entity.Line;
import com.example.demo.domain.entity.Test;
import com.example.demo.domain.service.MembersService;
import com.example.demo.domain.service.MultiLineService;
import com.example.demo.domain.service.TestService;

@Controller
@RequestMapping("/multiLine")
public class MultiLineController {

	@Autowired
	MembersService membersService;

	@Autowired
	TestService testService;

	@Autowired
	MultiLineService multiLineService;

	@ModelAttribute
	public MultiLineForm setup() {
		return new MultiLineForm();
	}

	@RequestMapping(value = "/testList", method = RequestMethod.GET)
	public String mybatis(Model model, @PageableDefault(page = 0, value = 2) Pageable pageable) {
		System.out.println("aaadfd" + pageable);
		Page<Test> tests = testService.getTestAll(pageable);
		model.addAttribute("msg", "list");
		model.addAttribute("page", tests);
		model.addAttribute("url", "/test/testList");

		return "multiLine/testList";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String findById(@RequestParam("id") String id, Model model, MultiLineForm testForm) {
		System.out.println("id:" + id);
		List<Line> lineList = multiLineService.getLineAllList();
		System.out.println("line:" + lineList);
		testForm.setMode("0");
		model.addAttribute("list", lineList);
		return "multiLine/testDetail";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model, MultiLineForm testForm) {
		@SuppressWarnings("serial")
		List<Line> lineList = new ArrayList<Line>() {
			{
				add(new Line());
			}
		};
		System.out.println("line:" + lineList);
		testForm.setMode("0");
		model.addAttribute("list", lineList);
		testForm.setMode("1");
		return "multiLine/testDetail";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Model model, @Validated MultiLineForm testForm, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("エラーあります");
			return "multiLine/testDetail";
		}

		System.out.println("result:" + testForm.getLineFormList());
//		if ("1".equals(testForm.getMode())) {
//			testService.insert(testForm.getId(), testForm.getProducts());
//		} else {
//			testService.update(testForm.getId(), testForm.getProducts());
//		}

		return "redirect:testList";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") String id, Model model) {
		System.out.println("id:" + id);

		testService.deleteById(Integer.valueOf(id));

		return "redirect:testList";
	}

	@RequestMapping(value = "/deleteAll", method = RequestMethod.GET)
	public String callTestProcedure(Model model) {
		testService.callTestProcedure();
		return "redirect:testList";
	}

}
