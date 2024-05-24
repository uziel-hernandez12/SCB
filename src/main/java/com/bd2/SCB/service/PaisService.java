/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.service;

import com.bd2.SCB.domain.Pais;
import com.bd2.SCB.repository.PaisRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Servicio para manejar operaciones relacionadas con países. Contiene lógica de
 * negocio y se comunica con el repositorio PaisRepository para acceder a la
 * capa de persistencia.
 *
 * @author Admin
 */
@Service
public class PaisService {

    private final PaisRepository paisRepository;

    /**
     * Constructor del servicio PaisService.
     *
     * @param paisRepository El repositorio PaisRepository que proporciona
     * métodos para acceder a los datos de los países.
     */
    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    /**
     * Método para obtener todos los países.
     *
     * @return Una lista de todos los países
     */
    public List<Pais> obtenerTodos() {
        return paisRepository.findAll();
    }
}
