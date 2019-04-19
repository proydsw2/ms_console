package com.cibertec.dsw2.Controller;

import com.cibertec.dsw2.Repository.ConsoleRepository;
import com.cibertec.dsw2.Model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "{/dsw2}")
public class ConsoleController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ConsoleRepository rep;

    @GetMapping(path = {"/console", "/console/"})
    public List<Console> retriveAll() {
        return rep.findAll();
    }

    @GetMapping(path = {"/console/{id}", "/console/{id}/"})
    public Console retriveOne(@PathVariable Integer id) {
        Optional<Console> cons = rep.findById(id);

        return cons.get();
    }

    @PostMapping(path = {"/console", "/console/"})
    public ResponseEntity<Object> create(@RequestBody Console cons) {
        Console entity = rep.save(cons);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = {"/console/{id}", "/console/{id}/"})
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Console cons) {
        Optional<Console> entity = rep.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        cons.setId(id);
        rep.save(cons);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = {"/console/{id}", "/console/{id}/"})
    public void delete(@PathVariable Integer id) {
        rep.deleteById(id);
    }
}
