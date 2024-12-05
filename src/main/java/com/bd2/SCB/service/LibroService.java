/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.service;

import com.bd2.SCB.domain.Libro;
import com.bd2.SCB.repository.LibroRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Servicio para manejar operaciones relacionadas con libros.
 * Contiene lógica de negocio y se comunica con el repositorio LibroRepository para acceder a la capa de persistencia.
 * 
 * @author Admin
 */
@Service
public class LibroService {
    private final LibroRepository libroRepository;

    /**
     * Constructor del servicio LibroService.
     * 
     * @param libroRepository El repositorio LibroRepository que proporciona métodos para acceder a los datos de los libros.
     */
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    /**
     * Método para buscar libros antiguos.
     * 
     * @return Una lista de libros antiguos
     */
    public List<Libro> buscarLibroAntiguo() {
        return libroRepository.buscarLibrosAntiguos();
    }

    /**
     * Método para buscar libros recientes.
     * 
     * @return Una lista de libros recientes
     */
    public List<Libro> buscarLibrosRecientes() {
        return libroRepository.buscarLibrosRecientes();
    }
}
