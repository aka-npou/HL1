package ru.aka_npou.repository;

import org.springframework.data.repository.CrudRepository;
import ru.aka_npou.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {

}
