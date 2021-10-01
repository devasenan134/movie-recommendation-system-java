package com.project.movies;

import java.util.ArrayList;
import java.util.Collections;


public class RecentReleases extends Movies{          // using inheritance 
    Movies m;
    ArrayList<Integer> years;
    ArrayList<Integer> id;
    int temp, recent;

    public RecentReleases(Movies m1){
        m = m1;
        id = new ArrayList<>();
        years = new ArrayList<>();
        recent = 5;

        for(int i=0; i<m.n; i++){
            temp = m.year.get(i);
            if(!years.contains(temp)){
                years.add(temp);
            }
        }
        Collections.sort(years, Collections.reverseOrder());
        // System.out.println(years.subList(0, 5));
    }

    public void dislayRecent(){
        int k=0;
        id.clear();
        
        for(int i=0; i<recent; i++){
            temp = years.get(i);
            for(int j=0; j<m.n; j++){
                if (m.year.get(j) == temp){
                    id.add(m.movieId.get(j));
                    System.out.println(k+1 + "." + m.title.get(j) + " - " + m.year.get(j));
                    k++;
                }
                if(k==recent){
                    break;
                }
            }
        }
    }

    public void getMovie(int no){
        no-=1;
        temp = id.get(no)-1;
        // System.out.println(id);
        m.viewMovie(temp);
    }
}
