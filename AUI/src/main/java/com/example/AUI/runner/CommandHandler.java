package com.example.AUI.runner;

import com.example.AUI.domain.Kingdom;
import com.example.AUI.domain.Species;
import com.example.AUI.services.KingdomService;
import com.example.AUI.services.SpeciesService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;


@Component
public class CommandHandler {
    private final KingdomService kingdomService;
    private final SpeciesService speciesService;
    @Autowired
    private ApplicationContext applicationContext;

    public CommandHandler(KingdomService kingdomService, SpeciesService speciesService) {
        this.kingdomService = kingdomService;
        this.speciesService = speciesService;
    }


    @Transactional
    public void handleCommand(String command) {
        String[] commandParts = command.split(" ");

        switch (commandParts[0]) {
            case "h":
                printCommands();
                break;
            case "+K":
                addKingdom(commandParts[1], Integer.parseInt(commandParts[2]));
                break;
            case "+S":
                addSpecies(commandParts[1], Integer.parseInt(commandParts[2]), commandParts[3]);
                break;
            case "K":
                listKingdoms();
                break;
            case "S":
                if(commandParts.length == 1)
                    listSpecies();
                else if (commandParts.length == 2)
                    listSpeciesInKingdom(commandParts[1]);
                break;
            case "-K":
                deleteKingdom(commandParts[1]);
                break;
            case "-S":
                deleteSpecies(commandParts[1]);
                break;
            case "q":
                quit();
                break;
            default:
                System.out.println("wrong command");
                break;
        }
    }

    private void printCommands() {
        System.out.println("Commands:");
        System.out.println("help:                   h");
        System.out.println("add kingdom:            +K kingdom_name taxonomy_year");
        System.out.println("add species:            +S species_name classification_year kingdom_name");
        System.out.println("list kingdoms:          K");
        System.out.println("list species:           S");
        System.out.println("list species in K:      S kingdom_name");
        System.out.println("delete kingdom:         -K kingdom_name");
        System.out.println("delete species:         -S species_name");
        System.out.println("quit:                   q");
    }

    public void quit() {
        if (applicationContext instanceof ConfigurableApplicationContext) {
           ((ConfigurableApplicationContext) applicationContext).close();
        }
    }

    @Transactional
    public void addKingdom(String name, Integer taxonomyYear) {
        Kingdom kingdom = Kingdom.builder()
                .name(name)
                .taxonomyYear(taxonomyYear)
                .species(new HashSet<>())
                .id(UUID.randomUUID())
                .build();
        kingdomService.save(kingdom);
        System.out.println("kingdom added");
    }

    @Transactional
    public void addSpecies(String name, Integer classificationYear, String kingdomName) {
        Kingdom kingdom = kingdomService.findByName(kingdomName);
        Species species = Species.builder()
                .name(name)
                .classificationYear(classificationYear)
                .kingdom(kingdom)
                .id(UUID.randomUUID())
                .build();
        speciesService.save(species);

        kingdom.getSpecies().add(species);
        kingdomService.save(kingdom);
        System.out.println("species added");
    }

    @Transactional
    public void listKingdoms() {
        System.out.println("listing kingdoms");
        Iterable<Kingdom> kingdoms = kingdomService.findAll();
        for (Kingdom kingdom : kingdoms) {
            System.out.println(kingdom.toString());
        }
    }

    @Transactional
    public void listSpecies() {
        System.out.println("listing species");
        Iterable<Species> species = speciesService.findAll();
        for (Species s : species) {
            System.out.println(s.toString());
        }
    }

    @Transactional
    public void listSpeciesInKingdom(String name) {
        System.out.println("listing species in " + name);
        Kingdom kingdom = kingdomService.findByName(name);
        Iterable<Species> species = speciesService.findByKingdom(kingdom);
        for(Species s : species)
            System.out.println(s);
    }

    @Transactional
    public void deleteKingdom(String name) {
        kingdomService.delete(kingdomService.findByName(name));
        System.out.println("kingdom deleted");
    }

    @Transactional
    public void deleteSpecies(String name) {
        speciesService.delete(speciesService.findByName(name));
        System.out.println("species deleted");
    }
}
