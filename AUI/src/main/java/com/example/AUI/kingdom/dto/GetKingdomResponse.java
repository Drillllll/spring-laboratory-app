package com.example.AUI.kingdom.dto;

import lombok.*;
import java.util.UUID;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetKingdomResponse {
    private UUID id;
    private String name;
    private Integer taxonomyYear;

}
