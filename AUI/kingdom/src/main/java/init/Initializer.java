package init;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.UUID;

import com.example.kingdom.service.KingdomService;
import com.example.kingdom.entity.Kingdom;

@Component
@RequiredArgsConstructor
public class Initializer {

    private final KingdomService kingdomService;

    @PostConstruct
    public void initialize(){


        //saving kingdoms to DB

       /* Kingdom animalia = Kingdom.builder()
                .name("Animalia")
                .taxonomyYear(1758)
                .id(UUID.fromString("af3bf0bb-5575-4cce-a61f-2cdfdc9f46da"))
                .build();

        Kingdom animaliaSaved = kingdomService.save(animalia);

        Kingdom plantae = Kingdom.builder()
                .name("Plantae")
                .taxonomyYear(1956)
                .id(UUID.fromString("af3bf0bb-5575-4cce-a61f-2cdfdc9f45d9"))
                .build();

        Kingdom plantaeSaved = kingdomService.save(plantae);



        kingdomService.save(animaliaSaved);
        kingdomService.save(plantaeSaved);*/


    }
}


