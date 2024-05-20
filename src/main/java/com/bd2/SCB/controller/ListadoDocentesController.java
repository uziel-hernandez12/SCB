/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.controller;

import com.bd2.SCB.domain.Docente;
import com.bd2.SCB.service.DepartamentoService;
import com.bd2.SCB.service.DocenteService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador para manejar las operaciones relacionadas con el listado de
 * docentes. Esta clase proporciona métodos para buscar docentes, listar todos
 * los docentes y mostrar docentes por departamento.
 *
 * El controlador utiliza servicios de DepartamentoService y DocenteService para
 * realizar operaciones en la base de datos.
 *
 * @author Admin
 */
@Controller
public class ListadoDocentesController {

    // Campos
    private final DepartamentoService departamentoService; // Servicio para operaciones relacionadas con departamentos
    private final DocenteService docenteService; // Servicio para operaciones relacionadas con docentes

    /**
     * Constructor de la clase ListadoDocentesController.
     *
     * @param departamentoService Servicio para operaciones relacionadas con
     * departamentos.
     * @param docenteService Servicio para operaciones relacionadas con
     * docentes.
     */
    public ListadoDocentesController(DepartamentoService departamentoService, DocenteService docenteService) {
        this.departamentoService = departamentoService;
        this.docenteService = docenteService;
    }

    /**
     * Método para buscar docentes por su nombre.
     *
     * @param consulta Consulta para buscar docentes por nombre.
     * @param model El modelo para agregar atributos a la vista.
     * @return La vista del listado de docentes.
     */
    @RequestMapping("docentes/buscar")
    public String buscar(@RequestParam("q") String consulta, Model model) {
        // Buscar docentes por nombre
        List<Docente> docentes = docenteService.buscar(consulta);

        // Agregar resultados de la búsqueda al modelo
        model.addAttribute("docentes", docentes);
        model.addAttribute("consulta", consulta);

        // Retornar la vista del listado de docentes
        return "listado-docentes.html";
    }

    /**
     * Método para listar todos los docentes.
     *
     * @param model El modelo para agregar atributos a la vista.
     * @param pagina El número de página actual.
     * @return La vista del listado de docentes.
     */
    @RequestMapping("docentes/listado")
    public String listadoDocentes(Model model, @RequestParam(defaultValue = "0") int pagina) {
        int tamañoDeDocentes = 4;

        // Obtener todos los docentes de la base de datos
        List<Docente> docentes = docenteService.obtenerTodos();

        // Calcular el número total de páginas
        int totalPaginas = (int) Math.ceil((double) docentes.size() / tamañoDeDocentes);

        // Validar la página actual para asegurar que esté dentro de los límites
        if (pagina >= totalPaginas) {
            pagina = totalPaginas - 1;
        }

        // Calcular los índices de inicio y fin para la paginación
        int inicioIndice = pagina * tamañoDeDocentes;
        int finalIndice = Math.min(inicioIndice + tamañoDeDocentes, docentes.size());

        // Obtener los docentes para la página actual
        List<Docente> docentesPaginados = docentes.subList(inicioIndice, finalIndice);

        // Agregar los docentes paginados y la información de paginación al modelo
        model.addAttribute("docentes", docentesPaginados);
        model.addAttribute("totalPaginas", totalPaginas);
        model.addAttribute("currentPage", pagina);

        // Retornar la vista del listado de docentes
        return "listado-docentes.html";
    }

    /**
     * Método para mostrar los docentes por departamento.
     *
     * @param model El modelo para agregar atributos a la vista.
     * @param id El identificador del departamento.
     * @return La vista del listado de docentes.
     */
    @RequestMapping("/docentes/listado/departamento")
    public String mostrarPorDepartamento(Model model, int id) {
        // Obtener los docentes por departamento
        List<Docente> docentes = docenteService.obtenerPorDepartamento(id);

        // Agregar los docentes por departamento y el identificador del departamento al modelo
        model.addAttribute("docentes", docentes);
        model.addAttribute("dept_id", id);

        // Retornar la vista del listado de docentes
        return "listado-docentes.html";
    }
}
