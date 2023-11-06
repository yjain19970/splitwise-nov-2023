package com.example.splitwise.splitwisenovmwf;

import command.CommandExecutor;
import command.SettleUpUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseNovMwfApplication implements CommandLineRunner {

    private Scanner sc = new Scanner(System.in);
    private CommandExecutor commandExecutor;

    @Autowired
    public SplitwiseNovMwfApplication(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseNovMwfApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while(true){
            String input = sc.next();
            commandExecutor.executeCommand(input);
        }
    }
}
