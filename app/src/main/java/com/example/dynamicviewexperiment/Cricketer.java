package com.example.dynamicviewexperiment;

import java.io.Serializable;

public class Cricketer implements Serializable {

    public String name ;

    public Cricketer() {
    }

    public Cricketer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cricketer{" +
                "name='" + name + '\'' +
                '}';
    }
}
