package com.example.AUI.species.service;

import com.example.AUI.kingdom.entity.Kingdom;
import com.example.AUI.species.entity.Species;

import java.util.List;

public interface SpeciesService {
    Iterable<Species> findAll();
    Species save(Species species);
    List<Species> findByKingdom(Kingdom kingdom);
    void delete(Species species);
    Species findByName(String name);

}
