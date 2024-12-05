/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author admin
 */
@Configuration // Indica que esta clase es una configuración de Spring
@EnableWebSecurity // Habilita la seguridad web en la aplicación
public class WebSecurityConfig /*extends WebSecurityConfigurerAdapter */{
    
    // Indica a Spring que debe inyectar una instancia de UserDetailsService
    @Autowired
    private UserDetailsService userDetailsService;
    
    // Define un bean para proporcionar un PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // Utiliza BCrypt para codificar contraseñas
    }
    
    // Define un bean para configurar la seguridad HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Configura las reglas de autorización
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/", "/home", "/register").permitAll() // Permitir el acceso a estas URLs sin autenticación
                    .anyRequest().authenticated() // Requerir autenticación para cualquier otra URL
            )
            // Configura el formulario de inicio de sesión
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login") // URL de la página de inicio de sesión
                    .defaultSuccessUrl("/inicio", true) // Redireccionar después del inicio de sesión exitoso
                    .permitAll() // Permitir el acceso a la página de inicio de sesión sin autenticación
            )
            // Configura la funcionalidad de logout
            .logout(logout ->
                logout
                    .logoutUrl("/logout") // URL para realizar el logout
                    .logoutSuccessUrl("/login?logout") // URL de redireccionamiento después del logout
                    .invalidateHttpSession(true) // Invalidar la sesión HTTP después del logout
                    .deleteCookies("JSESSIONID") // Borrar la cookie de sesión después del logout
                    .permitAll() // Permitir el acceso al logout sin autenticación
            );

        return http.build(); // Construir y devolver la cadena de filtros de seguridad
    }
    
    // Define un bean para obtener el AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager(); // Obtener el AuthenticationManager
    }
}
