package org.uam.demospringboot.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uam.demospringboot.model.EntityBase;

import java.util.List;
import java.util.UUID;

public abstract class GenericService<E extends EntityBase,R extends JpaRepository<E, UUID>> {

    protected final R repository;

    protected GenericService(R repository) {
        this.repository = repository;
    }

    public List<E> findAll() {
        return repository.findAll();
    }
    public E findById(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new RuntimeException("No existe la entidad con el id:" + id));
    }
    public E create(E entity) {
        return repository.save(entity);
    }
    public E update(UUID id, E entity) {
        E value = findById(id);
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
