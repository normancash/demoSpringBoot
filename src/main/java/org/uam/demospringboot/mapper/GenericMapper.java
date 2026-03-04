package org.uam.demospringboot.mapper;

import java.util.List;

public interface GenericMapper<E,D> {
    E toEntity(D dto);
    D toDto(E entity);
    List<D> toDtoList(List<E> entities);
    List<E> toEntityList(List<D> dtos);
}
