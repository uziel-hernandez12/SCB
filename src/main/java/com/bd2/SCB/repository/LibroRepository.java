/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bd2.SCB.repository;

import com.bd2.SCB.domain.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface LibroRepository extends JpaRepository<Libro, String> {

    @Query("SELECT l FROM Libro l WHERE l.lib_año_edicion = (SELECT MIN(l2.lib_año_edicion) FROM Libro l2)")
    List<Libro> buscarLibrosAntiguos();

    @Query("SELECT l FROM Libro l WHERE l.lib_año_edicion = (SELECT MAX(l2.lib_año_edicion) FROM Libro l2)")
    List<Libro> buscarLibrosRecientes();

}
