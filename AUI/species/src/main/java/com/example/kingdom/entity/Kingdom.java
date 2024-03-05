package com.example.kingdom.entity;
import jakarta.persistence.*;
import lombok.*;
import com.example.species.entity.Species;

import java.util.*;


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
    @Column(name="id")
    private UUID id;


    @OneToMany(mappedBy = "kingdom", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Species> species = new ArrayList<>();

    @Override
    public int compareTo(Kingdom other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return "Kingdom{" +
                "id='" + id + '\'' +
                '}';
    }
}
