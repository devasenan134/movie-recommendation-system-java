package com.project.rating;

import java.util.Scanner;
import com.project.movies.Movies;


interface Rater{
    void setRate(int mn);
}

public class Rating extends Movies implements Rater {
    Movies m1;
    int temp;
    Scanner sc = new Scanner(System.in);


    public Rating(Movies m){
        m1 = m;   
    }


    public void setRate(int mn){
        double rate, newRate;
        int newVotes;
        temp = m1.resId.get(mn-1)-1;

        m1.viewMovie(mn);
        System.out.println("\nEnter your rating for this movie:");
        rate = sc.nextDouble();
        newRate = (m1.rating.get(temp)+rate)/2;
        newRate = Double.parseDouble(String.format("%.2f", newRate));
        newVotes = (m1.votes.get(temp) + 1);
        m1.votes.set(temp, newVotes);
        m1.rating.set(temp, newRate);
        m1.viewMovie(mn);
    }
}
