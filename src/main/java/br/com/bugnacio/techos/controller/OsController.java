package br.com.bugnacio.techos.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller 
@RequestMapping("/os")
public class OsController {

    @GetMapping
    public String listarOs(Model model) {

        model.addAttribute("ordens", List.of());
        return "os/lista";
    }

}
