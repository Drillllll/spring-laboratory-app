package com.example.AUI.kingdom.entity;
import com.example.AUI.species.entity.Species;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Table(name="kingdoms")
@EqualsAndHashCode(exclude="species")
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Kingdom implements Comparable<Kingdom> {
    @Id
    private UUID id;
    @Column(unique = true)
    private String name;
    @Column(name="taxonomy_year")
    private Integer taxonomyYear;

    @OneToMany(mappedBy = "kingdom", fetch = FetchType.LAZY)
    private Set<Species> species = new HashSet<>();

    @Override
    public int compareTo(Kingdom other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Kingdom{" +
                "name='" + name + '\'' +
                ", taxonomyYear=" + taxonomyYear +
                '}';
    }
}
