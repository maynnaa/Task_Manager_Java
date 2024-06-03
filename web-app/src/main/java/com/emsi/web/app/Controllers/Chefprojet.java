

package com.emsi.web.app.Controllers;



import com.emsi.web.app.models.employer;
import com.emsi.web.app.models.tache;
import com.emsi.web.app.repository.employer_repository;
import com.emsi.web.app.repository.tache_repository;
import com.emsi.web.app.services.impl.ChefemployeSERVICE;
import com.emsi.web.app.services.impl.TacheService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class Chefprojet {

    @Autowired
    private employer_repository employerRepository;
    @Autowired
    private tache_repository tacheRepository;
    @Autowired
    private ChefemployeSERVICE chefemployeSERVICE;
    @GetMapping("/cheprojet")
    public String showemployersforChef(Model model , HttpSession session) {
        String email = (String) session.getAttribute("email");
        List<employer> employers = employerRepository.findEmployerByChef(email);
        model.addAttribute("employers", employers);
        Integer nombretachecomplete=tacheRepository.taskcompletecount(email);
        Integer nombretotal=tacheRepository.alltaskscount(email);

        Integer moyenne = 0;
        if (nombretotal != 0) {
            moyenne = Math.round(((float) nombretachecomplete / nombretotal) * 100);
            System.out.println(nombretachecomplete);
            System.out.println(nombretotal);
            System.out.println(moyenne);
        }

        model.addAttribute("moyenne", moyenne);
        return "cheprojet"; // Replace with the actual template name
    }
    @PostMapping("/createTache")
    public String createTache(@RequestParam("nom") String nom,
                              @RequestParam("description") String description,
                              @RequestParam("employerId") Integer employerId) {
        // Create a new tache instance
        tache newTache = new tache();
        newTache.setNomtache(nom);
        newTache.setDescription(description);
        newTache.setStatus("Nouvelle tâche"); // Set initial status

        // Fetch the corresponding employer using employerId
        employer employer = employerRepository.findById(employerId).orElse(null);
        newTache.setEmployer(employer);

        // Save the new tache
        tacheRepository.save(newTache);


        return "redirect:/cheprojet"; // Redirect back to the page
    }

}
