package com.project.movies;

import java.util.ArrayList;


public class ByGenre extends Movies {
    Movies m;
    int temp;
    ArrayList<Integer> id;
    String[] user_genre;
    
    public ByGenre(Movies m1){
        m = m1;
        id = new ArrayList<>();
    }

    public void displayByGenre(String userGenre){      // function to list the movies based on the given genre
        userGenre = userGenre.toLowerCase();
        if(userGenre.contains(",")){
            user_genre = userGenre.split(",");
        } else {
            user_genre = new String[1];
            user_genre[0] = userGenre;
        }

        String movieGenre;
        id.clear();
        int k=1;
        
        for(int i=0; i<m.n; i++){
            movieGenre = m.genres.get(i).toLowerCase();
            for(int j=0; j<user_genre.length; j++){
                if(movieGenre.contains(user_genre[j]) && !id.contains(m.movieId.get(i))){
                    System.out.print(k + ". " + m.title.get(i) + "\n");
                    k++;
                    id.add(m.movieId.get(i)); 
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
