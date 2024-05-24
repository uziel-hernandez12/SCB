/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "editorial")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int edi_id;

    private String edi_nombre;

    // Getters y Setters
    public int getEdi_id() {
        return edi_id;
    }

    public void setEdi_id(int edi_id) {
        this.edi_id = edi_id;
    }

    public String getEdi_nombre() {
        return edi_nombre;
    }

    public void setEdi_nombre(String edi_nombre) {
        this.edi_nombre = edi_nombre;
    }

}
