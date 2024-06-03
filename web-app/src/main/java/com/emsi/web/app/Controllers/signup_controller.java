package com.emsi.web.app.Controllers;

import com.emsi.web.app.models.chef_de_projet;
import com.emsi.web.app.models.employer;
import com.emsi.web.app.repository.employer_repository;
import com.emsi.web.app.services.impl.ChefDeProjetService;
import com.emsi.web.app.services.impl.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.emsi.web.app.repository.chef_de_projet_repository;
import java.util.regex.Pattern;

@Controller
public class signup_controller {
    private final ChefDeProjetService chefDeProjetService;
    private final EmployerService employerService;
    @GetMapping("/validation")
    public String showvalidation() {
        return "validation";}
    public signup_controller(ChefDeProjetService chefDeProjetService, EmployerService employerService) {
        this.chefDeProjetService = chefDeProjetService;
        this.employerService = employerService;
}
    @Autowired
    private chef_de_projet_repository chefDeProjetRepository = null;

    @Autowired
    private employer_repository employerRepository=null;

    @PostMapping("/signup")
    public String processSignupForm(@RequestParam String nom,
                                    @RequestParam String prenom,
                                    @RequestParam String email,
                                    @RequestParam String pass,
                                    @RequestParam String role) {
        // Validate email and password
        if (!isValidEmail(email) || pass.length() < 8 || nom.isEmpty() || prenom.isEmpty() ||email.isEmpty() || pass.isEmpty() || role.isEmpty()) {
            // Handle invalid data, show error message, etc.
            return "redirect:/signup"; // Redirect back to the signup page
        }
        chef_de_projet a = chefDeProjetRepository.findByEmail(email);
        employer b = employerRepository.findByEmail(email);
        if ("CHefdeprojet".equalsIgnoreCase(role)) {
            chef_de_projet chefDeProjet = new chef_de_projet();
            // Set the appropriate fields based on the form data
            chefDeProjet.setNom(nom);
            chefDeProjet.setPrenom(prenom);
            chefDeProjet.setEmail(email);
            chefDeProjet.setChefpass(pass);




            // Save the ChefDeProjet entity to the database using the service
            if(!(a!=null) && !(b!=null))
            {
                chefDeProjetService.saveChefDeProjet(chefDeProjet);
            }
            else{
                return "redirect:/signup?emailExists=true";
            }

        } else if ("Employer".equalsIgnoreCase(role)) {
            employer Employer = new employer();
            // Set the appropriate fields based on the form data
            Employer.setNom(nom);
            Employer.setPrenom(prenom);
            Employer.setEmail(email);
            Employer.setEmppass(pass);


            // Save the Employer entity to the database using the service
            if(!(a!=null) && !(b!=null)) {
                employerService.saveEmployer(Employer);
            }
            else {
                System.out.println("AAAAAAAAAAAAAAAA");
                return "redirect:/signup?emailExists=true";
            }
        } else {
            // Handle invalid role, show error message, etc.
            System.out.println("ZZZZZZZZZZZZZZZZZZZ");
            return "redirect:/signup"; // Redirect back to the signup page
        }

        // Redirect to BASTA.html after successful registration
        return "redirect:/validation";
    }

    private boolean isValidEmail(String email) {
        // Implement your email validation logic here, you can use regex as in your HTML code
        // or other email validation libraries
        // For simplicity, we'll use the same regex validation you used in your HTML
        Pattern emailRegex = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");
        return emailRegex.matcher(email).matches();
    }
}
