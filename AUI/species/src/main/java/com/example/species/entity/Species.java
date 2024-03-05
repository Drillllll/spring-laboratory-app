package com.example.species.entity;

import com.example.kingdom.entity.Kingdom;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Table(name="species")
@EqualsAndHashCode
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Species implements Comparable<Species> {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column (unique = true)
    private String name;
    @Column(name="classification_year")
    private Integer classificationYear;

    @ManyToOne
    @JoinColumn(name="kingdom_id")
    private com.example.kingdom.entity.Kingdom kingdom;

    @Override
    public int compareTo(Species other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Species{" +
                "name='" + name + '\'' +
                ", classificationYear=" + classificationYear +
                '}';
    }
}
