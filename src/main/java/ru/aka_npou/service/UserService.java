package ru.aka_npou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ru.aka_npou.model.User;

@Service
public class UserService {

    @Autowired
    private CrudRepository<User, Long> repository;

    public Iterable<User> list() {
        return repository.findAll();
    }

    public User get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User save(User object) {
        return repository.save(object);
    }

    public void delete(User object) {
        repository.delete(object);
    }

}
