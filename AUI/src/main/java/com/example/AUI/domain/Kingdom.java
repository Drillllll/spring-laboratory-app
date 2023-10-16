package com.example.AUI.domain;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
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

    @OneToMany(mappedBy = "kingdom", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
