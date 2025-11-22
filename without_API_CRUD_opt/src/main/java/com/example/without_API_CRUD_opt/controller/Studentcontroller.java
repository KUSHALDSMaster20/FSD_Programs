package com.example.without_API_CRUD_opt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.without_API_CRUD_opt.model.Student;
import com.example.without_API_CRUD_opt.repository.StdRepo;

@Controller
public class Studentcontroller {
	@Autowired
	StdRepo stdrepo;
	
	@RequestMapping("index")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("addstd")
	public String addstd(Student student) {
		student=stdrepo.save(student);
		return "index.jsp";
	}
	@RequestMapping("getstd")
	public ModelAndView getstd(@RequestParam int sid) {
		ModelAndView mv=new ModelAndView("desplya.jsp");
		Student student=stdrepo.findById(sid).orElse(new Student());
		mv.addObject(student);
		return mv;
	}
	@RequestMapping("deletestd")
	public ModelAndView deletestd(@RequestParam int sid) {
		ModelAndView mv=new ModelAndView("deleted.jsp");
		Student student=stdrepo.findById(sid).orElse(new Student());
		stdrepo.deleteById(sid);
		mv.addObject(student);
		return mv;
	}
	@RequestMapping("updstd")
	public ModelAndView deletestd(Student student) {
		ModelAndView mv=new ModelAndView("update.jsp");
		student=stdrepo.findById(student.getSid()).orElse(new Student());
		mv.addObject(student);
		return mv;
	}

}
