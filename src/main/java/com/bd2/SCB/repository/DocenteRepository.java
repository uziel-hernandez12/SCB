/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bd2.SCB.repository;


import com.bd2.SCB.domain.Docente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

// Extiende JpaRepository para obtener operaciones CRUD básicas
public interface DocenteRepository extends JpaRepository<Docente, String> {

    // Consulta personalizada para obtener docentes por departamento
    @Query("from Docente d where d.departamento.dept_id = ?1 order by d.docMatricula ")
    List<Docente> obtenerPorDepartamento(int id);
    
    // Definición de procedimiento almacenado para eliminar un docente
    @Procedure(name = "eliminar_docente")
    void eliminar_docente(@Param("matricula") String matricula);

    // Consulta personalizada para buscar docentes por nombre
    @Query("from Docente d where d.docNombre like %?1%")
    List<Docente> buscar(String consulta);
}