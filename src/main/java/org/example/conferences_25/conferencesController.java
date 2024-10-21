package org.example.conferences_25;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class conferencesController {
    @Autowired
    private conferencesService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Conferences> listConferences = service.listAll(keyword);
        model.addAttribute("listConferences", listConferences);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Conferences conference = new Conferences();
        model.addAttribute("conference", conference);
        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("conference") Conferences conference) {
        service.save(conference);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit");
        Conferences conference = service.get(id);
        mav.addObject("conference", conference);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping (value = "/sorted/{direction}", method = RequestMethod.GET)
    public String getConferencesSorted(@PathVariable(name = "direction") String direction, Model model, @Param("keyword") String keyword) {
        Sort sort = Sort.by("date");
        if (direction.equals("desc")) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }
        List<Conferences> listConferences = service.getAllConferencesSorted(sort);
        model.addAttribute("listConferences", listConferences);
        model.addAttribute("keyword", keyword);
        return "index";
    }
}
