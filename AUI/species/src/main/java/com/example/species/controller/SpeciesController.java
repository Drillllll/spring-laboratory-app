package com.example.species.controller;


import com.example.kingdom.entity.Kingdom;
import com.example.kingdom.service.KingdomService;
import com.example.species.dto.GetMultipleSpeciesResponse;
import com.example.species.dto.GetSpeciesResponse;
import com.example.species.dto.PostSpeciesRequest;
import com.example.species.dto.PutSpeciesRequest;
import com.example.species.entity.Species;
import com.example.species.mapper.SpeciesMapper;
import com.example.species.service.SpeciesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
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
    private final KingdomService kingdomService;

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
        Optional<Kingdom> optKingdom = kingdomService.getKingdomById(species.getKingdomId());
        if(optKingdom.isPresent()) {
            Kingdom kingdom = optKingdom.get();
            speciesService.updateSpeciesById(speciesId, speciesMapper.putSpeciesRequestToSpecies(species, kingdom));
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(SPECIES_PATH)
    public ResponseEntity postSpecies(@RequestBody PostSpeciesRequest species){

        Species newSpecies = speciesMapper.postSpeciesRequestToSpecies(species);
        newSpecies.setId(UUID.randomUUID());

        //adding kingdom field to species
        Optional<Kingdom> speciesKingdom = kingdomService.getKingdomById(species.getKingdomId());
        if(speciesKingdom.isPresent()) {
            newSpecies.setKingdom(speciesKingdom.get());
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Species savedSpecies = speciesService.save(newSpecies);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", SPECIES_PATH + "/" + savedSpecies.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(SPECIES_PATH_ID)
    public ResponseEntity deleteSpecies (@PathVariable("speciesId") UUID speciesId) {

        Optional<Species> optionalSpecies = speciesService.getSpeciesById(speciesId);

        if (optionalSpecies.isPresent()) {
            speciesService.delete(optionalSpecies.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(SPECIES_PATH + "/kingdom/{kingdomId}")
    public ResponseEntity getSpeciesByKingdom(@PathVariable("kingdomId") UUID kingdomId) {

        Optional<Kingdom> optionalKingdom = kingdomService.getKingdomById(kingdomId);

        if(optionalKingdom.isPresent()) {
            Kingdom kingdom = optionalKingdom.get();
            List<Species> speciesByKingdom = speciesService.findByKingdom(kingdom);

            List<GetSpeciesResponse> speciesResponses = speciesByKingdom
                    .stream()
                    .map(speciesMapper::speciesToGetSpeciesResponse)
                    .collect(Collectors.toList());

            GetMultipleSpeciesResponse response = GetMultipleSpeciesResponse.builder()
                    .species(speciesResponses)
                    .build();

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
