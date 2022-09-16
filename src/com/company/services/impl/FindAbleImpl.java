package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Cast;
import com.company.models.Director;
import com.company.models.Movie;
import com.company.services.FindAble;
import com.company.services.SortAble;

import java.util.*;

public class FindAbleImpl implements FindAble {
    static Scanner sc = new Scanner(System.in);
    @Override
    public void findMoviesByActor() {
        System.out.println("Write the actor's name: ");
        String actorName = sc.nextLine().trim();
        List<Movie> list1 = JsonIO.getMovies();
        List<Movie> list2 = new LinkedList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.get(i).getCast().size(); j++) {
                if (list1.get(i).getCast().get(j).getFullName().toUpperCase().contains(actorName.toUpperCase() ) ) {
                    list2.add(list1.get(i) );
                }
            }
        }
        for (Movie m: list2) {
            System.out.println(m);
            for (int i = 0; i < m.getCast().size(); i++) {
                System.out.println("Actor: "+m.getCast().get(i).getFullName() );
                System.out.println("Role: "+m.getCast().get(i).getRole() );
            }
            System.out.println("------------------");
        }
    }

    @Override
    public void findMoviesByDirector() {
        System.out.println("Write the director's name: ");
        String directorName = sc.nextLine().trim();
        List<Movie> list1 = JsonIO.getMovies();
        List<Movie> list2 = new LinkedList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getDirector().getFullName().toUpperCase().contains(directorName.toUpperCase() ) ) {
                list2.add(list1.get(i) );
            }
        }
        for (Movie m: list2) {
            System.out.println(m);
            for (int i = 0; i < m.getCast().size(); i++) {
                System.out.println("Actor: "+m.getCast().get(i).getFullName() );
                System.out.println("Role: "+m.getCast().get(i).getRole() );
            }
            System.out.println("------------------");
        }
    }

    @Override
    public void findMoviesByYear() {
        int counter = 0;
        System.out.println("Write the year's movies: ");
        try {
            int year = sc.nextInt();

            List<Movie> list1 = JsonIO.getMovies();
            List<Movie> list2 = new LinkedList<>();
            if (year >= 2005 && year <= 2022) {
                for (int i = 0; i < list1.size(); i++) {
                    if (list1.get(i).getYear() == year) {
                        list2.add(list1.get(i) );
                        counter++;
                    }
                }
            } else {
                System.out.println("Мындай жылдагы фильм жок!");
            }

           if (counter > 0) {
               for (Movie m: list2) {
                   System.out.println(m);
                   for (int i = 0; i < m.getCast().size(); i++) {
                       System.out.println("Actor: "+m.getCast().get(i).getFullName() );
                       System.out.println("Role: "+m.getCast().get(i).getRole() );
                   }
                   System.out.println("------------------");
               }
           } else {
               throw new InputMismatchException();
           }
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Тамга жазганга болбойт!");
        }

    }

    @Override
    public void findMoviesAndRoleByActor() {
        int counter = 0;
        System.out.println("Write the actor's name: ");
        String actorName = sc.nextLine().trim();
        List<Movie> list1 = JsonIO.getMovies();
        List<Movie> list2 = new ArrayList<>();
        try {
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list1.get(i).getCast().size(); j++) {
                    if (list1.get(i).getCast().get(j).getFullName().toUpperCase().contains(actorName.toUpperCase() ) ) {
                        list2.add(list1.get(i) );
                        counter++;
                    }
                }
            }
            if (counter != 0) {
                for (Movie m:list2) {
                    System.out.println(m.getName() );
                    for (int i = 0; i < m.getCast().size(); i++) {
                        System.out.println("Name of actor: "+list1.get(i).getCast().get(i).getFullName() );
                        System.out.println("Name of role: "+list1.get(i).getCast().get(i).getRole() );
                        System.out.println("------------------");
                    }
                }
            } else {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            System.out.println("Ничего не найдено!");
        }
    }



    @Override
    public void showActorRoles() {
        int counter = 0;
        System.out.println("Write the actor's name for sorts: ");
        String actorName = sc.nextLine().toUpperCase().trim();
        List<Movie> list1 = JsonIO.getMovies();
        List<Movie> list2 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.get(i).getCast().size(); j++) {
                if (list1.get(i).getCast().get(j).getFullName().toUpperCase().contains(actorName) ) {
                    list2.add(list1.get(i) );
                    counter++;
                }
            }
        }
        try {
            if (counter != 0) {
                for (Movie m:list2) {
                    System.out.println("Name of movie"+m.getName() );
                    for (int i = 0; i < m.getCast().size(); i++) {
                        System.out.println("Role: "+m.getCast().get(i).getRole() );
                    }
                }
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("Ничего не найдено!");
        }

    }
}
