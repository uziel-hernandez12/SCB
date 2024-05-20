/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.service;

import com.bd2.SCB.domain.Docente;
import com.bd2.SCB.repository.DocenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Servicio que proporciona operaciones relacionadas con la gestión de docentes.
 * Esta clase actúa como una capa intermedia entre los controladores y el
 * repositorio de docentes.
 *
 * @author Admin
 */
@Service
public class DocenteService {

    private final DocenteRepository docenteRepository; // Repositorio de docentes

    // Constructor que recibe el repositorio de docentes
    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    /**
     * Busca y devuelve todos los docentes disponibles en la base de datos.
     *
     * @return Lista de todos los docentes
     */
    public List<Docente> buscarTodos() {
        return docenteRepository.findAll();
    }

    /**
     * Guarda un docente en la base de datos.
     *
     * @param docente El docente a guardar
     * @return El docente guardado
     */
    public Docente guardar(Docente docente) {
        return docenteRepository.save(docente);
    }

    /**
     * Obtiene todos los docentes de la base de datos.
     *
     * @return Lista de todos los docentes
     */
    public List<Docente> obtenerTodos() {
        return docenteRepository.findAll();
    }

    /**
     * Busca un docente por su identificación (matrícula).
     *
     * @param docMatricula La matrícula del docente a buscar
     * @return El docente encontrado, si existe
     */
    public Optional<Docente> buscarPorId(String docMatricula) {
        return docenteRepository.findById(docMatricula);
    }

    /**
     * Obtiene los docentes asociados a un departamento específico.
     *
     * @param id El ID del departamento
     * @return Lista de docentes asociados al departamento
     */
    public List<Docente> obtenerPorDepartamento(int id) {
        return docenteRepository.obtenerPorDepartamento(id);
    }

    /**
     * Elimina un docente de la base de datos por su matrícula.
     *
     * @param matricula La matrícula del docente a eliminar
     */
    public void eliminarPorMatricula(String matricula) {
        docenteRepository.eliminar_docente(matricula);
    }

    /**
     * Busca docentes cuyo nombre coincida parcial o totalmente con una consulta
     * dada.
     *
     * @param consulta La consulta de búsqueda
     * @return Lista de docentes que coinciden con la consulta
     */
    public List<Docente> buscar(String consulta) {
        return docenteRepository.buscar(consulta);
    }
}
