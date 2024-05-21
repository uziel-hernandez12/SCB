/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.controller;

import com.bd2.SCB.domain.Asignatura;
import com.bd2.SCB.service.AsignaturaService;
import com.bd2.SCB.service.DocenteService;
import com.bd2.SCB.service.ProgramaAcademicoService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador para el listado y búsqueda de asignaturas. Este controlador
 * maneja las operaciones relacionadas con el listado y búsqueda de asignaturas,
 * así como la paginación de los resultados.
 *
 * Autor: Admin
 */
@Controller

public class ListadoAsignaturasController {

    //variable para obtener datos de la bd
    private final DocenteService docenteService;
    private final ProgramaAcademicoService academicoService;
    private final AsignaturaService asignaturaService;

    //constructor
    public ListadoAsignaturasController(DocenteService docenteService, ProgramaAcademicoService academicoService,
            AsignaturaService asignaturaService) {
        this.docenteService = docenteService;
        this.academicoService = academicoService;
        this.asignaturaService = asignaturaService;
    }

    /**
     * Permite buscar asignaturas por su nombre
     *
     * @param model
     * @param consulta
     * @return
     */
    @RequestMapping("asignaturas/buscar")
    public String buscar(Model model, @RequestParam("q") String consulta,
            @RequestParam(defaultValue = "0") int pagina) {
        // Tamaño de las asignaturas por página
        int tamañoDeAsignaturas = 8;

        List<Asignatura> asignaturas = asignaturaService.buscar(consulta);

        // Calcular el número total de páginas
        int totalPaginas = (int) Math.ceil((double) asignaturas.size() / tamañoDeAsignaturas);

        // Validar la página actual para asegurar que esté dentro de los límites
        if (pagina >= totalPaginas) {
            pagina = totalPaginas - 1;
        }

        // Calcular los índices de inicio y fin para la paginación
        int inicioIndice = pagina * tamañoDeAsignaturas;
        int finalIndice = Math.min(inicioIndice + tamañoDeAsignaturas, asignaturas.size());

        // Obtener las asignaturas para la página actual
        List<Asignatura> asignaturasPaginadas = asignaturas.subList(inicioIndice, finalIndice);

        // Agregar las asignaturas paginadas y la información de paginación al modelo
        model.addAttribute("asignaturas", asignaturasPaginadas);
        model.addAttribute("totalPaginas", totalPaginas);
        model.addAttribute("currentPage", pagina);
        model.addAttribute("consulta", consulta);
        return "listado.html";
    }

    /**
     * Muestra el listado de asignaturas en la base de datos con paginación.
     *
     * @param model El modelo para agregar atributos a la vista.
     * @param pagina El número de página actual.
     * @return La vista del listado de asignaturas.
     */
    @RequestMapping("/asignaturas/listado")
    public String mostrarListado(Model model, @RequestParam(defaultValue = "0") int pagina) {
        // Tamaño de las asignaturas por página
        int tamañoDeAsignaturas = 8;

        // Obtener todas las asignaturas de la base de datos
        List<Asignatura> asignaturas = asignaturaService.obtenerTodas();

        // Calcular el número total de páginas
        int totalPaginas = (int) Math.ceil((double) asignaturas.size() / tamañoDeAsignaturas);

        // Validar la página actual para asegurar que esté dentro de los límites
        if (pagina >= totalPaginas) {
            pagina = totalPaginas - 1;
        }

        // Calcular los índices de inicio y fin para la paginación
        int inicioIndice = pagina * tamañoDeAsignaturas;
        int finalIndice = Math.min(inicioIndice + tamañoDeAsignaturas, asignaturas.size());

        // Obtener las asignaturas para la página actual
        List<Asignatura> asignaturasPaginadas = asignaturas.subList(inicioIndice, finalIndice);

        // Agregar las asignaturas paginadas y la información de paginación al modelo
        model.addAttribute("asignaturas", asignaturasPaginadas);
        model.addAttribute("totalPaginas", totalPaginas);
        model.addAttribute("currentPage", pagina);

        // Retornar la vista del listado de asignaturas
        return "listado";
    }

    /**
     * Muestra el listado de asignaturas por programa académico con paginación.
     *
     * @param proId El ID del programa académico.
     * @param model El modelo para agregar atributos a la vista.
     * @param pagina El número de página actual.
     * @return La vista del listado de asignaturas por programa académico.
     */
    @RequestMapping("/asignaturas/listado/programaAcademico")
    public String mostrarListadoPorPrograma(int proId, Model model,
            @RequestParam(defaultValue = "0") int pagina) {

        // Tamaño de las asignaturas por página
        int tamañoDeAsignaturas = 8;

        // Obtener las asignaturas por programa académico
        List<Asignatura> asignaturasDePrograma = asignaturaService.obtenerPorPrograma(proId);

        // Calcular el número total de páginas
        int totalPaginas = (int) Math.ceil((double) asignaturasDePrograma.size() / tamañoDeAsignaturas);

        // Validar la página actual para asegurar que esté dentro de los límites
        if (pagina >= totalPaginas) {
            pagina = totalPaginas - 1;
        }

        // Calcular los índices de inicio y fin para la paginación
        int inicioIndice = pagina * tamañoDeAsignaturas;
        int finalIndice = Math.min(inicioIndice + tamañoDeAsignaturas, asignaturasDePrograma.size());

        // Obtener las asignaturas para la página actual
        List<Asignatura> asignaturasPaginadas = asignaturasDePrograma.subList(inicioIndice, finalIndice);

        // Agregar las asignaturas paginadas y la información de paginación al modelo
        model.addAttribute("asignaturas", asignaturasPaginadas);
        model.addAttribute("totalPaginas", totalPaginas);
        model.addAttribute("currentPage", pagina);

        // Retornar la vista del listado de asignaturas por programa académico
        return "listado";
    }

    /**
     * Muestra el listado de asignaturas por docente con paginación.
     *
     * @param matricula La matrícula del docente.
     * @param model El modelo para agregar atributos a la vista.
     * @param pagina El número de página actual.
     * @return La vista del listado de asignaturas por docente.
     */
    @RequestMapping("/asignaturas/listado/docente")
    public String mostrarListadoPorDocente(String matricula, Model model,
            @RequestParam(defaultValue = "0") int pagina) {

        // Tamaño de las asignaturas por página
        int tamañoDeAsignaturas = 8;

        // Obtener las asignaturas por docente
        List<Asignatura> asignaturasDeDocente = asignaturaService.obtenerPorDocente(matricula);

        // Calcular el número total de páginas
        int totalPaginas = (int) Math.ceil((double) asignaturasDeDocente.size() / tamañoDeAsignaturas);

        // Validar la página actual para asegurar que esté dentro de los límites
        if (pagina >= totalPaginas) {
            pagina = totalPaginas - 1;
        }

        // Calcular los índices de inicio y fin para la paginación
        int inicioIndice = pagina * tamañoDeAsignaturas;
        int finalIndice = Math.min(inicioIndice + tamañoDeAsignaturas, asignaturasDeDocente.size());

        // Obtener las asignaturas para la página actual
        List<Asignatura> asignaturasPaginadas = asignaturasDeDocente.subList(inicioIndice, finalIndice);

        // Agregar las asignaturas paginadas y la información de paginación al modelo
        model.addAttribute("asignaturas", asignaturasPaginadas);
        model.addAttribute("totalPaginas", totalPaginas);
        model.addAttribute("currentPage", pagina);

        // Retornar la vista del listado de asignaturas por docente
        return "listado.html";
    }

}
