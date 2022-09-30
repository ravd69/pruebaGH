package com.prueba.viteri.controller;

import com.prueba.viteri.models.Empleado;
import com.prueba.viteri.service.api.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadosController {

    @Autowired
    private EmpleadosService empleadosService;

    @GetMapping({"/listarEmpleados", "/"})
    public String listarEmpleados(Model modeloEmpleado) {
        modeloEmpleado.addAttribute("empleados", empleadosService.listarEmpleados());
        return "listarEmpleados";
    }

    @GetMapping("/vistaFormulario")
    public String vistaFormularioNuevoEmpleado(Model modeloEmpleado) {
        Empleado empleado = new Empleado();
        modeloEmpleado.addAttribute("vistaFormulario", empleado);
        return "vistaFormulario";
    }

    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado){
        empleadosService.guardarEmpleado(empleado);
        return "redirect:/listarEmpleados";
    }

    @GetMapping("/obtenerEmpleadoPorId/{id}")
    public String vistaEditarEmpleado(@PathVariable Long id, Model modeloEmpleado){
        modeloEmpleado.addAttribute("empleado", empleadosService.empleadorPorId(id));
        return "vistaEditarEmpleado";
    }

    @PostMapping("/editarEmpleado/{id}")
    public String editarEmpleado(@PathVariable Long id, @ModelAttribute("empleado") Empleado empleado){
        Empleado empleadoExistente = empleadosService.empleadorPorId(id);
        empleadoExistente.setActivo(empleado.isActivo());
        empleadoExistente.setApellido(empleado.getApellido());
        empleadoExistente.setEmail(empleado.getEmail());
        empleadoExistente.setEdad(empleado.getEdad());
        empleadoExistente.setCargo(empleado.getCargo());
        empleadoExistente.setNombre(empleado.getNombre());
        empleadosService.guardarEmpleado(empleadoExistente);
        return "redirect:/listarEmpleados";
    }

    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        empleadosService.eliminarEmpleado(id);
        return "redirect:/listarEmpleados";
    }


}
