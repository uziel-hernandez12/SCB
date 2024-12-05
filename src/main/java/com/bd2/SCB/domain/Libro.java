/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    private String lib_isbn;

    private String lib_titulo;

    private int lib_año_edicion;

    private boolean lib_disponible;

    @ManyToOne
    @JoinColumn(name = "edi_id", nullable = false)
    private Editorial editorial;

    // Getters y Setters
    public String getLib_isbn() {
        return lib_isbn;
    }

    public void setLib_isbn(String lib_isbn) {
        this.lib_isbn = lib_isbn;
    }

    public String getLib_titulo() {
        return lib_titulo;
    }

    public void setLib_titulo(String lib_titulo) {
        this.lib_titulo = lib_titulo;
    }

    public int getLib_año_edicion() {
        return lib_año_edicion;
    }

    public void setLib_año_edicion(int lib_año_edicion) {
        this.lib_año_edicion = lib_año_edicion;
    }

    public boolean isLib_disponible() {
        return lib_disponible;
    }

    public void setLib_disponible(boolean lib_disponible) {
        this.lib_disponible = lib_disponible;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

}
