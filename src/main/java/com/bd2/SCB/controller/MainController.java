/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal de la aplicación.
 * Maneja las solicitudes para las páginas principales y de inicio de sesión.
 */
@Controller
public class MainController {
    
    /**
     * Maneja las solicitudes GET a la raíz ("/").
     * Devuelve la vista "home".
     * @return La vista "home".
     */
    @GetMapping("/")
    public String home(){
        return "home"; // Devuelve la vista "home"
    }
    
    /**
     * Maneja las solicitudes GET a "/login".
     * Devuelve la vista "login".
     * @return La vista "login".
     */
    @GetMapping("/login")
    public String login(){
        return "login"; // Devuelve la vista "login"
    }   
}
