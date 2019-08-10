package com.example.demo.domain.service;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Line;
import com.example.demo.domain.entity.Test;
import com.example.demo.domain.mapper.LineMapper;
import com.example.demo.domain.mapper.TestMapper;

@Service
public class MultiLineService {

	@Autowired
	TestMapper testMapper;

	@Autowired
	LineMapper lineMapper;

	public Page<Test> getTestAll(Pageable pageable) {
		long total = testMapper.count();
		List<Test> test;
		if (0 < total) {
			RowBounds rowBounds = new RowBounds((int) pageable.getOffset(), pageable.getPageSize());
			test = testMapper.getTestAll(rowBounds);
		} else {
			test = Collections.emptyList();
		}
		return new PageImpl<>(test, pageable, total);
	}

	public List<Line> getLineAllList() {
		return lineMapper.getLineAll();
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