package com.company.services.impl;

import com.company.JsonIO;
import com.company.MyException;
import com.company.models.Director;
import com.company.models.Movie;
import com.company.services.SortAble;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SortAbleImpl implements SortAble {
    static Scanner sc = new Scanner(System.in);


    @Override
    public void printAllMovies() {
        List<Movie> list = JsonIO.getMovies();
        for (Movie m:list) {
            System.out.println(m);
            for (int i = 0; i < m.getCast().size(); i++) {
                System.out.println("Actor: "+m.getCast().get(i).getFullName() );
                System.out.println("Role: "+m.getCast().get(i).getRole() );
            }
            System.out.println("------------------");
        }
    }

    @Override
    public void findMovie() {
        System.out.println("Write movie name: ");
        String movieName = sc.nextLine().trim();
        List<Movie> list1 = JsonIO.getMovies();
        List<Movie> list2 = new LinkedList<>();
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getName().toUpperCase().contains(movieName.toUpperCase() ) ) {
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
    public void sortByYear() {
        System.out.println("Write movie Year:\nFirst method this, upwards: 1\n"+"Second method this, top down: 2");
        try {
            String year = sc.nextLine();
            if (Character.isDigit(year.charAt(0) ) ) {
                switch (year) {
                    case "1" -> sortUp();
                    case "2" -> topDown();
                    default -> System.out.println("Экиден ашык кпонпка жок");
                }
            }else {
                throw new RuntimeException();
            }
        }catch (RuntimeException e){
            System.out.println("Тамга жазганга болбойт!");
        }
    }
    public void sortUp () {
        List<Movie> list = JsonIO.getMovies();
        Collections.sort(list, Movie.sortStudentComparatorYear1);
        for (Movie m:list) {
            System.out.println(m);
            for (int i = 0; i < m.getCast().size(); i++) {
                System.out.println("Actor: "+m.getCast().get(i).getFullName() );
                System.out.println("Role: "+m.getCast().get(i).getRole() );
            }
            System.out.println("------------------");
        }
    }
    public void topDown () {
        List<Movie> list = JsonIO.getMovies();
        Collections.sort(list, Movie.sortStudentComparatorYear2);
        for (Movie m:list) {
            System.out.println(m);
            for (int i = 0; i < m.getCast().size(); i++) {
                System.out.println("Actor: "+m.getCast().get(i).getFullName() );
                System.out.println("Role: "+m.getCast().get(i).getRole() );
            }
            System.out.println("------------------");
        }
    }




    @Override
    public void sortByName() {
        System.out.println("Write movie Name:\nFirst method this, upwards: 1\n"+"Second method this, top down: 2");
        try {
            String name = sc.nextLine();
            if (Character.isDigit(name.charAt(0) ) ) {
                switch (name) {
                    case "1" -> sortNameUp();
                    case "2" -> sortNameDown();
                    default -> System.out.println("Экиден ашык кнопка жок!");
                }
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
        }
    }
    public void sortNameUp() {
        List<Movie> list = JsonIO.getMovies();
        Collections.sort(list, Movie.sortStudentComparatorName1);
        for (Movie m:list) {
            System.out.println(m);
            for (int i = 0; i < m.getCast().size(); i++) {
                System.out.println("Actor: "+m.getCast().get(i).getFullName() );
                System.out.println("Role: "+m.getCast().get(i).getRole() );
            }
            System.out.println("------------------");
        }
    }
    public void sortNameDown() {
        List<Movie> list = JsonIO.getMovies();
        Collections.sort(list, Movie.sortStudentComparatorName2);
        for (Movie m:list) {
            System.out.println(m);
            for (int i = 0; i < m.getCast().size(); i++) {
                System.out.println("Actor: "+m.getCast().get(i).getFullName() );
                System.out.println("Role: "+m.getCast().get(i).getRole() );
            }
            System.out.println("------------------");
        }
    }




    @Override
    public void sortByDirector() {
        System.out.println("Write movie Director name:\nFirst method this, upwards: 1\n"+"Second method this, top down: 2");
        try {
            String name = sc.nextLine();
            if (Character.isDigit(name.charAt(0) ) ) {
                switch (name) {
                    case "1" -> sortDirectorUp();
                    case "2" -> sortDirectorDown();
                    default -> System.out.println("Экиден ашык кнопка жок!");
                }
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
        }
    }
    public void sortDirectorUp() {
        List<Movie> list = JsonIO.getMovies();
        Collections.sort(list, Movie.sortStudentComparatorDirector1);
        for (Movie m:list) {
            System.out.println(m.getDirector().getFullName());
            for (int i = 0; i < m.getCast().size(); i++) {
                System.out.println("Actor: "+m.getCast().get(i).getFullName() );
                System.out.println("Role: "+m.getCast().get(i).getRole() );
            }
            System.out.println("------------------");
        }
    }
    public void sortDirectorDown() {
        List<Movie> list = JsonIO.getMovies();
        Collections.sort(list, Movie.sortStudentComparatorDirector2);
        for (Movie m:list) {
            System.out.println(m.getDirector().getFullName());
            for (int i = 0; i < m.getCast().size(); i++) {
                System.out.println("Actor: "+m.getCast().get(i).getFullName() );
                System.out.println("Role: "+m.getCast().get(i).getRole() );
            }
            System.out.println("------------------");
        }
    }
}
