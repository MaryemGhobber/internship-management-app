package tn.cpg.internshipservice.service;

import java.util.List;
import java.util.Optional;

public interface CrudService <T>{
    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T dto);

    void delete(Long id);

    T update(Long id, T dto);
}
