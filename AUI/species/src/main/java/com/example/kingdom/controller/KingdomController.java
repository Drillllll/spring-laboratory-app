package com.example.kingdom.controller;


import com.example.kingdom.entity.Kingdom;
import com.example.kingdom.service.KingdomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class KingdomController {

    private final KingdomService kingdomService;

    @DeleteMapping("/api/kingdom/{kingdomId}")
    public ResponseEntity<Void> deleteKingdom (@PathVariable("kingdomId") UUID kingdomId) {

        Optional<Kingdom> optionalKingdom = kingdomService.getKingdomById(kingdomId);

        if (optionalKingdom.isPresent()) {
            kingdomService.delete(optionalKingdom.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/api/kingdom")
    public ResponseEntity postKingdom(@RequestBody UUID kingdomId){

        Kingdom savedKingdom = kingdomService.save(Kingdom.builder().id(kingdomId).build());

        HttpHeaders headers = new HttpHeaders();
        //headers.add("Location", KINGDOM_PATH + "/" + savedKingdom.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/api/kingdom/{kingdomId}")
    public ResponseEntity<Void> putKingdom(@PathVariable("kingdomId") UUID kingdomId){
        kingdomService.updateKingdomById(kingdomId);
        return new ResponseEntity<>(null, HttpStatus.CREATED);

    }


}
