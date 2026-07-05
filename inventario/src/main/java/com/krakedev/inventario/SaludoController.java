package com.krakedev.inventario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // indica que esta clase es un controlador rest
@RequestMapping("/micontroller")
public class SaludoController {

    @GetMapping("saludo")
    public String saludar() {
        return "Hola desde spring boot";
    }

}
