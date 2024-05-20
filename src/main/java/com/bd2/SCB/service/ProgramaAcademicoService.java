/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.service;

import com.bd2.SCB.domain.ProgramaAcademico;
import com.bd2.SCB.repository.ProgramaAcademicoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Servicio que proporciona operaciones relacionadas con la gestión de programas
 * académicos. Esta clase actúa como una capa intermedia entre los controladores
 * y el repositorio de programas académicos.
 *
 * @author Admin
 */
@Service
public class ProgramaAcademicoService {

    private final ProgramaAcademicoRepository academicoRepository; // Repositorio de programas académicos

    // Constructor que recibe el repositorio de programas académicos
    public ProgramaAcademicoService(ProgramaAcademicoRepository academicoRepository) {
        this.academicoRepository = academicoRepository;
    }

    /**
     * Busca y devuelve todos los programas académicos disponibles en la base de
     * datos.
     *
     * @return Lista de todos los programas académicos
     */
    public List<ProgramaAcademico> buscarTodos() {
        return academicoRepository.findAll();
    }
}
