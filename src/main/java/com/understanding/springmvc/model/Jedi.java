package com.understanding.springmvc.model;

import javax.validation.constraints.NotBlank;

public class Jedi {

    //Jedi attributes
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;

    //Name getter
    public String getName() {
        return name;
    }

    //Name setter
    public void setName(String name) {
        this.name = name;
    }

    //Lastname getter
    public String getLastName() {
        return lastName;
    }

    //Lastname setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Jedi constructor with no params
    public Jedi() {
    }

    //Jedi constructor with all params
    public Jedi(final String name, final String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
