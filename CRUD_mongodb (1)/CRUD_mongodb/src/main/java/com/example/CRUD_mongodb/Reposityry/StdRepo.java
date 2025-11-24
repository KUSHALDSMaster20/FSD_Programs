package com.example.CRUD_mongodb.Reposityry;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.CRUD_mongodb.Model.Student20;


public interface StdRepo extends MongoRepository<Student20,Integer>{

}
