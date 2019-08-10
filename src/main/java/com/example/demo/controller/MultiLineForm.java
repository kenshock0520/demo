package com.example.demo.controller;

import java.util.List;

import lombok.Data;

@Data
public class MultiLineForm {

	private String mode;

	private List<LineForm> lineFormList;

}