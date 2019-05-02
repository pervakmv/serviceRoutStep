package com;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class Route implements Serializable{
    String id;
    List steps;

    public Route(){
    }

    public Route(String id, List steps) {
        this.id = id;
        this.steps = steps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List getSteps() {
        return steps;
    }

    public void setSteps(List steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", steps=" + steps +
                '}';
    }
}
