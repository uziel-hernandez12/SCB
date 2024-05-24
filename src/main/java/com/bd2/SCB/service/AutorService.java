/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.service;

import com.bd2.SCB.domain.Autor;
import com.bd2.SCB.repository.AutorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Servicio para manejar operaciones relacionadas con autores.
 * Contiene lógica de negocio y se comunica con el repositorio AutorRepository para acceder a la capa de persistencia.
 * 
 * @author Admin
 */
@Service
public class AutorService {
    private final AutorRepository autorRepository;

    /**
     * Constructor del servicio AutorService.
     * 
     * @param autorRepository El repositorio AutorRepository que proporciona métodos para acceder a los datos de los autores.
     */
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    /**
     * Método para ejecutar una consulta que busca autores por país.
     * 
     * @param paisId El ID del país por el que buscar autores
     * @return Una lista de autores que pertenecen al país especificado
     */
    public List<Autor> ejecutarConsulta(int paisId) {
        return autorRepository.ejecutarConsulta(paisId);
    }
}
