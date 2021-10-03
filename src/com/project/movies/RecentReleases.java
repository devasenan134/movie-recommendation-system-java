package com.project.movies;

import java.util.ArrayList;
import java.util.Collections;


public class RecentReleases extends Movies{          // using inheritance 
    Movies m;
    ArrayList<Integer> years;  
    int temp, recent;

    public RecentReleases(Movies m1){
        m = m1;
        years = new ArrayList<>();
        recent = 6;

        // getting all years from the file and storing it in years list
        for(int i=0; i<m.n; i++){
            temp = m.year.get(i);
            if(!years.contains(temp)){
                years.add(temp);
            }
        }
        Collections.sort(years, Collections.reverseOrder());
    }

    // function to display recent released movies
    public void dislayRecent(){
        m.resId.clear();                        //clearing the previous id list
        int k=0;

        // comparing the years of all movies in file with the years list
        for(int i=0; i<recent; i++){
            temp = years.get(i);
            for(int j=0; j<m.n; j++){
                if (m.year.get(j) == temp){
                    m.resId.add(m.movieId.get(j));
                    System.out.println(k+1 + "." + m.title.get(j) + " - " + m.year.get(j));
                    k++;
                }
                if(k==recent){
                    break;
                }
            }
        }
    }
}
