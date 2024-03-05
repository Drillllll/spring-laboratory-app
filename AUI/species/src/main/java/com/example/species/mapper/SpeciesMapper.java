package com.example.species.mapper;


import com.example.kingdom.dto.GetKingdomResponse;
import com.example.kingdom.entity.Kingdom;
import com.example.species.dto.GetSpeciesResponse;
import com.example.species.dto.PostSpeciesRequest;
import com.example.species.dto.PutSpeciesRequest;
import com.example.species.entity.Species;
import org.mapstruct.Mapper;

//https://auth0.com/blog/how-to-automatically-map-jpa-entities-into-dtos-in-spring-boot-using-mapstruct/
//@Mapper(componentModel = "spring")
@Mapper
public interface SpeciesMapper {
    default GetSpeciesResponse speciesToGetSpeciesResponse(Species species) {
        if(species == null) {
            return null;
        }
        return GetSpeciesResponse.builder()
                .id(species.getId())
                .name(species.getName())
                .classificationYear(species.getClassificationYear())
                .kingdom(GetKingdomResponse.builder()
                        .id(species.getKingdom().getId())
                        //.name(species.getKingdom().getName())
                        //.taxonomyYear(species.getKingdom().getTaxonomyYear())
                        .build())
                .build();
    }

    default Species putSpeciesRequestToSpecies(PutSpeciesRequest species, Kingdom kingdom) {
        if ( species == null ) {
            return null;
        }

        Species.SpeciesBuilder species1 = Species.builder();

        species1.name( species.getName() );
        species1.classificationYear( species.getClassificationYear() );
        species1.kingdom(kingdom);

        return species1.build();
    }

    Species postSpeciesRequestToSpecies(PostSpeciesRequest species);
}
