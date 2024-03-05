package com.example.kingdom.event.repository;

import java.util.UUID;

public interface KingdomEventRepository {
    void delete(UUID id);
    void add(UUID id);
}
