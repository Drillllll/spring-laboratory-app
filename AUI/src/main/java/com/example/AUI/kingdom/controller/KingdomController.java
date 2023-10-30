package com.example.AUI.kingdom.controller;

import com.example.AUI.kingdom.dto.GetKingdomResponse;
import com.example.AUI.kingdom.dto.GetKingdomsResponse;
import com.example.AUI.kingdom.dto.PostKingdomRequest;
import com.example.AUI.kingdom.dto.PutKingdomRequest;
import com.example.AUI.kingdom.entity.Kingdom;
import com.example.AUI.kingdom.mapper.KingdomMapper;
import com.example.AUI.kingdom.service.KingdomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class KingdomController {

    public final String KINGDOM_PATH = "/api/kingdom";
    public final String KINGDOM_PATH_ID = KINGDOM_PATH + "/{kingdomId}";
    private final KingdomService kingdomService;
    private final KingdomMapper kingdomMapper;


    @GetMapping(KINGDOM_PATH)
    public ResponseEntity<GetKingdomsResponse> getKingdoms(){

        // Transform List<Kingdom> to List<GetKingdomResponse> using KingdomMapper
        List<GetKingdomResponse> kingdomResponses = kingdomService.findAll()
                .stream()
                .map(kingdomMapper::kingdomToGetKingdomResponse)
                .collect(Collectors.toList());

        GetKingdomsResponse response = GetKingdomsResponse.builder()
                .kingdoms(kingdomResponses)
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping(KINGDOM_PATH_ID)
    public ResponseEntity<GetKingdomResponse> getKingdom(@PathVariable("kingdomId") UUID kingdomId){
        return new ResponseEntity<>(kingdomMapper.kingdomToGetKingdomResponse(kingdomService.getKingdomById(kingdomId).get()),
        HttpStatus.OK);

    }
    @PutMapping(KINGDOM_PATH_ID)
    public ResponseEntity<Void> putKingdom(@PathVariable("kingdomId") UUID kingdomId, @RequestBody PutKingdomRequest kingdom){
        kingdomService.updateKingdomById(kingdomId, kingdomMapper.putKingdomRequestToKingdom(kingdom));
        return new ResponseEntity<>(null, HttpStatus.CREATED);

    }

    @PostMapping(KINGDOM_PATH)
    public ResponseEntity postKingdom(@RequestBody PostKingdomRequest kingdom){

        Kingdom newKingdom = kingdomMapper.postKingdomRequestToKingdom(kingdom);
        newKingdom.setId(UUID.randomUUID());

        Kingdom savedKingdom = kingdomService.save(newKingdom);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", KINGDOM_PATH + "/" + savedKingdom.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @DeleteMapping(KINGDOM_PATH_ID)
    public ResponseEntity deleteKingdom (@PathVariable("kingdomId") UUID kingdomId) {
        kingdomService.delete(kingdomService.getKingdomById(kingdomId)
                .orElseThrow(() -> new NoSuchElementException("Kingdom not found")));

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
