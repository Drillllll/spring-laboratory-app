package com.example.AUI.services;

import com.example.AUI.domain.Kingdom;
import com.example.AUI.domain.Species;

import java.util.List;

public interface SpeciesService {
    Iterable<Species> findAll();
    Species save(Species species);
    List<Species> findByKingdom(Kingdom kingdom);
    void delete(Species species);
    Species findByName(String name);

}
