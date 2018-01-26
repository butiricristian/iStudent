package ro.ubb.dto.converter;

import ro.ubb.dto.AgeAverageRatingDTO;
import ro.ubb.model.AgeAverageRating;

public class AgeAverageRatingConverter extends Converter<AgeAverageRating, AgeAverageRatingDTO> {
    @Override
    public AgeAverageRatingDTO getDTOInstance() {
        return new AgeAverageRatingDTO();
    }

    @Override
    public AgeAverageRating getEntityInstance() {
        return new AgeAverageRating();
    }

    @Override
    protected void mapEntityToDTOFields(AgeAverageRating entity, AgeAverageRatingDTO dto) {
        dto.setAge(entity.getAge());
        dto.setRating(entity.getRating());
    }

    @Override
    protected void mapDTOToEntityFields(AgeAverageRatingDTO dto, AgeAverageRating entity) {
        entity.setAge(dto.getAge());
        entity.setRating(dto.getRating());
    }
}
