package br.com.bugnacio.techos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

    

@Controller 
@RequestMapping("/clientes")
public class ClienteController {

    //O controller precisa do repository para buscar os clientes no banco de dados.
    private final ClienteRepository repo;

    //injeção de dependencia: o Spring vai criar o repository e passar para o controller.
    public ClienteController(clienteRepository repo) {
        this.repo = repo;
    }



@GetMapping 
public String listar(Model model) {

    model.addAttribute("clientes",repo.findAll());
    
    return "clientes/lista";
}

}
