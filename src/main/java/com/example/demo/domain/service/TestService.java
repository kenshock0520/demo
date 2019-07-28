package com.example.demo.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Test;
import com.example.demo.domain.mapper.TestMapper;

@Service
public class TestService {

	@Autowired
	TestMapper testMapper;

	public List<Test> getTestAll() {
		return testMapper.getTestAll();
	}

	public Test getTestById(int id) {
		return testMapper.select(id);
	}

	public void deleteById(int id) {
		testMapper.delete(id);
	}

	public void update(int id, String products) {
		Test test = new Test();
		test.setId(id);
		test.setProducts(products);
		testMapper.update(test);
	}

	public void insert(int id, String products) {
		Test test = new Test();
		test.setId(id);
		test.setProducts(products);
		testMapper.insert(test);
	}

	public void callTestProcedure() {
		testMapper.callTestProcedure();
	}
}