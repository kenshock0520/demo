package com.example.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Members;
import com.example.demo.domain.repository.MembersRepository;

@Service
public class MembersService {

	@Autowired
	MembersRepository membersRepository;

	public Members getMemersById(int id) {
		return membersRepository.findById(id);
	}
}