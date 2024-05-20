/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.security;

import com.bd2.SCB.domain.Usuario;
import java.util.Collection;
import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Clase que representa un usuario autenticado en el sistema.
 * Implementa la interfaz UserDetails de Spring Security.
 * 
 * @author Admin
 */
public class SecurityUser implements UserDetails {

    private final Usuario user; // Usuario asociado a este SecurityUser

    // Constructor que recibe un objeto Usuario
    public SecurityUser(Usuario user) {
        this.user = user;
    }
    
    // Métodos de la interfaz UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Devolver una lista vacía ya que no se implementa la lógica de autorización aquí
        return Collections.emptyList();
        // O devolver null si se prefiere
        // return null;
    }

    @Override
    public String getPassword() {
        // Devuelve la contraseña del usuario
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        // Devuelve el nombre de usuario del usuario
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Devuelve true si la cuenta del usuario no ha expirado
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Devuelve true si la cuenta del usuario no está bloqueada
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Devuelve true si las credenciales del usuario no han expirado
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Devuelve true si el usuario está habilitado y activo
        return true;
    }

}