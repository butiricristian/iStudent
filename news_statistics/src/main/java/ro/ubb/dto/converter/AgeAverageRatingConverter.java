package ro.ubb.dto.converter;

import ro.ubb.dto.AgeAverageRatingDto;
import ro.ubb.model.AgeAverageRating;

public class AgeAverageRatingConverter extends Converter<AgeAverageRating, AgeAverageRatingDto> {
    @Override
    public AgeAverageRatingDto getDTOInstance() {
        return new AgeAverageRatingDto();
    }

    @Override
    public AgeAverageRating getEntityInstance() {
        return new AgeAverageRating();
    }

    @Override
    protected void mapEntityToDTOFields(AgeAverageRating entity, AgeAverageRatingDto dto) {
        dto.setAge(entity.getAge());
        dto.setRating(entity.getRating());
    }

    @Override
    protected void mapDTOToEntityFields(AgeAverageRatingDto dto, AgeAverageRating entity) {
        entity.setAge(dto.getAge());
        entity.setRating(dto.getRating());
    }
}
