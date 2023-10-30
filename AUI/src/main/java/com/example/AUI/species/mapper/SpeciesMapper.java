package com.example.AUI.species.mapper;


import com.example.AUI.kingdom.dto.GetKingdomResponse;
import com.example.AUI.kingdom.dto.PostKingdomRequest;
import com.example.AUI.kingdom.dto.PutKingdomRequest;
import com.example.AUI.kingdom.entity.Kingdom;
import com.example.AUI.species.dto.GetSpeciesResponse;
import com.example.AUI.species.dto.PostSpeciesRequest;
import com.example.AUI.species.dto.PutSpeciesRequest;
import com.example.AUI.species.entity.Species;
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
                        .name(species.getKingdom().getName())
                        .taxonomyYear(species.getKingdom().getTaxonomyYear())
                        .build())
                .build();
    }

    Species putSpeciesRequestToSpecies(PutSpeciesRequest species);

    Species postSpeciesRequestToSpecies(PostSpeciesRequest species);
}
