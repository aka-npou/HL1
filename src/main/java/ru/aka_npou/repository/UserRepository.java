package ru.aka_npou.repository;

import org.springframework.data.repository.CrudRepository;
import ru.aka_npou.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
