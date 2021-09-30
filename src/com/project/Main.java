package com.project;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

class Movies{

    int i = 0, n;
    Scanner sc;
    File obj;
    ArrayList<Integer> movieId = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> language = new ArrayList<>();
    ArrayList<Integer> year = new ArrayList<>();
    ArrayList<String> genres = new ArrayList<>();
    ArrayList<Double> rating = new ArrayList<>();
    ArrayList<String> director = new ArrayList<>();

    void readFile(String filePath, int num){
        try{
            obj = new File(filePath);
            // System.out.println("obj created");
            sc = new Scanner(obj);
            n = num;
            sc.nextLine();
            while (sc.hasNextLine() & i < n) {
                String[] line = sc.nextLine().split(",", 0);  
                movieId.add(i+1);
                title.add(line[0]);
                language.add(line[1]);
                year.add(Integer.parseInt(line[2]));
                genres.add(line[3]);
                rating.add(Double.parseDouble(line[4]));
                director.add(line[5]);
                i++; 
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println("Couldn't read the file.\n" + e.getMessage());
        }
    }

    void display(){
        for(int i=0; i<n; i++){
            System.out.print(movieId.get(i)+ ". " + title.get(i));
            System.out.println();
        }
    }

    void viewMovie(int n){
        System.out.println("\nDetails:");
        System.out.println("Title - " + title.get(n) + "\tYear - " + year.get(n));
        System.out.println("Directed By - " + director.get(n));
        System.out.println("Language - " + language.get(n) + "\tGenres - " + genres.get(n));
        System.out.println("Rating - " + rating.get(n));
    }
}

class PopularMovies extends Movies{
    Movies m;
    ArrayList<Double> rates;
    int temp;

    PopularMovies(Movies m1){
        m = m1;
        rates = new ArrayList<>(m.rating);
        Collections.sort(rates, Collections.reverseOrder());
        // System.out.println(rates.subList(0, 5));
    }

    void displayPopular() {
        for(int i=0; i<5; i++){
            temp = m.rating.indexOf(rates.get(i));
            System.out.println(i+1 + "." + m.title.get(temp) + " - " + m.year.get(temp));
        }
    }

    void getMovie(int n){
        n-=1;
        temp = m.rating.indexOf(rates.get(n));
        // System.out.println(temp);
        m.viewMovie(temp);
    }
}

class RecentReleases extends Movies{
    void dislay_recent(){

    }
}


public class Main {
    public static void main(String[] args) {

        // loading the file
        int fileSize = 14;
        String filePath = "movies_data.csv";
        Movies m1 = new Movies();
        m1.readFile(filePath, fileSize-1);

        // initialising
        PopularMovies p1 = new PopularMovies(m1);

        // the menu
        String ch = "n";
        Scanner sc = new Scanner(System.in);
        System.out.println("Movie Recommendation System");

        do{
            int choice;
            int movieN;
            System.out.println("\n1.Popular Films\n2.Recent Releases\n3.By Genre\n4.By Year\n5.All Movies\n0 - Exit");
            System.out.println("Enter a option to view movie list: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.println("\nTop 5 Most popular movies:");
                        p1.displayPopular();
                        System.out.println("Enter the movie number to view details:");
                        movieN = sc.nextInt();
                        p1.getMovie(movieN);
                        break;
                    case 5:
                        System.out.println("\nAll the available movies:");
                        m1.display();
                        System.out.println("Enter the movie number to view details:");
                        movieN = sc.nextInt();
                        m1.viewMovie(movieN-1);
                        break;
                    default:
                        System.out.println("Bye!");
                        break;
                }
            } catch(Exception e) {
                System.out.println("Invalid Option. " + e.getMessage());
            }


            


            System.out.println("\nWant to continue exploring(Y/y): ");
            ch = sc.next();

        }while(ch.equalsIgnoreCase("y"));


        sc.close();
    }
}
