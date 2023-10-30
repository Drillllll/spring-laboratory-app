package com.example.AUI.species.service;

import com.example.AUI.kingdom.entity.Kingdom;
import com.example.AUI.species.entity.Species;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpeciesService {
    List<Species> findAll();
    Species save(Species species);
    List<Species> findByKingdom(Kingdom kingdom);
    void delete(Species species);
    Species findByName(String name);
    Optional<Species> getSpeciesById(UUID id);

    void updateSpeciesById(UUID speciesId, Species species);
}
