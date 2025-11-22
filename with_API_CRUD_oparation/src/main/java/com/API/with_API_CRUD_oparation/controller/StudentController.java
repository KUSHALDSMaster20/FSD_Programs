package com.API.with_API_CRUD_oparation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.API.with_API_CRUD_oparation.model.Student;
import com.API.with_API_CRUD_oparation.repository.StdRepo;

@RestController
public class StudentController {
	@Autowired
	StdRepo stdrepo;
	
	@PostMapping("/addstd2")
	public String addstd(@RequestBody Student student) {
		stdrepo.save(student);
		return "data is recorded......";
	}
	@GetMapping("getstd2")
	public List<Student>getstd(){
		return(List<Student>)stdrepo.findAll();
	}
	@DeleteMapping("delete2/{sid}")
	public String delete(@PathVariable int sid) {
		stdrepo.deleteById(sid);
		return "record deleted succefully......";
	}
	@PutMapping("upd2")
	public String upd(@RequestBody Student student) {
		Student stdupdate=stdrepo.findById(student.getSid()).get();
		if(stdrepo.findById(student.getSid()).isPresent()) {
			stdupdate.setSname(student.getSname());
			stdupdate.setLname(student.getLname());
			stdupdate.setBranch(student.getBranch());
			stdrepo.save(stdupdate);
			return "record updated succefully......";
		}else {
			return "record not found.......";
		}
	}

}
