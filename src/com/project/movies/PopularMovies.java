package com.project.movies;

import java.util.ArrayList;
import java.util.Collections;


public class PopularMovies extends Movies{            // using inheritance 
    Movies m;
    ArrayList<Double> rates;
    int temp, top;

    public PopularMovies(Movies m1){
        m = m1;
        top = 5;
        rates = new ArrayList<>(m.rating);
        Collections.sort(rates, Collections.reverseOrder());
        // System.out.println(rates.subList(0, top));
    }

    public void displayPopular() {
        for(int i=0; i<top; i++){
            temp = m.rating.indexOf(rates.get(i));
            System.out.println(i+1 + "." + m.title.get(temp) + " - " + m.year.get(temp));
        }
    }

    public void getMovie(int no){
        no-=1;
        temp = m.rating.indexOf(rates.get(no));
        // System.out.println(temp);
        m.viewMovie(temp);
    }
}