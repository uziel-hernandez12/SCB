/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Configuración de seguridad web.
 * Esta clase se encarga de configurar la seguridad de la aplicación web.
 * 
 * Autor: Admin
 */
@Configuration
public class WebSecurityConfig {
   
   /**
    * Método para crear un bean de codificador de contraseñas.
    * Este método crea y configura un codificador de contraseñas BCrypt.
    * BCrypt es un algoritmo de hashing de contraseñas que es seguro y adecuado para almacenar contraseñas en la base de datos.
    * 
    * @return Un objeto PasswordEncoder que utiliza el algoritmo BCrypt para codificar contraseñas.
    */
   @Bean
   public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }
}
