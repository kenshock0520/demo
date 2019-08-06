package com.example.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.example.demo.domain.mapper")
@TestPropertySource(locations = "classpath:application-test.yml")
@Profile("test")
public class TestDataSourceConfiguration {

	// 本体のデータベースでは通るがH2では通らないようなSQLを持っている場合には
	// 以下のようにMockのBeanを入れる場合もあるでしょう

//	@Bean
//	public XXXMapper xxxMapper() {
//		XXXMapper xxxMapper = mock(XXXMapper.class);
//		// ここにMockの振る舞いを仕込んでおく
//		return xxxMapper;
//	}

}