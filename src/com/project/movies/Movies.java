package com.project.movies;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;


public class Movies {
    int i = 0;
    int n;
    Scanner sc;
    File obj;
    ArrayList<Integer> movieId = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> language = new ArrayList<>();
    ArrayList<Integer> year = new ArrayList<>();
    ArrayList<String> genres = new ArrayList<>();
    ArrayList<Double> rating = new ArrayList<>();
    ArrayList<String> director = new ArrayList<>();
    ArrayList<String> url = new ArrayList<>();

    public void readFile(String filePath, int n){      // function to read the data file and storing it in arraylists
        try{
            obj = new File(filePath);
            // object created to read the data file
            sc = new Scanner(obj);
            this.n = n;
            sc.nextLine();
            while (sc.hasNextLine() & i < this.n) {
                String[] line = sc.nextLine().split(",", 0);  
                movieId.add(i+1);
                title.add(line[0]);
                language.add(line[1]);
                year.add(Integer.parseInt(line[2]));
                genres.add(line[3]);
                rating.add(Double.parseDouble(line[4]));
                director.add(line[5]);
                url.add(line[6]);
                i++; 
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println("Couldn't read the file.\n" + e.getMessage());
        }
    }

    public void displayAll(){                          // function to list all the available movies
        for(int i=0; i<n; i++){
            System.out.print(movieId.get(i)+ ". " + title.get(i) + "\n");
        }
    }

    public void viewMovie(int no){                     // function to display the movie details
        System.out.println("\nDetails:");
        System.out.println("Title - " + title.get(no) + "\tYear - " + year.get(no));
        System.out.println("Directed By - " + director.get(no));
        System.out.println("Language - " + language.get(no) + "\tGenres - " + genres.get(no));
        System.out.println("Rating - " + rating.get(no));
        System.out.println("Watch Now - " + url.get(no));
    }

    public void sortRating(){
        
    }
}
