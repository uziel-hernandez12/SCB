/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.controller;

import com.bd2.SCB.domain.Autor;
import com.bd2.SCB.domain.Libro;
import com.bd2.SCB.domain.Pais;
import com.bd2.SCB.service.AutorService;
import com.bd2.SCB.service.LibroService;
import com.bd2.SCB.service.PaisService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador para manejar las consultas relacionadas con libros, autores y
 * países.
 *
 * @author Admin
 */
@Controller
public class ConsultasController {

    private final LibroService libroService;
    private final PaisService paisService;
    private final AutorService autorService;

    /**
     * Constructor del controlador.
     *
     * @param libroService Servicio para libros
     * @param paisService Servicio para países
     * @param autorService Servicio para autores
     */
    public ConsultasController(LibroService libroService, PaisService paisService,
            AutorService autorService) {
        this.libroService = libroService;
        this.paisService = paisService;
        this.autorService = autorService;
    }

    /**
     * Maneja la solicitud para mostrar la página de consultas.
     *
     * @param model El modelo para pasar datos a la vista
     * @return La vista de consultas
     */
    @RequestMapping("/consultas")
    public String mostrarConsultas(Model model) {
        // Crear un objeto de Libro vacío para fines de demostración
        Libro libroAntiguo = new Libro();

        // Obtener la lista de países desde el servicio
        List<Pais> paises = paisService.obtenerTodos();

        // Agregar objetos al modelo para usar en la vista
        model.addAttribute("libroAntiguo", libroAntiguo);
        model.addAttribute("paises", paises);

        // Establecer un país seleccionado por defecto (por ejemplo, el primer país)
        model.addAttribute("paisSeleccionado", 1);

        // Devolver la vista de consultas
        return "consultas";
    }

    /**
     * Maneja la solicitud para ejecutar las consultas.
     *
     * @param model El modelo para pasar datos a la vista
     * @param id El id del país seleccionado
     * @return La vista de consultas
     */
    @RequestMapping("/consultas/ejecutarConsultas")
    public String ejecutarConsultas(Model model, String id) {
        // Obtener la lista de libros antiguos desde el servicio
        List<Libro> librosAntiguos = libroService.buscarLibroAntiguo();

        // Obtener la lista de países desde el servicio
        List<Pais> paises = paisService.obtenerTodos();

        // Obtener la lista de libros recientes desde el servicio
        List<Libro> librosRecientes = libroService.buscarLibrosRecientes();

        // Convertir el id del país seleccionado a un entero
        int paisId = Integer.parseInt(id);

        // Obtener la lista de autores para el país seleccionado desde el servicio
        List<Autor> autores = autorService.ejecutarConsulta(paisId);

        // Agregar objetos al modelo para usar en la vista
        model.addAttribute("librosAntiguos", librosAntiguos);
        model.addAttribute("paises", paises);
        model.addAttribute("autores", autores);
        model.addAttribute("librosRecientes", librosRecientes);

        // Mantener el país seleccionado después de ejecutar la consulta
        model.addAttribute("paisSeleccionado", id);

        // Devolver la vista de consultas
        return "consultas";
    }
}
