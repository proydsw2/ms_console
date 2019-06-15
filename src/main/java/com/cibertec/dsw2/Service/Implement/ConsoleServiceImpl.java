package com.cibertec.dsw2.Service.Implement;

import com.cibertec.dsw2.Model.Console;
import com.cibertec.dsw2.Repository.ConsoleRepository;
import com.cibertec.dsw2.Service.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ConsoleServiceImpl implements ConsoleService {


    @PersistenceContext
    private EntityManager em;

    @Autowired
    ConsoleRepository consoleRepository;

    public ResponseEntity<Object> getAll() {
        try {
            List<Console> consoles = consoleRepository.findAll();

            if (consoles == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(consoles);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> getOne(Integer id) {
        try {
            Optional<Console> console = consoleRepository.findById(id);

            if (!console.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok().body(console);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> insert(Console console) {
        try {
            Console entity = consoleRepository.save(console);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(entity.getNum_console_id()).toUri();

            return ResponseEntity.ok().body(entity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> update(Integer id, Console console) {
        try {
            Optional<Console> entity = consoleRepository.findById(id);

            if (!entity.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            console.setNum_console_id(id);
            Console cust = consoleRepository.save(console);
            return ResponseEntity.ok().body(cust);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Object> delete(Integer id) {

        try {
            Optional<Console> entity = consoleRepository.findById(id);
            if (!entity.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            consoleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
