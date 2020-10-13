package ru.aka_npou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.aka_npou.model.Visit;

@Service
public class VisitService {

    @Autowired
    private CrudRepository<Visit, Long> repository;

    public Iterable<Visit> list() {
        return repository.findAll();
    }

    public Visit get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Visit save(Visit object) {
        return repository.save(object);
    }

    public void delete(Visit object) {
        repository.delete(object);
    }

}
