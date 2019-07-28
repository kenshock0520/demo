package com.example.demo.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.entity.Test;

@Mapper
public interface TestMapper {
	void insert(Test test);

	@Select("select * from test")
	List<Test> getTestAll();

	Test select(int id);

	void update(Test test);

	void delete(int id);

	void callTestProcedure();
}