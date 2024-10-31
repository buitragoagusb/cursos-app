package com.cesde.cursosapp.controller;

import com.cesde.cursosapp.dto.CursoDTO;
import com.cesde.cursosapp.model.Curso;
import com.cesde.cursosapp.repository.CursoRepository;
import com.cesde.cursosapp.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")

public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<CursoDTO> getAllCursos() {
        return cursoRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @GetMapping("/nombre")
    public List<CursoDTO> getCursosByNombre(@RequestParam String nombre) {
        return cursoRepository.findByNombreContaining(nombre)
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @GetMapping("/duracion")
    public List<CursoDTO> getCursosByDuracion(@RequestParam int duracion) {
        return cursoRepository.findByDuracion(duracion)
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @GetMapping("/precio")
    public List<CursoDTO> getCursosByPrecio(@RequestParam double precio) {
        return cursoRepository.findByPrecioLessThan(precio)
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    private CursoDTO convertToDto(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setDescripcion(curso.getDescripcion());
        dto.setDuracion(curso.getDuracion());
        dto.setPrecio(curso.getPrecio());
        dto.setFechaInicio(curso.getFechaInicio());
        dto.setDocenteId(curso.getDocente().getId());
        return dto;
    }
}
