/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.service;


import com.bd2.SCB.domain.Roles;
import com.bd2.SCB.domain.User;
import com.bd2.SCB.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio UserDetailsService para cargar los detalles del usuario por su nombre de usuario.
 */
@Service // Indica que esta clase es un componente de servicio de Spring
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Repositorio para acceder a los datos de usuario
    
    // Método para cargar los detalles del usuario por su nombre de usuario
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca el usuario por su nombre de usuario en el repositorio
        User user = userRepository.findByUsername(username);
        
        // Si el usuario no existe, lanza una excepción de UsernameNotFoundException
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        // Crea un conjunto de autoridades concedidas para el usuario
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        // Itera sobre los roles del usuario y agrega autoridades concedidas para cada uno
        for (Roles role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));           
        }
        
        // Devuelve un objeto UserDetails que representa al usuario
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }  
}
