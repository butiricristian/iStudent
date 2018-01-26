package ro.ubb.dto.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Converter<E, D> {

    public abstract D getDTOInstance();

    public abstract E getEntityInstance();

    public D mapToDTO(E entity) {
        D dto = getDTOInstance();
        if (entity == null) {
            return dto;
        } else {
            mapEntityToDTOFields(entity, dto);
            return dto;
        }
    }

    public E mapToEntity(D dto) {
        E entity = getEntityInstance();
        if (dto == null) {
            return entity;
        } else {
            mapDTOToEntityFields(dto, entity);
            return entity;
        }
    }

    public List<D> mapToDTOs(List<E> entities) {
        if (entities != null) {
            return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<E> mapToEntities(List<D> dtos) {
        if (dtos != null) {
            return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    protected abstract void mapEntityToDTOFields(E entity, D dto);

    protected abstract void mapDTOToEntityFields(D dto, E entity);
}
