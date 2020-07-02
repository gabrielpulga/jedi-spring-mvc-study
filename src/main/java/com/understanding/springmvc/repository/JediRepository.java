package com.understanding.springmvc.repository;

import com.understanding.springmvc.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JediRepository {

    //Jedi instances list
    private List<Jedi> jediList = new ArrayList<>();

    //Jedi constructor
    public JediRepository() {
        jediList.add(new Jedi("Luke", "Skywalker"));
    }

    public List<Jedi> getAllJedi() {
        return this.jediList;
    }

    public void addJedi(final Jedi jedi) {
        this.jediList.add(jedi);
    }
}
