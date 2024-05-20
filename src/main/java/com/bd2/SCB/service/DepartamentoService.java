/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.service;

import com.bd2.SCB.domain.Departamento;
import com.bd2.SCB.repository.DepartamentoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Servicio que proporciona operaciones relacionadas con la gestión de departamentos.
 * Esta clase actúa como una capa intermedia entre los controladores y el repositorio de departamentos.
 * 
 * @author Admin
 */
@Service
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository; // Repositorio de departamentos
    
    // Constructor que recibe el repositorio de departamentos
    public DepartamentoService (DepartamentoRepository departamentoRepository){
        this.departamentoRepository = departamentoRepository;
    }

    /**
     * Obtiene todos los departamentos de la base de datos.
     * 
     * @return Lista de todos los departamentos
     */
    public List<Departamento> obtenerTodos() {
        return departamentoRepository.findAll();
    }
}
