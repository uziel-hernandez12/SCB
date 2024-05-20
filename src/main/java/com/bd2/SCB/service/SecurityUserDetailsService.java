/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.service;

import com.bd2.SCB.repository.UsuarioRepository;
import com.bd2.SCB.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Servicio encargado de cargar los detalles del usuario para la autenticación.
 * Implementa la interfaz UserDetailsService de Spring Security. Esta clase
 * proporciona la lógica para cargar los detalles del usuario desde el
 * repositorio de usuarios.
 *
 * @author Admin
 */
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository; // Repositorio de usuarios

    // Constructor que recibe el repositorio de usuarios
    public SecurityUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Carga los detalles del usuario para la autenticación.
     *
     * @param username Nombre de usuario para buscar en la base de datos.
     * @return Detalles del usuario para la autenticación.
     * @throws UsernameNotFoundException Si no se encuentra el usuario en la
     * base de datos.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optUser = usuarioRepository.findByUsername(username); // Buscar usuario por nombre de usuario en el repositorio

        // Verificar si el usuario está presente en la base de datos
        if (optUser.isPresent()) {
            return new SecurityUser(optUser.get()); // Devolver los detalles del usuario encapsulados en un objeto SecurityUser
        }

        throw new UsernameNotFoundException("User not found" + username); // Lanzar una excepción si el usuario no se encuentra
    }
}
