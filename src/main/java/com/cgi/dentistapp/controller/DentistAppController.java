package com.cgi.dentistapp.controller;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.Dentist;
import com.cgi.dentistapp.repository.DentistRepository;
import com.cgi.dentistapp.service.DentistVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class DentistAppController extends WebMvcConfigurerAdapter {

    @Autowired
    private DentistVisitService dentistVisitService;

    @Autowired
    private DentistRepository dentistRepository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/add")
    public String showRegisterForm(DentistVisitDTO dentistVisitDTO, Model model) {
        List<Dentist> dentistList = dentistRepository.findAll();
        model.addAttribute("dentistList", dentistList);
        return "form";
    }

    @PostMapping("/add")
    public String postRegisterForm(@Valid DentistVisitDTO dentistVisitDTO, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Dentist> dentistList = dentistRepository.findAll();
            model.addAttribute("dentistList", dentistList);
            return "form";
        }

        dentistVisitService.addVisit(dentistVisitDTO.getDentistId(), dentistVisitDTO.getVisitTime());
        return "redirect:/results";
    }
}
