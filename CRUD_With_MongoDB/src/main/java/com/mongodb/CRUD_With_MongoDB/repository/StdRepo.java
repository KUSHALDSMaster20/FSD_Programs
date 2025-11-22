package com.mongodb.CRUD_With_MongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.CRUD_With_MongoDB.model.StudentMDB;

public interface StdRepo extends MongoRepository<StudentMDB, Integer>{

}
