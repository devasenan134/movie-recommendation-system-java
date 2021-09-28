package com.project;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


class Movies{

    int i = 0, n;
    Scanner sc;
    File obj;
    ArrayList<String> attribute = new ArrayList<>();
    ArrayList<String> titleId = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> language = new ArrayList<>();
    ArrayList<String> genre = new ArrayList<>();

    void readFile(String filePath, int num){
        try{
            obj = new File(filePath);
            sc = new Scanner(obj);
            n = num;
            while (sc.hasNextLine() & i < n) {
                String[] line = sc.nextLine().split(",", 0);    
                titleId.add(line[0]);
                title.add(line[2]);
                genre.add(line[3]);
                i++; 
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println("Couldn't read the file.");
        }
    }

    void display(){
        for(int i=0; i<n; i++){
            System.out.print(titleId.get(i) + ", " + title.get(i) + ", " + genre.get(i));
            System.out.println();
        }
    }
}

class PopularMovies extends Movies{
    void display_popular() {

    }
}

class RecentReleases extends Movies{
    void dislay_recent(){

    }
}


public class Main {
    public static void main(String[] args) {
        String filePath = "C:/Users/devas/Desktop/sem3/OOPs/movie-recommendation-system-java/movies_data.csv";
        Movies d1 = new Movies();
        d1.readFile(filePath, 1);
        d1.display();
    }
}
