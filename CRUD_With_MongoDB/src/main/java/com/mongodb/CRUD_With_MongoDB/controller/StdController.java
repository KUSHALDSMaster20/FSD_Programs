package com.mongodb.CRUD_With_MongoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.CRUD_With_MongoDB.model.StudentMDB;
import com.mongodb.CRUD_With_MongoDB.repository.StdRepo;

@RestController
public class StdController {
	@Autowired
	StdRepo stdrepo;
	
	@RequestMapping("addstd")
	public String addstd(@RequestBody StudentMDB studentmdb) {
		stdrepo.save(studentmdb);
		return "data is recorded........ ";
	}
	
	@GetMapping("getstd")
	public List<StudentMDB>getstd(){
		return(List<StudentMDB>)stdrepo.findAll();
	}
	@DeleteMapping("delet/{sid}")
	public String delstd(@PathVariable int sid) {
		stdrepo.deleteById(sid);
		return "data deleted succefully.........";
	}
	@PutMapping("update")
	public String updstd(@RequestBody StudentMDB studentmdb) {
		StudentMDB stdupdate=stdrepo.findById(studentmdb.getSid()).get();
		stdupdate.setSname(studentmdb.getSname());
		stdupdate.setAddress(studentmdb.getAddress());
		stdupdate.setBranch(studentmdb.getBranch());
		stdrepo.save(stdupdate);
		return "data updated succefully........";
	}

}
