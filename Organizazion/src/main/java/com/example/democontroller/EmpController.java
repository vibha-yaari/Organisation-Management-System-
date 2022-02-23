package com.example.democontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.example.demoentity.Employee;
import com.example.demoservice.EmpService;
@Controller

public class EmpController {
	
@Autowired
 private EmpService service;

	@GetMapping("/")
	public String home()
	{
		return "info";
	}

@GetMapping("/new")
public String add(Model model) {
	model.addAttribute("employee", new Employee());
	return "new";
}

	@GetMapping("/index")
	public String viewHomePAge(Model model ) {
		List<Employee> listemployee=service.listAll();
		model.addAttribute("listemployee", listemployee);
		System.out.print("Get/");
		return "index";
	}

@RequestMapping(value="/save", method=RequestMethod.POST)
public String saveEmployee(@ModelAttribute("employee") Employee emp) {
	service.save(emp);
	return "redirect:/index";
}
@GetMapping ("/listemployee/edit/{id}")
public ModelAndView showEditEmployeePage(@PathVariable(name="id") long id) {
ModelAndView mav = new ModelAndView("new");
Employee emp=service.get(id);
mav.addObject("employee",emp);
//mav.setViewName("index");
return mav;
}

@GetMapping ("/listemployee/delete/{id}")
public String deleteemployee(@PathVariable(name="id")long id) {
	service.delete(id);
	return  "redirect:/index";
}

}
