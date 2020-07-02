package com.understanding.springmvc.controllers;

import com.understanding.springmvc.model.Jedi;
import com.understanding.springmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class JediController {

    //Attention : Calling our repository directly within our controller is not the best practice
    @Autowired
    private JediRepository jediRepository;

    @GetMapping("/jedi")
    public ModelAndView jedi() {

        final Jedi Luke = new Jedi("Luke", "Skywalker");
        final ModelAndView modelandView = new ModelAndView();

        modelandView.setViewName("jedi");
        modelandView.addObject("allJedi", jediRepository.getAllJedi());

        return modelandView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi() {

        final ModelAndView modelandView = new ModelAndView();

        modelandView.setViewName("new-jedi");
        modelandView.addObject("jedi", new Jedi());

        return modelandView;
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, Errors errors, RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            return "new-jedi";
        }

        jediRepository.addJedi(jedi);

        redirectAttributes.addFlashAttribute("message", "Jedi registered with success");

        return "redirect:jedi";
    }
}
