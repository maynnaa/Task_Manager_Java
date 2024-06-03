package com.emsi.web.app.Controllers;

import com.emsi.web.app.models.employer;
import com.emsi.web.app.models.tache;
import com.emsi.web.app.repository.employer_repository;
import com.emsi.web.app.repository.tache_repository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Chefprojet {

    @Autowired
    private employer_repository employerRepository;

    @Autowired
    private tache_repository tacheRepository;

    @GetMapping("/cheprojet")
    public String showemployersforChef(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");
        List<employer> employers = employerRepository.findEmployerByChef(email);
        model.addAttribute("employers", employers);

        Integer nombretachecomplete = tacheRepository.taskcompletecount(email);
        Integer nombretotal = tacheRepository.alltaskscount(email);

        Integer moyenne = 0;
        if (nombretotal != 0) {
            moyenne = Math.round(((float) nombretachecomplete / nombretotal) * 100);
        }

        model.addAttribute("moyenne", moyenne);
        return "cheprojet"; // Replace with the actual template name
    }

    @PostMapping("/createTache")
    public String createTache(@RequestParam("nom") String nom,
                              @RequestParam("description") String description,
                              @RequestParam("employerId") Integer employerId) {
        tache newTache = new tache();
        newTache.setNomtache(nom);
        newTache.setDescription(description);
        newTache.setStatus("Nouvelle tâche");

        employer employer = employerRepository.findById(employerId).orElse(null);
        newTache.setEmployer(employer);

        tacheRepository.save(newTache);

        return "redirect:/cheprojet"; // Redirect back to the page
    }
}
