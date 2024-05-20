/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.domain;

import jakarta.persistence.*;

@Entity 
public class Docente {

    @Id
    @Column(name = "doc_matricula", length = 25)
    private String docMatricula;
    
    @Column(name = "doc_nombre", length = 35)
    private String docNombre;
    
    @Column(name = "doc_apellidos", length = 40)
    private String docApellidos;
    
    @Column(name = "doc_telefono", length = 15)
    private String docTelefono;
    
    @Column(name = "doc_email", length = 35)
    private String docEmail;
    
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Departamento departamento;
    
    @Column(name = "doc_foto", length = 500)
    private String docFoto;

    public String getDocFoto() {
        return docFoto;
    }

    public void setDocFoto(String docFoto) {
        this.docFoto = docFoto;
    }
    
    public String getDocMatricula() {
        return docMatricula;
    }

    public void setDocMatricula(String docMatricula) {
        this.docMatricula = docMatricula;
    }

    public String getDocNombre() {
        return docNombre;
    }

    public void setDocNombre(String docNombre) {
        this.docNombre = docNombre;
    }

    public String getDocApellidos() {
        return docApellidos;
    }

    public void setDocApellidos(String docApellidos) {
        this.docApellidos = docApellidos;
    }

    public String getDocTelefono() {
        return docTelefono;
    }

    public void setDocTelefono(String docTelefono) {
        this.docTelefono = docTelefono;
    }

    public String getDocEmail() {
        return docEmail;
    }

    public void setDocEmail(String docEmail) {
        this.docEmail = docEmail;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    
}//fin de la clase DocenteRepository    
