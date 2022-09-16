package com.company.models;

import java.util.Comparator;
import java.util.List;

public class Movie {

    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast;

    void printCast() {
        int counter = 1;
        for (Cast s : cast) {
            System.out.printf("%s)   Fullname: %s\n", counter, s.getFullName());
            System.out.println("     Role: " + s.getRole());
            counter++;
        }
    }

    public List<Cast> getCast() {
        return cast;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public Director getDirector() {
        return director;
    }

    public static Comparator<Movie> sortStudentComparatorName = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.name.compareTo(o2.name);
        }
    };

    public static Comparator<Movie> sortStudentComparatorYear1 = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.year - o2.year;
        }
    };
    public static Comparator<Movie> sortStudentComparatorYear2 = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return (o2.year) - (o1.year);
        }
    };



    public static Comparator<Movie> sortStudentComparatorName1 = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.name.compareTo(o2.name);
        }
    };
    public static Comparator<Movie> sortStudentComparatorName2 = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return (o2.name).compareTo(o1.name);
        }
    };



    public static Comparator<Movie> sortStudentComparatorDirector1 = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.name.compareTo(o2.name);
        }
    };
    public static Comparator<Movie> sortStudentComparatorDirector2 = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return (o2.name).compareTo(o1.name);
        }
    };



    @Override
    public String toString() {
        return  "Movies: " + '\n' +
                "Name: " + name + '\n' +
                "Year: " + year + '\n' +
                "Description: " + description + '\n' +
                "Director: "+director.getFullName();
    }
}
