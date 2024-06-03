package com.emsi.web.app.Controllers;



import com.emsi.web.app.models.tache;
import com.emsi.web.app.repository.tache_repository;
import com.emsi.web.app.services.impl.TacheService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class TacheController {

    @Autowired
    private tache_repository tacheRepository;

    @Autowired
    private TacheService tacheService;
    @GetMapping("/projetemployer")
    public String showTasks(Model model , HttpSession session) {
        String email = (String) session.getAttribute("email");
        List<tache> taches = tacheRepository.findTacheByEmployerEmail(email);
        model.addAttribute("taches", taches);
        return "projetemployer"; // Replace with the actual template name
    }
    @Autowired
    private TacheService taskService;

    @PostMapping("/update-status/{taskId}/{status}")
    @ResponseBody
    public ResponseEntity<String> updateTaskStatus(

            @PathVariable ("taskId") Integer taskId,
            @PathVariable ("status") String status) {
        taskService.updateTaskStatus(taskId, status);
        return ResponseEntity.ok("Status updated successfully");
    }

}
