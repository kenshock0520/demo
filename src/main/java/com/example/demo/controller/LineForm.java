package com.example.demo.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LineForm {

	@NotNull
	@Min(1)
	private int id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String value;

	@NotEmpty
	private String flg;
}