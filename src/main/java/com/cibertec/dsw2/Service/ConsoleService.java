package com.cibertec.dsw2.Service;

import com.cibertec.dsw2.Model.Console;
import org.springframework.http.ResponseEntity;

public interface ConsoleService {

    ResponseEntity<Object> getAll();

    ResponseEntity<Object> getOne(Integer id);

    ResponseEntity<Object> insert(Console console);

    ResponseEntity<Object> update(Integer id, Console console);

    ResponseEntity<Object> delete(Integer id);

}
