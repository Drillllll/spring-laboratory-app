package com.example.kingdom.dto;

import lombok.*;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PutKingdomRequest {
    private String name;
    private Integer taxonomyYear;
}
