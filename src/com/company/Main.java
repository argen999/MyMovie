package com.company;

import com.company.models.Movie;
import com.company.services.impl.FindAbleImpl;
import com.company.services.impl.SortAbleImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String number = "";
        SortAbleImpl allMethodSortAble = new SortAbleImpl();
        FindAbleImpl allMethodFindAble = new FindAbleImpl();
        while (!number.equals("x")) {
            commands();
            button();
            number = in.nextLine();
            try {
                for (int i = 0; i < number.length(); i++) {
                    if (Character.isDigit(number.charAt(i) ) ) {
                        switch (number) {
                            case "1" -> allMethodSortAble.printAllMovies();
                            case "2" -> allMethodSortAble.findMovie();
                            case "3" -> allMethodSortAble.sortByYear();
                            case "4" -> allMethodSortAble.sortByName();
                            case "5" -> allMethodSortAble.sortByDirector();
                            case "6" -> allMethodFindAble.findMoviesByActor();
                            case "7" -> allMethodFindAble.findMoviesByDirector();
                            case "8" -> allMethodFindAble.findMoviesByYear();
                            case "9" -> allMethodFindAble.findMoviesAndRoleByActor();
                            case "10" -> allMethodFindAble.showActorRoles();
                            default -> System.out.println("Андай метод жок!");
                        }
                    } else {
                        throw new MyException();
                    }
                }
            } catch (MyException e) {
                System.out.println("You spelled it wrong!");
            }

        }

    }

    static void commands() {
        System.out.println("--------------Commands-----------------------");
        System.out.println("Press 1 to print catalog");
        System.out.println("Press 2 to Find a Movie by full or part name");
        System.out.println("Press 3 to sort by year");
        System.out.println("Press 4 to sort by name");
        System.out.println("Press 5 to sort by director");
        System.out.println("Press 6 to find movies by actor's name");
        System.out.println("Press 7 to find movies by director's name");
        System.out.println("Press 8 to find movies by year");
        System.out.println("Press 9 to List all movies and roles by actor's name");
        System.out.println("Press 10 to sorted List of all actors with his roles");
        System.out.println("---------------------------------------------");
    }

    static String button(){
        String word = new String("Choose a command: ");
        System.out.println(word);
        return word;
    }
}
