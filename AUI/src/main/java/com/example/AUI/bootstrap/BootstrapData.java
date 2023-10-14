package com.example.AUI.bootstrap;


import com.example.AUI.domain.Kingdom;
import com.example.AUI.domain.Species;
import com.example.AUI.services.KingdomService;
import com.example.AUI.services.SpeciesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class BootstrapData  implements CommandLineRunner {

    private final KingdomService kingdomService;
    private final SpeciesService speciesService;

    public BootstrapData(KingdomService kingdomService, SpeciesService speciesService) {
        this.kingdomService = kingdomService;
        this.speciesService = speciesService;
    }

    @Override
    public void run(String... args) throws Exception {

        //saving kingdoms to DB

        Kingdom animalia = Kingdom.builder()
                .name("Animalia")
                .taxonomyYear(1758)
                .species(new HashSet<>())
                .build();

        Kingdom animaliaSaved = kingdomService.save(animalia);

        Kingdom plantae = Kingdom.builder()
                .name("Plantae")
                .taxonomyYear(1956)
                .species(new HashSet<>())
                .build();

        Kingdom plantaeSaved = kingdomService.save(plantae);

        Kingdom fungi = Kingdom.builder()
                .name("Fungi")
                .taxonomyYear(1932)
                .species(new HashSet<>())
                .build();

        Kingdom fungiSaved = kingdomService.save(fungi);

        //saving species to DB

        Species puma = Species.builder()
                .name("Puma")
                .classificationYear(1771)
                .kingdom(animalia)
                .build();

        Species pumaSaved = speciesService.save(puma);

        Species hippocampus = Species.builder()
                .name("Hippocampus")
                .classificationYear(1810)
                .kingdom(animalia)
                .build();

        Species hippocampusSaved = speciesService.save(hippocampus);

        Species quercus = Species.builder()
                .name("Quercus")
                .classificationYear(1753)
                .kingdom(plantae)
                .build();

        Species quercusSaved = speciesService.save(quercus);

        Species salix = Species.builder()
                .name("Salix")
                .classificationYear(1752)
                .kingdom(plantae)
                .build();

        Species salixSaved = speciesService.save(salix);

        Species aspergillus = Species.builder()
                .name("Aspergillus")
                .classificationYear(1930)
                .kingdom(fungi)
                .build();

        Species aspergillusSaved = speciesService.save(aspergillus);

        Species gymnopus = Species.builder()
                .name("Gymnopus")
                .classificationYear(1806)
                .kingdom(fungi)
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
