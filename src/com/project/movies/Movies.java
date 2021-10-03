package com.project.movies;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;


interface Movie{
    void readFile(String filePath, int n);
    void writeFile();
    void viewMovie(int no);
    void displayAll();
}


public class Movies implements Movie{
    int i = 0;
    int n;
    Scanner sc;
    FileWriter fw;
    File obj;

    // initialising all the attributes in the file
    public ArrayList<Integer> movieId = new ArrayList<>();             
     ArrayList<String> title = new ArrayList<>();
    ArrayList<String> language = new ArrayList<>();
    ArrayList<Integer> year = new ArrayList<>();
    ArrayList<String> genres = new ArrayList<>();
    public ArrayList<Double> rating = new ArrayList<>();
    public ArrayList<Integer> votes = new ArrayList<>();
    ArrayList<String> director = new ArrayList<>();
    ArrayList<String> url = new ArrayList<>();
    public ArrayList<Integer> resId = new ArrayList<>();


    // reading the data file and storing it in arraylists
    public void readFile(String filePath, int n){           
        try{
            obj = new File(filePath);
            // object created to read the data file
            sc = new Scanner(obj);
            this.n = n;
            sc.nextLine();                                      // skiping the 1st row in file (attributes line)
            while (sc.hasNextLine() & i < this.n) {
                String[] line = sc.nextLine().split(",", 0);  
                movieId.add(i+1);
                title.add(line[0]);
                language.add(line[1]);
                year.add(Integer.parseInt(line[2]));
                genres.add(line[3]);
                rating.add(Double.parseDouble(line[4]));
                votes.add(Integer.parseInt(line[5]));
                director.add(line[6]);
                url.add(line[7]);
                i++; 
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println("Couldn't read the file.\n" + e.getMessage());
        }
    }


     // function to list all the available movies
    public void displayAll(){                         
        resId.clear();                      //clearing the previous id list
        for(int i=0; i<n; i++){
            System.out.print(movieId.get(i)+ ". " + title.get(i) + "\n");
        }
        resId = new ArrayList<>(movieId);
    }


    // function to display the movie details
    public void viewMovie(int no){      
        int temp;
        temp = resId.get(no-1)-1;
        // System.out.println(resId);
        // System.out.println(movieId);
        // System.out.println(title);
        System.out.println("\nDetails:");
        System.out.println("Title - " + title.get(temp) + "\tYear - " + year.get(temp));
        System.out.println("Directed By - " + director.get(temp));
        System.out.println("Language - " + language.get(temp) + "\tGenres - " + genres.get(temp));
        System.out.println("Rating - " + rating.get(temp) + "\tVotes - " + votes.get(temp));
        System.out.println("Watch Now - " + url.get(temp));
    }


    // sorting the given movieid list with respect to its rating and returns sorted id list
    public ArrayList<Integer> sortRate(ArrayList<Integer> x) {
        ArrayList<Double> y = new ArrayList<Double>();
        int tempi;
        double tempd;

        for(int i=0; i<x.size(); i++){
            y.add(rating.get(x.get(i)-1));
        }
        // System.out.println(x);
        // System.out.println(y);

        for (int i=0; i<x.size()-1; i++) {
            for (int j=i+1; j<x.size(); j++) {
                if (y.get(i).compareTo(y.get(j)) < 0) {             // comparing the rating elements using selection sort
                    //... Exchange elements in first array
                    tempi = x.get(i);
                    x.set(i, x.get(j));
                    x.set(j, tempi);
    
                    //... Exchange elements in second array
                    tempd = y.get(i);
                    y.set(i, y.get(j));
                    y.set(j, tempd);
                }
            }
        }
        // System.out.println(x);
        // System.out.println(y);
        return x;
    }

    
    public void writeFile(){
        try {
            fw = new FileWriter("data.csv");
            fw.write("title,language,year,genres,rating,votes,director,url\n");
            for(int i=0; i<n; i++){
                fw.write(title.get(i) + ",");
                fw.write(language.get(i) + ",");
                fw.write(year.get(i) + ",");
                fw.write(genres.get(i) + ",");
                fw.write(rating.get(i) + ",");
                fw.write(votes.get(i) + ",");
                fw.write(director.get(i) + ",");
                fw.write(url.get(i));
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
