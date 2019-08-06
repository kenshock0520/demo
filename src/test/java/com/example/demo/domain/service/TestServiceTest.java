package com.example.demo.domain.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.config.TestConfiguration;
import com.example.demo.config.TestDataSourceConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TestConfiguration.class, TestDataSourceConfiguration.class })
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class TestServiceTest {

	@Autowired
	private TestService testService;

//	@Autowired
//	private SampleDomainRepository sampleDomainRepository;

	@Test
	@Sql(scripts = "classpath:V1__init.sql", config = @SqlConfig(encoding = "utf-8"))
	public void test_get_期待通りデータが取得できること1() {
		Integer id = 1;
		String name = "updateFF";

		// テスト対象メソッドの実行
		com.example.demo.domain.entity.Test test = testService.getTestById(1);

		// 結果検証
		assertThat(test.getId(), is(id));
		assertThat(test.getProducts(), is(name));
	}

	@Test
	@Sql(scripts = "classpath:V1__init.sql", config = @SqlConfig(encoding = "utf-8"))
	public void test_get_期待通りデータが取得できること2() {
		Integer id = 4;
		String name = "1test";

		// テスト対象メソッドの実行
		com.example.demo.domain.entity.Test test = testService.getTestById(4);

		// 結果検証
		assertThat(test.getId(), is(id));
		assertThat(test.getProducts(), is(name));
	}
}