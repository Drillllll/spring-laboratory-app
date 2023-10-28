package com.example.AUI.species.service;

import com.example.AUI.kingdom.entity.Kingdom;
import com.example.AUI.species.entity.Species;
import com.example.AUI.species.repository.SpeciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    private final SpeciesRepository speciesRepository;

    public SpeciesServiceImpl(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    @Override
    public Iterable<Species> findAll() {
        return speciesRepository.findAll();
    }

    @Override
    public Species save(Species species) {
        return speciesRepository.save(species);
    }

    @Override
    public List<Species> findByKingdom(Kingdom kingdom) {
        return speciesRepository.findByKingdom(kingdom);
    }

    @Override
    public void delete(Species species) {
        speciesRepository.delete(species);
    }

    @Override
    public Species findByName(String name) {
        return speciesRepository.findByName(name);
    }
}
