package com.project.movies;

import java.util.ArrayList;


public class PopularMovies extends Movies{              // using inheritance 
    Movies m;
    int temp, top;

    public PopularMovies(Movies m1){
        m = m1;
        top = 6;
        m.resId = new ArrayList<>(m.movieId);           // copies movieId list to resId list
        m.resId = m.sortRate(m.resId);
        // System.out.println(id.subList(0, top));
    }


    public void displayPopular() {
        for(int i=0; i<top; i++){
            temp = m.resId.get(i)-1;
            System.out.println((i+1) + "." + m.title.get(temp) + " - " + m.year.get(temp));
        }
    }
}