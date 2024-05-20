/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase controladora de la pantalla de incio
 *
 * @author Admin
 */
@Controller
public class InicioController {

    @GetMapping("/")
    public String showHome() {
        try {
            // Lógica para mostrar la página de inicio
            return "inicio";
        } catch (Exception e) {
            // Manejo de la excepción
            e.printStackTrace(); // Opcionalmente, puedes registrar la excepción para obtener más detalles en los registros
            return "error"; // Devuelve una página de error o redirige a una página de error
        }
    }

}
