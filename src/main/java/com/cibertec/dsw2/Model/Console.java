package com.cibertec.dsw2.Model;

import javax.persistence.*;

@SequenceGenerator(name="seq_console_id", initialValue=1, allocationSize=100)
@Entity
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_console_id")
    @Column(name = "num_console_id")
    private Long num_console_id;

    @Column(name = "str_description")
    private String str_description;

    public Console(String str_description) {
        this.str_description = str_description;
    }

    public Console() {
    }

    @Override
    public String toString() {
        return "Console{" +
                "num_console_id=" + num_console_id +
                ", str_description='" + str_description + '\'' +
                '}';
    }

    public Long getNum_console_id() {
        return num_console_id;
    }

    public void setNum_console_id(Long num_console_id) {
        this.num_console_id = num_console_id;
    }

    public String getStr_description() {
        return str_description;
    }

    public void setStr_description(String str_description) {
        this.str_description = str_description;
    }
}
