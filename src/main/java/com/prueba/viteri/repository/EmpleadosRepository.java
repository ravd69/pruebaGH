package com.prueba.viteri.repository;

import com.prueba.viteri.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpleadosRepository extends JpaRepository<Empleado, Long> {
}
