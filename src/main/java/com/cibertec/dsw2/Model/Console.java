package com.cibertec.dsw2.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@javax.persistence.Entity
public class Console {

    @Id
    @GeneratedValue()
    @JsonProperty("id")
    private int id;

    @JsonProperty("description")
    private String description;

    public Console(){

    }

    public Console(int id, String description){
        this.setId(id);
        this.setDescription(description);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "Console:{"+
                "id = "+getId()+
                "description = "+getDescription()+
                "}";
    }
}
