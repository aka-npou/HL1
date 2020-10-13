package ru.aka_npou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.aka_npou.model.Location;

@Service
public class LocationService {

    @Autowired
    private CrudRepository<Location, Long> repository;

    public Iterable<Location> list() {
        return repository.findAll();
    }

    public Location get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Location save(Location object) {
        return repository.save(object);
    }

    public void delete(Location object) {
        repository.delete(object);
    }

}
