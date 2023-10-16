package com.example.AUI.repositories;

import com.example.AUI.domain.Kingdom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface KingdomRepository extends JpaRepository<Kingdom, UUID> {
    Kingdom findByName(String name);
}
