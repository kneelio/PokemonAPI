package org.example.models;



import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Results {

    @JsonProperty
    List<Pokemon> list;

    public List<Pokemon> getList() {return list;}

    public void setList(List<Pokemon> list) {
        this.list = list;
    }
}
