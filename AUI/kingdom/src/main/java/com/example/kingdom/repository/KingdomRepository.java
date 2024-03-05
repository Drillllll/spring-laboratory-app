package com.example.kingdom.repository;


import com.example.kingdom.entity.Kingdom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KingdomRepository extends JpaRepository<Kingdom, UUID> {
    Kingdom findByName(String name);
}
