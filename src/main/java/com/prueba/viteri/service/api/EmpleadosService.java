package com.prueba.viteri.service.api;

import com.prueba.viteri.models.Empleado;

import java.util.List;

public interface EmpleadosService {
    public List<Empleado> listarEmpleados();

    public Empleado guardarEmpleado(Empleado empleado);

    public Empleado empleadorPorId(Long id);

    public void eliminarEmpleado(Long id);
}
