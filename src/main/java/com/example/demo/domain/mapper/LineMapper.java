package com.example.demo.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.entity.Line;
import com.example.demo.domain.entity.Test;

@Mapper
public interface LineMapper {

	@Select("select count(*) from test")
	long count();

	void insert(Test test);

	@Select("select * from multiLine")
	List<Line> getLineAll();

	Test select(int id);

	void update(Test test);

	void delete(int id);

	void callTestProcedure();
}