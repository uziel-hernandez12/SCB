/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.service;

import com.bd2.SCB.repository.EditorialRepository;
import org.springframework.stereotype.Service;

/**
 * Servicio para manejar operaciones relacionadas con editoriales.
 * Contiene lógica de negocio y se comunica con el repositorio EditorialRepository para acceder a la capa de persistencia.
 * 
 * @author Admin
 */
@Service
public class EditorialService {
    private final EditorialRepository editorialRepository;

    /**
     * Constructor del servicio EditorialService.
     * 
     * @param editorialRepository El repositorio EditorialRepository que proporciona métodos para acceder a los datos de las editoriales.
     */
    public EditorialService(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }
    
    // Aquí puedes agregar métodos adicionales para implementar la lógica de negocio relacionada con las editoriales

}
