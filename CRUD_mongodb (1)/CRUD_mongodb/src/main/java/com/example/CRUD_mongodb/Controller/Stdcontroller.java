package com.example.CRUD_mongodb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUD_mongodb.Model.Student20;
import com.example.CRUD_mongodb.Reposityry.StdRepo;

@RestController
public class Stdcontroller {
	@Autowired
	StdRepo stdrepo;
	
	@RequestMapping("add")
	public String add(@RequestBody Student20 student20) {
		stdrepo.save(student20);
		return "data added........... master DS";
	}
	@GetMapping("get")
	public List<Student20>get(){
		return(List<Student20>)stdrepo.findAll();
	}
	@DeleteMapping("del/{sid}")
	public String del(@PathVariable int sid) {
		stdrepo.deleteById(sid);
		return "data deleted .... master DS ";
	}
	@PutMapping("upd")
	public String upd(@RequestBody Student20 student20) {
		Student20 stdupdate=stdrepo.findById(student20.getSid()).get();
		stdupdate.setSname(student20.getSname());
		stdupdate.setBranch(student20.getBranch());
		stdupdate.setAddress(student20.getAddress());
		stdrepo.save(stdupdate);
		return "data updated..... master DS ";
	}
	
	
}
