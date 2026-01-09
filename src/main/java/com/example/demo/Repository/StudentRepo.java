package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.StudentEntity.StudentEntity;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {

	Optional<StudentEntity> findByusername(String userName);
}
