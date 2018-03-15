package bzhukew.srs.Controllers;

import bzhukew.srs.repozitores.ClientRepozirory;
import models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

public class ClientController {

    @Autowired
    private ClientRepozirory clientRepository;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("client", new Client());
        return "client_add_form";
    }

    @PostMapping("/add")
    public String addClient(@ModelAttribute Client client) {
        clientRepository.save(client);
        return "redirect:/demo/all2";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Client> allClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/all2")
    public String allClients2(Model model) {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
    public ModelAndView deleteClient(@RequestParam("id") long idd) {
        clientRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/all2");
    }
    @PostMapping("/editClient")
    public String editClient(@ModelAttribute Client client) {
        Client client1 = new Client();
        client1.setId(a);
        client1.setName(client.getName());
        client1.setphone_number(client.getphone_number());
        client1.setAddress(client.getAddress());
        clientRepository.save(client1);
        return "redirect:/demo/all2";
    }

    @RequestMapping(value = "/editClient",method = RequestMethod.GET)
    public ModelAndView editClient(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Client> client = (Optional <Client>) clientRepository.findById(id);
        model.addAttribute("client",client);
        return new ModelAndView("smp");
    }
    @RequestMapping("/editClient")
    public String showForm2(Model model){
        model.addAttribute("client",new Client());
        return "smp";
    }
}

