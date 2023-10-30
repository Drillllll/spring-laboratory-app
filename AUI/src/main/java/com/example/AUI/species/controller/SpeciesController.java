package com.example.AUI.species.controller;

import com.example.AUI.kingdom.dto.GetKingdomResponse;
import com.example.AUI.kingdom.dto.GetKingdomsResponse;
import com.example.AUI.kingdom.dto.PutKingdomRequest;
import com.example.AUI.kingdom.entity.Kingdom;
import com.example.AUI.kingdom.mapper.KingdomMapper;
import com.example.AUI.kingdom.service.KingdomService;
import com.example.AUI.species.dto.GetMultipleSpeciesResponse;
import com.example.AUI.species.dto.GetSpeciesResponse;
import com.example.AUI.species.dto.PutSpeciesRequest;
import com.example.AUI.species.entity.Species;
import com.example.AUI.species.mapper.SpeciesMapper;
import com.example.AUI.species.service.SpeciesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class SpeciesController {

    public final String SPECIES_PATH = "/api/species";
    public final String SPECIES_PATH_ID = SPECIES_PATH + "/{speciesId}";
    private final SpeciesService speciesService;
    private final SpeciesMapper speciesMapper;

    @GetMapping(SPECIES_PATH)
    public ResponseEntity getMultipleSpecies() {
        // Transform List<Species> to List<GetSpeciesResponse> using SpeciesMapper
        List<GetSpeciesResponse> speciesResponses = speciesService.findAll()
                .stream()
                .map(speciesMapper::speciesToGetSpeciesResponse)
                .collect(Collectors.toList());

        GetMultipleSpeciesResponse response = GetMultipleSpeciesResponse.builder()
                .species(speciesResponses)
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(SPECIES_PATH_ID)
    public ResponseEntity getSpecies(@PathVariable("speciesId") UUID speciesId) {
        Optional<Species> optionalSpecies = speciesService.getSpeciesById(speciesId);

        if (optionalSpecies.isPresent()) {
            return new ResponseEntity<>(speciesMapper.speciesToGetSpeciesResponse(optionalSpecies.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(SPECIES_PATH_ID)
    public ResponseEntity putSpecies(@PathVariable("speciesId") UUID speciesId, @RequestBody PutSpeciesRequest species){
        speciesService.updateSpeciesById(speciesId, speciesMapper.putSpeciesRequestToSpecies(species));
        return new ResponseEntity<>(null, HttpStatus.CREATED);

    }
}
