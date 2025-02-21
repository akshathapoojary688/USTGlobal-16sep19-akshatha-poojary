package com.ustglobal.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ustglobal.beans.Employee;

@Controller
public class HelloController {
	
@InitBinder
public void InitBinder(WebDataBinder binder) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	CustomDateEditor editor = new CustomDateEditor(format, true);
	binder.registerCustomEditor(Date.class, editor);
}
	
	@RequestMapping(path = "/hello")
	public String hello(@RequestParam("name") String name,@RequestParam("id") int id, ModelMap map)
	{
		//http://localhost:8080/springmvc/hello?name=akshatha&id=1
		map.addAttribute("msg", "Hello World");
		map.addAttribute("name", name);
		map.addAttribute("id", id);
		return "index";
	}
	
	@RequestMapping(path = "/hi/{name}/{id}")   //http://localhost:8080/springmvc/hi/aks/3
	public String hi(@PathVariable("name") String name, @PathVariable("id") int id, ModelMap map) {
		map.addAttribute("msg", "hi world");
		map.addAttribute("name", name);
		map.addAttribute("id", id);
		return "index";
	}
	
	
	
	/*model map and http are same
	 * 
	 * 
	 * @RequestMapping(path = "/hello") public String hello(HttpServletRequest req)
	 * { req.setAttribute("msg", "Hello"); return "index"; }
	 */
	
	//to go to form page
	@RequestMapping(path="form")
	public String formPage() {
		return "form";
	}
	
	//to get form data
	@RequestMapping(path = "/form", method = RequestMethod.POST)
	public String form(Employee employee, ModelMap map) {
		map.addAttribute("id", employee.getId());
		map.addAttribute("name", employee.getName());
		map.addAttribute("password", employee.getPassword());
		map.addAttribute("gender", employee.getGender());
		map.addAttribute("doj", employee.getDoj());
		return "formoutput";
	}
	
	@RequestMapping(path="create-cookie")
	public String createCookie(ModelMap map, HttpServletResponse response) {
		Cookie cookie = new Cookie("name","deepu");
		response.addCookie(cookie);
		return "createcookie";
	}
	@RequestMapping(path = "/read-cookie")
	public String readCookie(ModelMap map, @CookieValue(name = "name",required=false) String name) {
		map.addAttribute("name", name);
		return "readcookie";
		
	}
	
	@RequestMapping(path = "/redirect")
	public String redirect() {
		return "redirect: https://www.google.com";
	}
	
	@RequestMapping(path = "/forward")
	public String forward() {
		return "forward:hi/pruthvi/1";
	}
	
	
	
}
