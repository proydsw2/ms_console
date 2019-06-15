package com.cibertec.dsw2.Model;

import lombok.Data;
import javax.persistence.*;

@SequenceGenerator(name="seq_console_id", allocationSize=1)
@Data
@Entity
@Table(name = "console")
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_console_id")
    @Column(name = "num_console_id")
    private Integer num_console_id;

    @Column(name = "str_description")
    private String str_description;
}
