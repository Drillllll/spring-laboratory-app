package com.example.init;

import com.example.kingdom.entity.Kingdom;
import com.example.species.entity.Species;
import com.example.species.service.SpeciesService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.UUID;

import com.example.kingdom.service.KingdomService;

@Component
@RequiredArgsConstructor
public class Initializer {

    private final KingdomService kingdomService;
    private final SpeciesService speciesService;




    @PostConstruct
    public void initialize(){


        /*//saving kingdoms to DB

        Kingdom animalia = Kingdom.builder()
                .id(UUID.fromString("af3bf0bb-5575-4cce-a61f-2cdfdc9f46da"))
                .build();

        Kingdom animaliaSaved = kingdomService.save(animalia);

        Kingdom plantae = Kingdom.builder()
                .id(UUID.fromString("af3bf0bb-5575-4cce-a61f-2cdfdc9f45d9"))
                .build();

        Kingdom plantaeSaved = kingdomService.save(plantae);



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





        //filling species in kingdoms
        //animaliaSaved.getSpecies().add(hippocampus);
        //animaliaSaved.getSpecies().add(puma);
        //plantaeSaved.getSpecies().add(quercus);
        //plantaeSaved.getSpecies().add(salix);


        kingdomService.save(animaliaSaved);
        kingdomService.save(plantaeSaved);
*/

    }
}


