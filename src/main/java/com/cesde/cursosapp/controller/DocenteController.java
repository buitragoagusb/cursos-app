package com.cesde.cursosapp.controller;

import com.cesde.cursosapp.model.Docente;
import com.cesde.cursosapp.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/docentes")

public class DocenteController {
    @Autowired
    private DocenteService docenteService;

    @GetMapping
    public List<Docente> getAllDocentes() {
        return docenteService.getAllDocentes();
    }

    @GetMapping("/{id}")
    public Docente getDocenteById(@PathVariable Long id) {
        return docenteService.getDocenteById(id);
    }

    @PostMapping
    public Docente createDocente(@RequestBody Docente docente) {
        return docenteService.saveDocente(docente);
    }

    @PutMapping("/{id}")
    public Docente updateDocente(@PathVariable Long id, @RequestBody Docente docente) {
        docente.setId(id);
        return docenteService.saveDocente(docente);
    }

    @DeleteMapping("/{id}")
    public void deleteDocente(@PathVariable Long id) {
        docenteService.deleteDocente(id);
    }
}
