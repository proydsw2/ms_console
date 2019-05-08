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
public class ConsoleController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ConsoleRepository repository;

    @GetMapping(path = "/console")
    public List<Console> retriveAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/console/{id}")
    public Console retriveOne(@PathVariable Long id) {
        Optional<Console> cons = repository.findById(id);

        return cons.get();
    }

    @PostMapping(path = "/console")
    public ResponseEntity<Object> create(@RequestBody Console cons) {
        Console entity = repository.save(cons);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getNum_console_id()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/console/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Console cons) {
        Optional<Console> entity = repository.findById(id);

        if (!entity.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        cons.setNum_console_id(id);
        repository.save(cons);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/console/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
