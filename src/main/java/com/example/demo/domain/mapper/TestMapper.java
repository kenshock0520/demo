package com.example.demo.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import com.example.demo.domain.entity.Test;

@Mapper
public interface TestMapper {

	@Select("select count(*) from test")
	long count();

	void insert(Test test);

	@Select("select * from test")
	List<Test> getTestAll(RowBounds rowBounds);

	Test select(int id);

	void update(Test test);

	void delete(int id);

	void callTestProcedure();
}