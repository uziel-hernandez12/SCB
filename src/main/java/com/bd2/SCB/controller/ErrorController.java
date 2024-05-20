/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorController {

    /**
     * Método que maneja las solicitudes cuando se produce un error.
     *
     * @param continueUrl La URL opcional a la que se debe redirigir después de manejar el error.
     * @return La redirección a la página de inicio del sitio.
     */
    @GetMapping("/error")
    public String handleError(@RequestParam(name = "continue", required = false) String continueUrl) {
        // Se redirige a la página de inicio del sitio después de manejar el error
        return "redirect:/"; 
    }

}
