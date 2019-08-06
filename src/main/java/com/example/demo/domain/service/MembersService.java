package com.example.demo.domain.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Members;

@Service
public class MembersService {

//	@Autowired
//	MembersRepository membersRepository;

	public Members getMemersById(int id) {
		return null;
//		return membersRepository.findById(id);
	}
}