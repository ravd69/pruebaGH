package com.prueba.viteri.service.impl;

import com.prueba.viteri.models.Empleado;
import com.prueba.viteri.repository.EmpleadosRepository;
import com.prueba.viteri.service.api.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadosService {

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadosRepository.findAll();
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadosRepository.save(empleado);
    }

    @Override
    public Empleado empleadorPorId(Long id) {
        return empleadosRepository.findById(id).get();
    }

    @Override
    public void eliminarEmpleado(Long id) {
        empleadosRepository.deleteById(id);
    }
}
