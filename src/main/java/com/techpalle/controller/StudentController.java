package com.techpalle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpalle.dao.StudentDao;
import com.techpalle.model.Admin;
import com.techpalle.model.Student;

@Controller
public class StudentController
{
	@RequestMapping(value="Student", params = "reg")
	public ModelAndView getRegisterPage()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register.jsp");
		return mv;
	}
	
	@RequestMapping("insert")
	public ModelAndView insertStudentServlet(HttpServletRequest req)
	{
		ModelAndView mv = new ModelAndView();
		String n = req.getParameter("tbName");
		String e = req.getParameter("tbEmail");
		String p = req.getParameter("tbPass");
		long m = Long.parseLong(req.getParameter("tbMob"));
		
		Student s = new Student(n, e, p, m);
		
		StudentDao.insertStudent(s);
		
		mv = displayAllStudents();
		
		return mv;
	}
	
	@RequestMapping(value="Student", params = "show")
	public ModelAndView displayAllStudents()
	{
		ModelAndView mv = new ModelAndView();
		
		ArrayList<Student> alStud = StudentDao.getAllStudents();
		
		mv.addObject("student", alStud);
		
		mv.setViewName("display.jsp");
		
		return mv;
	}
	
	@RequestMapping("editForm")
	public ModelAndView getEditForm(HttpServletRequest req)
	{
		ModelAndView mv = new ModelAndView();
		int i = Integer.parseInt(req.getParameter("sno"));
		
		Student s = StudentDao.getOneStudent(i);
		mv.addObject("Student", s);
		
		mv.setViewName("EditPage.jsp");
		
		return mv;
	}
	
	@RequestMapping("update")
	public ModelAndView updateStudent(HttpServletRequest req)
	{
		ModelAndView mv = new ModelAndView();
		
		int i = Integer.parseInt(req.getParameter("tbSno"));
		String n = req.getParameter("tbName");
		String e = req.getParameter("tbEmail");
		String p = req.getParameter("tbPass");
		long m = Long.parseLong(req.getParameter("tbMob"));	
		
		Student s = new Student(i, n, e, p, m);
		
		StudentDao.updateStudent(s);
		
		mv = displayAllStudents();
		
		return mv;
	}
	
	@RequestMapping(value="deleteForm")
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv=new ModelAndView();
		
		int i = Integer.parseInt(req.getParameter("sno"));
		StudentDao.deleteStudent(i);
		
		mv=displayAllStudents();

		return mv;
	}
	
	@RequestMapping("validate")
	public ModelAndView validateAdmin(HttpServletRequest req)
	{
		ModelAndView mv = new ModelAndView();
		
		String u = req.getParameter("tbUserName");
		String p = req.getParameter("tbPassword");
		
		Admin a = new Admin(u, p);
		
		boolean b = StudentDao.validateAdmin(a);
		if(b == true)
		{
			mv.setViewName("Admin.jsp");
		}
		else
		{
			mv.setViewName("index.jsp");
		}
		
		return mv;
	}
}
