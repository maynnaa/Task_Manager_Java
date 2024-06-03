package com.emsi.web.app.Controllers;

import com.emsi.web.app.models.employer;
import com.emsi.web.app.repository.employer_repository;
import com.emsi.web.app.services.impl.ChefemployeSERVICE;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChefemployerController {

    @Autowired
    private employer_repository employerRepository;

    @Autowired
    private ChefemployeSERVICE chefemployeSERVICE;

    @GetMapping("/chefemployer")
    public String showemployers(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");
        List<employer> employers = employerRepository.findEmployerByChef(email);
        model.addAttribute("employers", employers);
        return "chefemployer"; // Make sure this matches your Thymeleaf template name
    }
}
