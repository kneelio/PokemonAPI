package org.example;

import org.example.models.Pokemon;
import org.example.services.PokemonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PokemonService service = new PokemonService();
        List<Pokemon> pokemonList = new ArrayList<>();
        int choice = 0;
        do {

            System.out.println("Let's catch some Pokemon!!!");
            System.out.println("1. get first 20");
            System.out.println("2. get second 20");
            System.out.println("3. get third 20");
            System.out.println("4. Quit");
            System.out.println("Enter choice: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1: // if choice == 1
                    pokemonList = service.getAllPokemon();
                    System.out.println("help");
                    break;

                case 2: //else if choice == 2
                    pokemonList = service.getAllPokemon();
                    break;

                case 3: //
                    break;
            }
        } while (choice != 4);
    }

}