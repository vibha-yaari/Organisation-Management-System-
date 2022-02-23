package com.example.democontroller;

import com.example.demoentity.LeaNextMon;
import com.example.demoentity.NewJoin;
import com.example.demoservice.LeaNextMonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LeaNextMonController {
@Autowired
    private LeaNextMonService leaNextMonService;

    @GetMapping("/newLeaNextMon")
    public String leaNextMonAdd(Model model){
        model.addAttribute("leaNextMon", new LeaNextMon() );
        return "newLeaNextMon";
    }
    @GetMapping("/leaNextMon")
    public String addLeaNextMon(Model model){
        List<LeaNextMon> listLeaNextMon= leaNextMonService.listAll();
        model.addAttribute("listLeaNextMon",listLeaNextMon);
        return "leaNextMon";
    }
    @RequestMapping(value="/saveLeaNextMon", method = RequestMethod.POST)
    public String saveLeaNextMon(@ModelAttribute("leaNextMon") LeaNextMon leaNextMon){
        leaNextMonService.save(leaNextMon);
        return "redirect:/leaNextMon";
    }

    @GetMapping ("/listLeaNextMon/edit/{id}")
    public ModelAndView showEditLeaNextMonPage(@PathVariable(name="id") long id) {
        ModelAndView mav = new ModelAndView("newleaNextMon");
        LeaNextMon leaNextMon=leaNextMonService.get(id);
        mav.addObject("leaNextMon",leaNextMon);
        mav.setViewName("newLeaNextMon");
        return mav;
    }


    @GetMapping ("/listLeaNextMon/delete/{id}")
    public String deleteNextLea(@PathVariable(name="id")long id) {
        leaNextMonService.delete(id);
        return  "redirect:/leaNextMon";
    }
}
