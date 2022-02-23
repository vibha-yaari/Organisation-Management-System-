package com.example.democontroller;

import com.example.demoentity.Department;
import com.example.demoentity.Employee;
import com.example.demoservice.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
//@RequestMapping("dep")
public class DepController {
    @Autowired
    private DepService depService;

    @GetMapping("/newDep")
    public String departAdd(Model model){
        model.addAttribute("department", new Department() );
        return "newDep";
    }


    @GetMapping("/dep")
    public String addDep(Model model){
        List<Department> listDepartment= depService.listAll();
        model.addAttribute("listDepartment",listDepartment);
        return "dep";
    }



    @RequestMapping(value="/saveDep", method = RequestMethod.POST)
    public String saveDepartment(@ModelAttribute("department") Department dep){
        depService.save(dep);
        return "redirect:/dep";
    }

    @GetMapping ("/listDepartment/edit/{id}")
    public ModelAndView showEditDepartmentPage(@PathVariable(name="id") long id) {
        ModelAndView mav = new ModelAndView("newDep");
        Department dep=depService.get(id);
        mav.addObject("department",dep);
mav.setViewName("newDep");
        return mav;
    }

    @GetMapping ("/listDepartment/delete/{id}")
    public String deleteDepartment(@PathVariable(name="id")long id) {
        depService.delete(id);
        return  "redirect:/dep";
    }

}
