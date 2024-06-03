

package com.emsi.web.app.Controllers;


        import com.emsi.web.app.models.client;
        import com.emsi.web.app.services.impl.ClientService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.ui.Model;


        import java.util.List;

@Controller
public class ClientControllerCHEF {

    @Autowired
    private ClientService clientService; // You need to create a ClientService

    @GetMapping("/chefclient")
    public String showClients(Model model) {
        List<client> clients = clientService.getAllClients(); // Fetch your clients from a service
        model.addAttribute("client", clients);
        return "chefclient"; // Replace with your actual template name
    }
}
