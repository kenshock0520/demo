package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entity.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members, Integer> {
	Members findById(int id);
}