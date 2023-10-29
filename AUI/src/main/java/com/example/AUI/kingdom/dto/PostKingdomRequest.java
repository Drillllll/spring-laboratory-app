package com.example.AUI.kingdom.dto;

import lombok.*;

@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostKingdomRequest {
    private String name;
    private Integer taxonomyYear;
}