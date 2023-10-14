package com.example.AUI.services;

import com.example.AUI.domain.Kingdom;
import com.example.AUI.repositories.KingdomRepository;
import org.springframework.stereotype.Service;

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
}
