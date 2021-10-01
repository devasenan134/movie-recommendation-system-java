package com.project.movies;

import java.util.ArrayList;


public class ByYear extends Movies{
    Movies m;
    int temp;
    ArrayList<Integer> id;

    public ByYear(Movies m1){
        m = m1;
        id = new ArrayList<>();
    }

    public void displayByYear(int y){
        id.clear();
        int k=1;
        for(int i=0; i<m.n; i++){
            if(m.year.get(i) == y){
                System.out.print(k + ". " + m.title.get(i) + "\n");
                id.add(m.movieId.get(i));
                k++;
            }
        }
    }

    public void getMovie(int no){
        no -= 1;
        temp = id.get(no)-1;
        // System.out.println(id);
        m.viewMovie(temp);
    }
}
