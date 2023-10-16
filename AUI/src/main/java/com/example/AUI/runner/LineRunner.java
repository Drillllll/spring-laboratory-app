package com.example.AUI.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class LineRunner implements CommandLineRunner {

    private String command = "";
    private final Scanner scanner = new Scanner(System.in);
    private final CommandHandler commandHandler;

    public LineRunner(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public void run(String... args) throws Exception {

        while (!command.equals("quit")) {
            System.out.println();
            System.out.println("Enter h for help");
            System.out.println("Enter a command: ");

            command = scanner.nextLine();
            commandHandler.handleCommand(command);
        }

        scanner.close();
        System.out.println("exiting");
    }
}