package com.understanding.springmvc.service;

import com.understanding.springmvc.exception.JediNotFoundException;
import com.understanding.springmvc.model.Jedi;
import com.understanding.springmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {

    @Autowired
    private JediRepository jediRepository;

    public List<Jedi> findAll() {
        return jediRepository.findAll();
    }

    public Jedi findById(final Long id) {
        final Optional<Jedi> jedi = jediRepository.findById(id);
        if (jedi.isPresent()) {
            return jedi.get();
        } else {
            throw new JediNotFoundException();
        }
    }

    public Jedi save(final Jedi jedi) {
        return jediRepository.save(jedi);
    }

    public Jedi update(final Long id, final Jedi dto) {
        final Optional<Jedi> jediEntity = jediRepository.findById(id);
        final Jedi jedi;

        if (jediEntity.isPresent()) {
            jedi = jediEntity.get();
        } else {
            throw new JediNotFoundException();
        }

        jedi.setName(dto.getName());
        jedi.setLastName(dto.getLastName());

        return jediRepository.save(jedi);
    }

    public void delete(final Long id) {
        final Jedi jedi = findById(id);
        jediRepository.delete(jedi);
    }
}
