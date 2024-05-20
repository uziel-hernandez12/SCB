/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Departamento {
    @Id
    private int dept_id; // Identificador único del departamento

    private String dept_nombre; // Nombre del departamento

    /**
     * Método getter para obtener el identificador del departamento.
     * 
     * @return El identificador del departamento.
     */
    public int getDept_id() {
        return dept_id;
    }

    /**
     * Método setter para establecer el identificador del departamento.
     * 
     * @param dept_id El identificador del departamento.
     */
    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    /**
     * Método getter para obtener el nombre del departamento.
     * 
     * @return El nombre del departamento.
     */
    public String getDept_nombre() {
        return dept_nombre;
    }

    /**
     * Método setter para establecer el nombre del departamento.
     * 
     * @param dept_nombre El nombre del departamento.
     */
    public void setDept_nombre(String dept_nombre) {
        this.dept_nombre = dept_nombre;
    }
}
