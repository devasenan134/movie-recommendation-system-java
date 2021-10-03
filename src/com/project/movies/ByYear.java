package com.project.movies;


public class ByYear extends Movies{
    Movies m;
    int temp;

    public ByYear(Movies m1){
        m = m1;
    }


    public void displayByYear(int y){
        m.resId.clear();                     //clearing the previous id list
        for(int i=0; i<m.n; i++){
            if(m.year.get(i) == y){
                m.resId.add(m.movieId.get(i));
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
