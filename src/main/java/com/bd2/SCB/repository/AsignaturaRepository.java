/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bd2.SCB.repository;

import com.bd2.SCB.domain.Asignatura;
import com.bd2.SCB.domain.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// Extiende JpaRepository para obtener operaciones CRUD básicas
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {

    // Consulta personalizada para obtener asignaturas por programa académico
    @Query("from Asignatura a where a.programaAcademico.proId = ?1 order by a.asigClave ")
    List<Asignatura> obtenerPorPrograma(int proId);

    // Consulta personalizada para obtener asignaturas por docente
    @Query("from Asignatura a where a.docente.docMatricula = ?1 order by a.asigClave ")
    List<Asignatura> obtenerPorDocente(String matricula);

    // Consulta personalizada para buscar asignaturas por su título
    @Query("from Asignatura a where a.asigTitulo like %?1%")
    List<Asignatura> buscar(String consulta);
}