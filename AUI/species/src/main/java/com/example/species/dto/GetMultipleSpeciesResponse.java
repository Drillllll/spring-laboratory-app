package com.example.species.dto;

import lombok.*;

import java.util.List;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetMultipleSpeciesResponse {
    List<GetSpeciesResponse> species;

}
