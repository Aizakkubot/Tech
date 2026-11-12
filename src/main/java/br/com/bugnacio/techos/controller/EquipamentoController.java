package br.com.bugnacio.techos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bugnacio.techos.model.Cliente;
import br.com.bugnacio.techos.model.Equipamento;
import br.com.bugnacio.techos.repository.ClienteRepository;
import br.com.bugnacio.techos.repository.EquipamentoRepository;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoRepository repo;
    private final ClienteRepository clienteRepo;

    public EquipamentoController(
            EquipamentoRepository repo,
            ClienteRepository clienteRepo) {

        this.repo = repo;
        this.clienteRepo = clienteRepo;
    }
    


    @GetMapping
    public String listar(Model model) {

   model.addAttribute("equipamentos", List.of());

    return "equipamentos/lista";
    }

    // CREATE (1/2): formulario vazi
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("equipamento", new Equipamento());
        return "equipamento/form";
    }

    // CREATE (2/2) e UPDATE
    // Recebe os dados enviados pelo formulário, valida e salva no banco.
    @PostMapping("/salvar")
    public String salvar(
            @Valid Equipamento equipamento,
            BindingResult result,
            RedirectAttributes redirect) {

            }

}
