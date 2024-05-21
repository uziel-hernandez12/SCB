/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;

/**
 *
 * @author admin
 */
/**
 * Entidad que representa a un usuario en la aplicación.
 */
@Entity // Indica que esta clase es una entidad JPA y se mapeará a una tabla en la base de datos
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente valores de ID únicos
    private Long id; // Identificador único del usuario
    private String username; // Nombre de usuario
    private String password; // Contraseña
    private boolean enabled; // Indica si el usuario está habilitado o no
    
    @ManyToMany(fetch = FetchType.EAGER) // Relación muchos a muchos con la entidad Roles, se carga de manera ansiosa
    @JoinTable( // Define la tabla de unión para la relación muchos a muchos
            name = "users_roles", // Nombre de la tabla de unión
            joinColumns = @JoinColumn(name = "user_id"), // Columna que hace referencia al usuario
            inverseJoinColumns = @JoinColumn(name = "role_id") // Columna que hace referencia al rol
    )    
    private Set<Roles> roles; // Conjunto de roles asignados a este usuario

    // Métodos getter y setter para los campos de la entidad
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }   
}
