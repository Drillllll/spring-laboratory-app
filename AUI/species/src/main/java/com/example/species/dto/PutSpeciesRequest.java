package com.example.species.dto;

import lombok.*;

import java.util.UUID;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PutSpeciesRequest {
    private String name;
    private Integer classificationYear;
    private UUID kingdomId;
}
