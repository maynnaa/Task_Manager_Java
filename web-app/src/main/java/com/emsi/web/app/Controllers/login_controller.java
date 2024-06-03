package com.emsi.web.app.Controllers;
import com.emsi.web.app.repository.employer_repository;
import com.emsi.web.app.repository.chef_de_projet_repository;
//import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.emsi.web.app.models.employer;
import com.emsi.web.app.models.chef_de_projet;


@Controller
public class login_controller {


        @GetMapping("/signup")
        public String signupPage() {
            return "signup"; // The logical name of your signup.html Thymeleaf template
        }

    @Autowired
    private employer_repository employerRepository; // Assuming you have a repository for Employer

    @Autowired
    private chef_de_projet_repository chefDeProjetRepository; // Assuming you have a repository for ChefDeProjet

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Assuming your HTML file is named// login.html
    }
    @GetMapping("/main")
    public String showmainPage(HttpSession session) {
        String email = (String) session.getAttribute("email");
        return "main"; // Assuming your HTML file is named login.html
    }
    @GetMapping("/employer")
    public String showemployerPage() {
        return "employer"; // Assuming your HTML file is named login.html
    }
    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password , HttpSession session) {
        // Check if an employer exists with the given email and password
        employer Employer = employerRepository.findByEmailAndEmppass(email, password);
        if (Employer != null) {
            // Successful login for employer
            session.setAttribute("email", email);
            return "redirect:/employer"; // Redirect to employer dashboard
        }

        // Check if a chef_de_projet gj, with the given email and password
        chef_de_projet chefDeProjet = chefDeProjetRepository.findByEmailAndChefpass(email, password);
        if (chefDeProjet != null) {
            // Successful login for chef_de_projet
            session.setAttribute("email", email);
            return "redirect:/main"; // Redirect to chef_de_projet dashboard
        }

        // Invalid credentials, redirect back to the login page
        return "redirect:/login?error";
    }
}