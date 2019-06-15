package com.cibertec.dsw2.Controller;

import com.cibertec.dsw2.Model.Console;
import com.cibertec.dsw2.Service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ConsoleController {

    @Autowired
    private ConsoleService consoleService;

    @GetMapping(path = "/console")
    public ResponseEntity<Object> retriveAll() {
        return consoleService.getAll();
    }

    @GetMapping(path = "/console/{id}")
    public ResponseEntity<Object> retriveOne(@PathVariable Integer id) {
        return consoleService.getOne(id);
    }

    @PostMapping(path = "/console")
    public ResponseEntity<Object> create(@RequestBody Console console) {
        return consoleService.insert(console);
    }

    @PutMapping(path = "/console/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody Console console) {
        return consoleService.update(id, console);
    }

    @DeleteMapping(path = "/console/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        return consoleService.delete(id);
    }
}
