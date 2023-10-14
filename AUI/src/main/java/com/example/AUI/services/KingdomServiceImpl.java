package com.example.AUI.services;

import com.example.AUI.domain.Kingdom;
import com.example.AUI.domain.Species;
import com.example.AUI.repositories.KingdomRepository;
import com.example.AUI.repositories.SpeciesRepository;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;

@Service
public class KingdomServiceImpl implements KingdomService {
    private final KingdomRepository kingdomRepository;

    public KingdomServiceImpl(KingdomRepository kingdomRepository) {
        this.kingdomRepository = kingdomRepository;
    }

    @Override
    public Iterable<Kingdom> findAll() {
        return kingdomRepository.findAll();
    }

    @Override
    public Kingdom save(Kingdom kingdom) {
        return kingdomRepository.save(kingdom);
    }

    @Override
    public Kingdom findByName(String name) {
        return kingdomRepository.findByName(name);
    }

    @Override
    public void delete(Kingdom kingdom) {
        if (kingdom != null) {
            kingdomRepository.delete(kingdom);
        }
    }
}
