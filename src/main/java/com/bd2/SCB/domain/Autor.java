/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name="autor")
public class Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aut_id;
    
    private String aut_nombre;
    
    private String aut_apellidos;
    
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;

    public int getAut_id() {
        return aut_id;
    }

    public void setAut_id(int aut_id) {
        this.aut_id = aut_id;
    }

    public String getAut_nombre() {
        return aut_nombre;
    }

    public void setAut_nombre(String aut_nombre) {
        this.aut_nombre = aut_nombre;
    }

    public String getAut_apellidos() {
        return aut_apellidos;
    }

    public void setAut_apellidos(String aut_apellidos) {
        this.aut_apellidos = aut_apellidos;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    
    
}
