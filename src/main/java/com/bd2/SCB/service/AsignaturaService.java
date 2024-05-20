/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.service;

import com.bd2.SCB.domain.Asignatura;
import com.bd2.SCB.repository.AsignaturaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Servicio que proporciona operaciones relacionadas con la gestión de asignaturas.
 * Esta clase actúa como una capa intermedia entre los controladores y el repositorio de asignaturas.
 * 
 * @author Admin
 */
@Service
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository; // Repositorio de asignaturas

    // Constructor que recibe el repositorio de asignaturas
    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    /**
     * Guarda una asignatura en la base de datos.
     * 
     * @param asignatura La asignatura a guardar
     * @return La asignatura guardada
     */
    public Asignatura guardar(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    /**
     * Obtiene todas las asignaturas de la base de datos.
     * 
     * @return Lista de todas las asignaturas
     */
    public List<Asignatura> obtenerTodas() {
        return asignaturaRepository.findAll();
    }

    /**
     * Obtiene todas las asignaturas asociadas a un programa académico específico.
     * 
     * @param proId El ID del programa académico
     * @return Lista de asignaturas asociadas al programa académico
     */
    public List<Asignatura> obtenerPorPrograma(int proId) {
        return asignaturaRepository.obtenerPorPrograma(proId);
    }

    /**
     * Obtiene todas las asignaturas asociadas a un docente específico.
     * 
     * @param matricula La matrícula del docente
     * @return Lista de asignaturas asociadas al docente
     */
    public List<Asignatura> obtenerPorDocente(String matricula) {
        return asignaturaRepository.obtenerPorDocente(matricula);
    }

    /**
     * Busca una asignatura por su clave (ID).
     * 
     * @param id El ID de la asignatura a buscar
     * @return La asignatura encontrada (si existe)
     */
    public Optional<Asignatura> buscarPorClave(int id) {
        return asignaturaRepository.findById(id);
    }

    /**
     * Guarda los cambios realizados en una asignatura en la base de datos.
     * 
     * @param asignatura La asignatura con los cambios realizados
     * @return La asignatura con los cambios guardados
     */
    public Asignatura guardarCambios(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    /**
     * Elimina una asignatura de la base de datos por su ID.
     * 
     * @param idAsig El ID de la asignatura a eliminar
     */
    public void eliminarPorId(int idAsig) {
        asignaturaRepository.deleteById(idAsig);
    }

    /**
     * Busca asignaturas que coincidan con una consulta dada.
     * 
     * @param consulta La consulta a buscar
     * @return Lista de asignaturas que coinciden con la consulta
     */
    public List<Asignatura> buscar(String consulta) {
        return asignaturaRepository.buscar(consulta);
    }

}
