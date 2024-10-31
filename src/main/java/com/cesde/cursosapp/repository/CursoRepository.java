package com.cesde.cursosapp.repository;

import com.cesde.cursosapp.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
public interface CursoRepository extends JpaRepository<Curso, Long>{
    List<Curso> findByNombreContaining(String nombre);
    List<Curso> findByDuracion(int duracion);
    List<Curso> findByPrecioLessThan(double precio);
}
