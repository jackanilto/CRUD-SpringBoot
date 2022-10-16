package com.cliente.controller;

import com.cliente.Repository.ClienteRepository;
import com.cliente.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {
// Criando a listagem de dados na pagina
    @Autowired
    private ClienteRepository cr;

    @RequestMapping("/cliente")                               // O RequesteMapping é chamado aqui
    public ModelAndView ListarClientes(){                        // Ele executa o Metodo Listar Clientes
        ModelAndView mv = new ModelAndView ("index");
        Iterable<Cliente> clientes = cr.findAll();               // Fazemos um findAll e salva tudo em clientes
        mv.addObject("clientes", clientes);          // e passamos tudo atravez do ModelAndView
        return mv;

    }

    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public String form(Cliente cliente){
        cr.save(cliente);

        return "redirect:/cliente";
    }
}
