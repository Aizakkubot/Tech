package br.com.bugnacio.techos.controller;

import br.com.bugnacio.techos.repository.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class HomeController {
private final ClienteRepository clienteRepository;

    HomeController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

@GetMapping("/")
public String inicio(Model model) {
    model.addAttribute("totalClientes", clienteRepository.count());
    model.addAttribute("totalEquipamentos",10);
    model.addAttribute("osAbertas",3);
    model.addAttribute("osConcluidas",25);
    model.addAttribute("faturamento",4850);
    return "dashboard";
}
}