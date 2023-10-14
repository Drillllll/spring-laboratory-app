package com.example.AUI.bootstrap;


import com.example.AUI.services.KingdomService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData  implements CommandLineRunner {

    private final KingdomService kingdomService;
    //private final SpeciesService speciesService;

    public BootstrapData(KingdomService kingdomService) {
        this.kingdomService = kingdomService;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
