/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;

/**
 * Entidad que representa los roles de usuario en la aplicación.
 */
@Entity // Indica que esta clase es una entidad JPA y se mapeará a una tabla en la base de datos
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera automáticamente valores de ID únicos
    private Long id; // Identificador único del rol
    private String name; // Nombre del rol
    
    @ManyToMany(mappedBy = "roles") // Relación muchos a muchos con la entidad User, mapeada por la propiedad "roles" en User
    private Set<User> users; // Conjunto de usuarios que tienen este rol

    // Métodos getter y setter para los campos de la entidad
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }   
}
