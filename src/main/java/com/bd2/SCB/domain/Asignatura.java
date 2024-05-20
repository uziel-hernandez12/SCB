/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.domain;
import jakarta.persistence.*;


@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asig_clave")
    private int asigClave; // Clave primaria de la asignatura

    @Column(name = "asig_titulo")
    private String asigTitulo; // Título de la asignatura

    @ManyToOne
    @JoinColumn(name =  "pro_id")
    private ProgramaAcademico programaAcademico; // Programa académico al que pertenece la asignatura

    @ManyToOne
    @JoinColumn(name = "doc_matricula")
    private Docente docente; // Docente que imparte la asignatura

    /**
     * Método getter para obtener la clave de la asignatura.
     * 
     * @return La clave de la asignatura.
     */
    public int getClave() {
        return asigClave;
    }

    /**
     * Método setter para establecer la clave de la asignatura.
     * 
     * @param clave La clave de la asignatura.
     */
    public void setClave(int clave) {
        this.asigClave = clave;
    }

    /**
     * Método getter para obtener el título de la asignatura.
     * 
     * @return El título de la asignatura.
     */
    public String getTitulo() {
        return asigTitulo;
    }

    /**
     * Método setter para establecer el título de la asignatura.
     * 
     * @param titulo El título de la asignatura.
     */
    public void setTitulo(String titulo) {
        this.asigTitulo = titulo;
    }

    /**
     * Método getter para obtener el programa académico al que pertenece la asignatura.
     * 
     * @return El programa académico al que pertenece la asignatura.
     */
    public ProgramaAcademico getProgramaAcademico() {
        return programaAcademico;
    }

    /**
     * Método setter para establecer el programa académico al que pertenece la asignatura.
     * 
     * @param programaAcademico El programa académico al que pertenece la asignatura.
     */
    public void setProgramaAcademico(ProgramaAcademico programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    /**
     * Método getter para obtener el docente que imparte la asignatura.
     * 
     * @return El docente que imparte la asignatura.
     */
    public Docente getDocente() {
        return docente;
    }

    /**
     * Método setter para establecer el docente que imparte la asignatura.
     * 
     * @param docente El docente que imparte la asignatura.
     */
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

}
