/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.controller;

import com.bd2.SCB.domain.Asignatura;
import com.bd2.SCB.domain.Docente;
import com.bd2.SCB.domain.ProgramaAcademico;
import com.bd2.SCB.service.AsignaturaService;
import com.bd2.SCB.service.DocenteService;
import com.bd2.SCB.service.ProgramaAcademicoService;
import java.util.List;
import java.util.Optional;
import org.hibernate.query.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador para la gestión de asignaturas (ABM: Alta, Baja, Modificación).
 * Este controlador maneja las operaciones relacionadas con la gestión de asignaturas, 
 * como agregar, editar, eliminar y mostrar asignaturas.
 * 
 * Autor: Admin
 */
@Controller
public class AsignaturaAbmController {

    // Servicios necesarios para obtener datos de la base de datos
    private final DocenteService docenteService;
    private final ProgramaAcademicoService academicoService;
    private final AsignaturaService asignaturaService;

    // Constructor que inyecta los servicios necesarios
    public AsignaturaAbmController(DocenteService docenteService, ProgramaAcademicoService academicoService,
            AsignaturaService asignaturaService) {
        this.docenteService = docenteService;
        this.academicoService = academicoService;
        this.asignaturaService = asignaturaService;
    }

    /**
     * Método que muestra el formulario para agregar una asignatura.
     * 
     * @param model El modelo para agregar atributos a la vista.
     * @return La vista para agregar una asignatura.
     */
    @RequestMapping("/asignaturas/agregar")
    public String mostrarFormAgregar(Model model) {
        // Obtener todos los docentes de la base de datos
        List<Docente> docentes = docenteService.buscarTodos();

        // Obtener todos los programas académicos de la base de datos
        List<ProgramaAcademico> programasAcademicos = academicoService.buscarTodos();

        // Agregar los docentes y programas académicos al modelo
        model.addAttribute("docentes", docentes);
        model.addAttribute("programasAcademicos", programasAcademicos);

        // Agregar una nueva instancia de Asignatura al modelo para el formulario
        model.addAttribute("asignatura", new Asignatura());

        // Devolver la vista para agregar una asignatura
        return "agregar-asig.html";
    }

    /**
     * Método que procesa el formulario para guardar una asignatura.
     * 
     * @param asignatura La asignatura a guardar.
     * @return Redirige al formulario para agregar una asignatura nuevamente.
     */
    @PostMapping("/asignaturas/guardar")
    public String guardar(Asignatura asignatura) {
        // Guardar la asignatura en la base de datos
        asignaturaService.guardar(asignatura);

        // Redirigir al formulario para agregar una asignatura nuevamente
        return "redirect:/asignaturas/agregar";
    }

    /**
     * Método que muestra el formulario para editar una asignatura.
     * 
     * @param asigClave La clave de la asignatura a editar.
     * @param model El modelo para agregar atributos a la vista.
     * @return La vista para editar una asignatura.
     */
    @RequestMapping("/asignaturas/editar")
    public String mostrarFormEditar(@RequestParam("id") String asigClave, Model model) {
        // Mensaje de error por defecto
        String mensajeError = "";

        try {
            // Convertir la clave de la asignatura a un entero
            int id = Integer.parseInt(asigClave);

            // Buscar la asignatura por su clave en la base de datos
            Optional<Asignatura> opcionalAsignatura = asignaturaService.buscarPorClave(id);

            if (opcionalAsignatura.isPresent()) {
                // Si la asignatura se encuentra, agregarla al modelo y mostrar la vista de edición
                Asignatura asignatura = opcionalAsignatura.get();
                model.addAttribute("asignatura", asignatura);
                model.addAttribute("docentes", docenteService.buscarTodos());
                model.addAttribute("programasAcademicos", academicoService.buscarTodos());
                return "editar-asignatura.html";
            } else {
                // Si la asignatura no se encuentra, mostrar una página de error con el mensaje correspondiente
                mensajeError = "Asignatura no encontrada";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            }
        } catch (NumberFormatException e) {
            // Si la clave de la asignatura no es un número válido, mostrar una página de error con el mensaje correspondiente
            mensajeError = "Clave de la asignatura inválida";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }

    /**
     * Método que procesa el formulario para guardar los cambios realizados en una asignatura.
     * 
     * @param asignatura La asignatura con los cambios realizados.
     * @return Redirige al listado de asignaturas.
     */
    @PostMapping("/asignaturas/guardarCambios")
    public String guardarCambios(Asignatura asignatura) {
        // Guardar los cambios realizados en la asignatura en la base de datos
        asignaturaService.guardarCambios(asignatura);

        // Redirigir al listado de asignaturas
        return "redirect:/asignaturas/listado";
    }

    /**
     * Método que muestra la página de confirmación para eliminar una asignatura.
     * 
     * @param asigClave La clave de la asignatura a eliminar.
     * @param model El modelo para agregar atributos a la vista.
     * @return La vista para confirmar la eliminación de una asignatura.
     */
    @RequestMapping("asignaturas/eliminar")
    public String mostrarConfirmacion(@RequestParam("id") String asigClave, Model model) {
        // Agregar la clave de la asignatura al modelo
        model.addAttribute("id", asigClave);

        // Devolver la vista de confirmación de eliminación de asignatura
        return "eliminar-asignatura.html";
    }

    /**
     * Método que procesa la eliminación de una asignatura.
     * 
     * @param asigClave La clave de la asignatura a eliminar.
     * @return Redirige al listado de asignaturas.
     */
    @RequestMapping("/asignaturas/aceptar-eliminacion")
    public String eliminar(@RequestParam("id") String asigClave) {
        // Convertir la clave de la asignatura a un entero
        int idAsig = Integer.parseInt(asigClave);

        // Eliminar la asignatura de la base de datos
        asignaturaService.eliminarPorId(idAsig);

        // Redirigir al listado de asignaturas
        return "redirect:/asignaturas/listado";
    }
}
