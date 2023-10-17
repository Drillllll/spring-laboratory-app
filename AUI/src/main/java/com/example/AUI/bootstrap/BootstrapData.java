package com.example.AUI.bootstrap;


import com.example.AUI.domain.Kingdom;
import com.example.AUI.domain.Species;
import com.example.AUI.services.KingdomService;
import com.example.AUI.services.SpeciesService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.UUID;

@Component
public class BootstrapData {

    private final KingdomService kingdomService;
    private final SpeciesService speciesService;

    public BootstrapData(KingdomService kingdomService, SpeciesService speciesService) {
        this.kingdomService = kingdomService;
        this.speciesService = speciesService;
    }


    @PostConstruct
    public void initialize(){

        //saving kingdoms to DB

        Kingdom animalia = Kingdom.builder()
                .name("Animalia")
                .taxonomyYear(1758)
                .species(new HashSet<>())
                .id(UUID.randomUUID())
                .build();

        Kingdom animaliaSaved = kingdomService.save(animalia);

        Kingdom plantae = Kingdom.builder()
                .name("Plantae")
                .taxonomyYear(1956)
                .species(new HashSet<>())
                .id(UUID.randomUUID())
                .build();

        Kingdom plantaeSaved = kingdomService.save(plantae);

        Kingdom fungi = Kingdom.builder()
                .name("Fungi")
                .taxonomyYear(1932)
                .species(new HashSet<>())
                .id(UUID.randomUUID())
                .build();

        Kingdom fungiSaved = kingdomService.save(fungi);

        //saving species to DB

        Species puma = Species.builder()
                .name("Puma")
                .classificationYear(1771)
                .kingdom(animalia)
                .id(UUID.randomUUID())
                .build();

        Species pumaSaved = speciesService.save(puma);

        Species hippocampus = Species.builder()
                .name("Hippocampus")
                .classificationYear(1810)
                .kingdom(animalia)
                .id(UUID.randomUUID())
                .build();

        Species hippocampusSaved = speciesService.save(hippocampus);

        Species quercus = Species.builder()
                .name("Quercus")
                .classificationYear(1753)
                .kingdom(plantae)
                .id(UUID.randomUUID())
                .build();

        Species quercusSaved = speciesService.save(quercus);

        Species salix = Species.builder()
                .name("Salix")
                .classificationYear(1752)
                .kingdom(plantae)
                .id(UUID.randomUUID())
                .build();

        Species salixSaved = speciesService.save(salix);

        Species aspergillus = Species.builder()
                .name("Aspergillus")
                .classificationYear(1930)
                .kingdom(fungi)
                .id(UUID.randomUUID())
                .build();

        Species aspergillusSaved = speciesService.save(aspergillus);

        Species gymnopus = Species.builder()
                .name("Gymnopus")
                .classificationYear(1806)
                .kingdom(fungi)
                .id(UUID.randomUUID())
                .build();

        Species gymnopusSaved = speciesService.save(gymnopus);

        //filling species in kingdoms
        animaliaSaved.getSpecies().add(hippocampus);
        animaliaSaved.getSpecies().add(puma);
        plantaeSaved.getSpecies().add(quercus);
        plantaeSaved.getSpecies().add(salix);
        fungiSaved.getSpecies().add(aspergillus);
        fungiSaved.getSpecies().add(gymnopus);

        kingdomService.save(animaliaSaved);
        kingdomService.save(plantaeSaved);
        kingdomService.save(fungiSaved);

    }
}
