package com.example.kingdom.event.repository;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class KingdomEventRepositoryImpl implements KingdomEventRepository{
    private final RestTemplate restTemplate;

    @Override
    public void delete(UUID id) {
        restTemplate.delete("/api/kingdom/{kingdomId}", id);
    }

    @Override
    public void add(UUID id) {
        restTemplate.put("/api/kingdom/{kingdomId}", null, id);
    }
}
