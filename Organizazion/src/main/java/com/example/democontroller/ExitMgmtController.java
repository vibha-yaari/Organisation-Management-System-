package com.example.democontroller;


import com.example.demoentity.ExitMgmt;
import com.example.demoservice.ExitMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExitMgmtController {
    @Autowired
    private ExitMgmtService exitMgmtService;
    @GetMapping("/newExitMgmt")
    public String exitMgmtAdd(Model model){
        model.addAttribute("exitMgmt", new ExitMgmt() );
        return "newExitMgmt";
    }

    @GetMapping("/exitMgmt")
    public String addExitMgmt(Model model){
        List<ExitMgmt> listExitMgmt= exitMgmtService.listAll();
        model.addAttribute("listExitMgmt",listExitMgmt);
        return "exitMgmt";
    }

    @RequestMapping(value="/saveExitMgmt", method = RequestMethod.POST)
    public String saveExitMgmt(@ModelAttribute("exitMgmt") ExitMgmt exitMgmt){
       exitMgmtService.save(exitMgmt);
        return "redirect:/exitMgmt";
    }
    @GetMapping ("/listExitMgmt/edit/{id}")
    public ModelAndView showEditExitMgmt(@PathVariable(name="id") long id) {
        ModelAndView mav = new ModelAndView("newExitMgmt");
        ExitMgmt emg =exitMgmtService.get(id);
        mav.addObject("exitMgmt",emg);
        mav.setViewName("newExitMgmt");
        return mav;
    }

    @GetMapping ("/listExitMgmt/delete/{id}")
    public String deleteExitMgmt(@PathVariable(name="id")long id) {
        exitMgmtService.delete(id);
        return  "redirect:/exitMgmt";
    }



}
