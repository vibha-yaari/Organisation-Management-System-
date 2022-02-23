package com.example.democontroller;

import com.example.demoentity.NewJoin;
import com.example.demoservice.NewJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewJoinController {
    @Autowired
    private NewJoinService newJoinService;

    @GetMapping("/newJoin")
    public String newJoinAdd(Model model){
        model.addAttribute("newJoin", new NewJoin() );
        return "newJoin";
    }
    @GetMapping("/join")
    public String addNewJoin(Model model){
        List<NewJoin> listNewJoin= newJoinService.listAll();
        model.addAttribute("listNewJoin",listNewJoin);
        return "join";
    }

    @RequestMapping(value="/saveNewJoin", method = RequestMethod.POST)
    public String saveNewJoin(@ModelAttribute("newJoin") NewJoin newJoin){
        newJoinService.save(newJoin);
        return "redirect:/join";
    }
    @GetMapping ("/listNewJoin/edit/{id}")
    public ModelAndView showEditNewJoinPage(@PathVariable(name="id") long id) {
        ModelAndView mav = new ModelAndView("newJoin");
        NewJoin newJoin=newJoinService.get(id);
        mav.addObject("newJoin",newJoin);
        mav.setViewName("newJoin");
        return mav;
    }
    @GetMapping ("/listNewJoin/delete/{id}")
    public String deleteNewJoin(@PathVariable(name="id")long id) {
        newJoinService.delete(id);
        return  "redirect:/join";
    }
}
