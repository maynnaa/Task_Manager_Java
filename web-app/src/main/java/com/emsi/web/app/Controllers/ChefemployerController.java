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
public class ChefemployerController {

    @Autowired
    private employer_repository employerRepository;

    @Autowired
    private ChefemployeSERVICE chefemployeSERVICE;
    @GetMapping("/chefemployer")
    public String showemployers(Model model , HttpSession session) {
        String email = (String) session.getAttribute("email");
        List<employer> employers = employerRepository.findEmployerByChef(email);
        model.addAttribute("employer", employers);

        return "chefemployer"; // Replace with the actual template name
    }


}
