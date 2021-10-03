package com.project.movies;


public class ByGenre extends Movies {               // using inheritance 
    Movies m;
    int temp;
    String[] user_genre;
    
    public ByGenre(Movies m1){
        m = m1;
    }


    // function to list the movies based on the given genre
    public void displayByGenre(String userGenre){    
        // parsing the user input genres 
        userGenre = userGenre.toLowerCase();
        if(userGenre.contains(",")){
            user_genre = userGenre.split(",");
        } else {
            user_genre = new String[1];
            user_genre[0] = userGenre;
        }

        // getting only the movies having same genre as user input genre
        String movieGenre;
        m.resId.clear();                                //clearing the previous id list
        for(int i=0; i<m.n; i++){
            movieGenre = m.genres.get(i).toLowerCase();
            for(int j=0; j<user_genre.length; j++){
                if(movieGenre.contains(user_genre[j]) && !m.resId.contains(m.movieId.get(i))){
                    m.resId.add(m.movieId.get(i)); 
                }
            }
        }

        m.resId = m.sortRate(m.resId);

        // displaying the movies list
        for(int i=0; i<m.resId.size(); i++){
            temp = m.resId.get(i)-1;
            System.out.print((i+1) + ". " + m.title.get(temp) + "\n");
        }
    }
}
