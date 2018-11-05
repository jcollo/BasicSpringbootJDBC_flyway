package jc.ejemplo.db_01_02.controller;

import jc.ejemplo.db_01_02.data.PersonaRepo;
import jc.ejemplo.db_01_02.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyReqController {

    @Autowired
    PersonaRepo  personaRepo;

    @RequestMapping("/")
    public String raiz(int id){
        return "Probar con url /nombre/1, /persona/3, /h2-console";
    }

    @RequestMapping("/nombre/{id}")
    public String nombre(@PathVariable int id){
        return personaRepo.nombre(id);
    }

    @RequestMapping("/persona/{id}")
    public Persona persona(@PathVariable int id){
        return personaRepo.persona(id);
    }

}
