package com.example.democontroller;

import com.example.demoentity.Leaves;
import com.example.demoservice.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LeaveController {
@Autowired
    private LeaveService lvService;

   @GetMapping("/newLeave")
    public String leaveAdd(Model model){
       model.addAttribute("leaves", new Leaves());
       return  "newLeave";
   }

   @GetMapping("/leave")
    public  String addLeave(Model model) {
       List<Leaves> listLeave=lvService.listAll();
       model.addAttribute("listLeave", listLeave);
       return "leave";
   }
@RequestMapping(value="/saveLeave",method = RequestMethod.POST)
    public String saveLeave(@ModelAttribute("leaves") Leaves leave){
       lvService.save(leave);
       return "redirect:/leave";
}
    @GetMapping ("/listLeave/edit/{id}")
    public ModelAndView showEditLeavePage(@PathVariable(name="id") long id) {
        ModelAndView mav = new ModelAndView("newDep");
        Leaves leave=lvService.get(id);
        mav.addObject("leaves", leave);
        mav.setViewName("newLeave");
        return mav;
    }

    @GetMapping ("/listLeave/delete/{id}")
    public String deleteLeave(@PathVariable(name="id")long id) {
       lvService.delete(id);
        return  "redirect:/leave";
    }
}
