/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bd2.SCB.controller;

import com.bd2.SCB.domain.Departamento;
import com.bd2.SCB.domain.Docente;
import com.bd2.SCB.service.DepartamentoService;
import com.bd2.SCB.service.DocenteService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador para la gestión de docentes (ABM: Alta, Baja, Modificación).
 * Este controlador maneja las operaciones relacionadas con la gestión de docentes,
 * como agregar, editar, eliminar y mostrar docentes.
 *
 * Autor: Admin
 */
@Controller
public class DocenteAbmController {

    // Campos necesarios para los servicios de Departamento y Docente
    private final DepartamentoService departamentoService;
    private final DocenteService docenteService;

    // Constructor que inyecta los servicios necesarios
    public DocenteAbmController(DepartamentoService departamentoService, DocenteService docenteService) {
        this.departamentoService = departamentoService;
        this.docenteService = docenteService;
    }

    /**
     * Muestra el form para agregar una asignatura
     *
     * @param model
     * @return
     */
    @RequestMapping("/docentes/agregar")
    public String mostrarFormDocente(Model model) {
        //obtengo todos los departamentos de la bd
        List<Departamento> departamentos = departamentoService.obtenerTodos();

        //manda los departamentos al modelo de la pagina
        model.addAttribute("departamentos", departamentos);

        //manda el objeto docente al formulario
        model.addAttribute("docente", new Docente());

        //Retoruna la pagina que contiene el formulario
        return "agregar-docente.html";
    }

    /**
     * Recibe el docente que envia el formulario y lo guarda en la base de bd
     *
     * @param docente
     * @return
     */
    @PostMapping("/docentes/guardar")
    public String guardarDocente(Docente docente) {
        if (docente.getDocFoto().isEmpty()) {
            docente.setDocFoto("https://objetivoligar.com/wp-content/uploads/2017/03/blank-profile-picture-973460_1280.jpg");
        }
        docenteService.guardar(docente);
        return "redirect:/docentes/agregar";
    }

    /**
     * Muestra la vista del docente
     *
     * @param docMatricula
     * @param model
     * @return
     */
    @RequestMapping("/docentes/docentePorId")
    public String mostrarDocente(String docMatricula, Model model) {
        String mensajeError = "";

        try {
            //busca el docente por su matricula
            Optional<Docente> opcionalDocente = docenteService.buscarPorId(docMatricula);

            if (opcionalDocente.isPresent()) {
                // Si el docente se encuentra, lo agrega al modelo y muestra la vista del docente
                Docente docente = opcionalDocente.get();
                model.addAttribute("docente", docente);
                return "mostrar-docente.html";
            } else {
                // Si el videojuego no se encuentra, muestra una página de error con el mensaje correspondiente
                mensajeError = "Docente no encontrado";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            }
        } catch (NumberFormatException e) {
            mensajeError = "Mátricula del docente inválida";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }

    @RequestMapping("/docentes/editar")
    public String editarDocente(String docMatricula, Model model) {
        String mensajeError = "";

        try {
            //busca el docente por su matricula
            Optional<Docente> opcionalDocente = docenteService.buscarPorId(docMatricula);

            if (opcionalDocente.isPresent()) {
                // Si el docente se encuentra, lo agrega al modelo y muestra la vista del docente
                Docente docente = opcionalDocente.get();

                //obtengo los departamentos
                List<Departamento> departamentos = departamentoService.obtenerTodos();

                //añado los parametros al model
                model.addAttribute("docente", docente);
                model.addAttribute("departamentos", departamentos);

                return "editar-docente.html";
            } else {
                // Si el videojuego no se encuentra, muestra una página de error con el mensaje correspondiente
                mensajeError = "Docente no encontrado";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            }
        } catch (NumberFormatException e) {
            mensajeError = "Mátricula del docente inválida";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }
    }

    /**
     * Guarda los cambios hechos a un docente
     *
     * @param docente
     * @return
     */
    @PostMapping("/docentes/guardarCambios")
    public String guardarCambios(Docente docente) {
        if (docente.getDocFoto().isEmpty()) {
            docente.setDocFoto("https://objetivoligar.com/wp-content/uploads/2017/03/blank-profile-picture-973460_1280.jpg");
        }
        docenteService.guardar(docente);
        return "redirect:/docentes/listado";
    }

    /**
     * Muestra la pagina de confirmacion de eliminar
     *
     */
    @RequestMapping("/docentes/eliminar")
    public String mostrarConfirmacion(@RequestParam("docMatricula") String matricula, Model model) {
        model.addAttribute("docMatricula", matricula);

        return "eliminar-docente.html";
    }

    @RequestMapping("/docentes/aceptar-eliminacion")
    public String eliminarDocente(@RequestParam("matricula") String matricula, Model model) {
        try {
            docenteService.eliminarPorMatricula(matricula);
        } catch (Exception e) {
            model.addAttribute("mensajeError", "El docente aun tiene asignaturas asignadas");
            return "error"; // La vista que muestra el error
        }

        return "redirect:/docentes/listado";
    }
}//fin de la clase
