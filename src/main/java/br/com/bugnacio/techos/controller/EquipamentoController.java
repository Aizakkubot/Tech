package br.com.bugnacio.techos.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

import org.springframework.data.domain.Sort;
import br.com.bugnacio.techos.model.Equipamento;
import br.com.bugnacio.techos.model.TipoEquipamento;
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
    

    //lsitar
@GetMapping
public String listar(Model model) {

    model.addAttribute("equipamentos", repo.findAll());

    return "equipamentos/lista";
}

// PESQUISAR
@GetMapping("/buscar")
public String buscar(@RequestParam String nome, Model model) {

    model.addAttribute("equipamentos",
            repo.findByMarcaContainingIgnoreCaseOrModeloContainingIgnoreCase(
                    nome, nome));

    return "equipamentos/lista";
}

// CREATE (1/2): formulário vazio
@GetMapping("/novo")
public String novo(Model model) {
    model.addAttribute("equipamento", new Equipamento());
    carregarCombos(model);
    return "equipamentos/form";
}

    // CREATE (2/2) e UPDATE
    // Recebe os dados enviados pelo formulário, valida e salva no banco.
    @PostMapping("/salvar")
    public String salvar(
            @Valid @ModelAttribute  ("equipamento") Equipamento equipamento,
            BindingResult result,
            Model model,
            RedirectAttributes redirect) {

                // Define a mensagem de acordo com a operação realizada.
                if (result.hasErrors()) {

                    carregarCombos(model);

                    return "equipamentos/form";
                    
                }

                repo.save(equipamento);

                // Mensagem exibida quando um novo cliente é cadastrado.

            redirect.addFlashAttribute(
                    "mensagem",
                    "Equipamento salvo com sucesso!");                   

                   return "redirect:/equipamentos";
            }

             // DELETE.
    @PostMapping("/{id}/excluir")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes redirect) {
        repo.deleteById(id);
        redirect.addFlashAttribute("mensagem", "Equipamento excluído.");
        return "redirect:/equipamentos";
    }

    // UPDATE (1/2): formulario preenchido.
    @GetMapping("{id}/editar")
    public String editar(@PathVariable Long id,
        Model model, RedirectAttributes redirect) {
            Optional<Equipamento> equipamento = repo.findById(id);
            if (equipamento.isEmpty()) {
                redirect.addFlashAttribute("mensagem", "Equipamento não encontrado.");
                return "redirect:/equipamentos";
            }
            model.addAttribute("equipamento", equipamento.get());
            carregarCombos(model);
            return "equipamentos/form";
        }
    
    

//carrega combo

    private void carregarCombos(Model model) {

        model.addAttribute("clientes",
                clienteRepo.findAll(Sort.by("nome")));

        model.addAttribute("tipos",
                TipoEquipamento.values());
    }

//
}
