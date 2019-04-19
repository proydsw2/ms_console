package com.cibertec.dsw2.Repository;

import com.cibertec.dsw2.Model.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console,Integer> {

}
