package com.example.AUI.domain;
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
    private UUID id;
    @Column (unique = true)
    private String name;
    @Column(name="classification_year")
    private Integer classificationYear;

    @ManyToOne
    @JoinColumn(name="kingdom")
    private Kingdom kingdom;

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
