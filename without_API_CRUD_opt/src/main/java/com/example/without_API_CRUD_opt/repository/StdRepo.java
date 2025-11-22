package com.example.without_API_CRUD_opt.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.without_API_CRUD_opt.model.Student;

public interface StdRepo extends CrudRepository<Student, Integer>{

}
