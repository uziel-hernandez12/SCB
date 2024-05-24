/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bd2.SCB.repository;

import com.bd2.SCB.domain.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repositorio para la entidad Autor, que maneja operaciones de base de datos relacionadas con autores.
 * Extiende JpaRepository para obtener acceso a métodos CRUD estándar proporcionados por Spring Data JPA.
 * 
 * @author Admin
 */
public interface AutorRepository extends JpaRepository<Autor, Integer> {

    /**
     * Método para ejecutar una consulta personalizada que busca autores por país.
     * Utiliza una consulta JPQL (Java Persistence Query Language) definida en la anotación @Query.
     * 
     * @param paisId El ID del país por el que buscar autores
     * @return Una lista de autores que pertenecen al país especificado
     */
    @Query("SELECT a FROM Autor a WHERE a.pais.id = ?1")
    List<Autor> ejecutarConsulta(int paisId);

}
