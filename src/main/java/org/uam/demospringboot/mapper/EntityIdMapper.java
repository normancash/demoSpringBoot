package org.uam.demospringboot.mapper;


import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;
import org.uam.demospringboot.model.EntityBase;
import java.util.UUID;



@Component
public class EntityIdMapper {

    public <T extends EntityBase> UUID map(T entity) {
        return entity != null ? entity.getId() : null;
    }

    public <T extends EntityBase> T map(UUID id, @TargetType Class<T> type) {
        if (id == null) {
            return null;
        }
        try {
            T entity = type.getDeclaredConstructor().newInstance();
            entity.setId(id);
            return entity;
        } catch (Exception e) {
            throw new IllegalArgumentException("Error creando la instancia de:" + type.getSimpleName(), e);
        }
    }
}
