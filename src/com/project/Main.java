package com.project;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

class Movies{

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

    void readFile(String filePath, int n){      // function to read the data file and storing it in arraylists
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

    void displayAll(){                          // function to list all the available movies
        for(int i=0; i<n; i++){
            System.out.print(movieId.get(i)+ ". " + title.get(i));
            System.out.println();
        }
    }


    void displayByYear(int y){
        for(int i=0; i<n; i++){
            
        }
    }

    void viewMovie(int no){                     // function to display the movie details
        System.out.println("\nDetails:");
        System.out.println("Title - " + title.get(no) + "\tYear - " + year.get(no));
        System.out.println("Directed By - " + director.get(no));
        System.out.println("Language - " + language.get(no) + "\tGenres - " + genres.get(no));
        System.out.println("Rating - " + rating.get(no));
        System.out.println("Watch Now - " + url.get(no));
    }
}


class PopularMovies extends Movies{             // using inheritance 
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

    void getMovie(int no){
        no-=1;
        temp = m.rating.indexOf(rates.get(no));
        // System.out.println(temp);
        m.viewMovie(temp);
    }
}


class RecentReleases extends Movies{            // using inheritance 
    Movies m;
    ArrayList<Integer> years;
    ArrayList<Integer> movieNo;
    int temp;

    RecentReleases(Movies m1){
        m = m1;
        movieNo = new ArrayList<>();
        years = new ArrayList<>();

        for(int i=0; i<m.n; i++){
            temp = m.year.get(i);
            if(!years.contains(temp)){
                years.add(temp);
            }
        }
        Collections.sort(years, Collections.reverseOrder());
        // System.out.println(years.subList(0, 5));
    }

    void dislayRecent(){
        int k=0;
        for(int i=0; i<5; i++){
            temp = years.get(i);
            for(int j=0; j<m.n; j++){
                if (m.year.get(j) == temp){
                    movieNo.add(m.movieId.get(i));
                    System.out.println(k+1 + "." + m.title.get(j) + " - " + m.year.get(j));
                    k++;
                }
                if(k==5){
                    break;
                }
            }
        }
    }

    void getMovie(int no){
        no-=1;
        temp = movieNo.get(no);
        // System.out.println(temp);
        m.viewMovie(temp);
    }
}


public class Main {
    public static void main(String[] args) {

        // loading the file
        int fileSize = 19;
        String filePath = "movies_data.csv";
        Movies m1 = new Movies();
        m1.readFile(filePath, fileSize-1);

        // initialising the objects
        PopularMovies p1 = new PopularMovies(m1);
        RecentReleases r1 = new RecentReleases(m1);
    

        // the start
        String ch = "n";
        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Movie Recommendation System");

        do{ // displaying the menu
            int movieN;
            System.out.println("\n1.Popular Films\n2.Recent Releases\n3.By Genre\n4.By Year\n5.All Movies\n0 - Exit");
            System.out.println("Enter a option to view movie list: ");
            choice = sc.nextInt();

            try {
                switch (choice) {           // using switchcase to implement menu
                    case 1:
                        System.out.println("\nTop 5 Most popular movies:");
                        p1.displayPopular();
                        System.out.println("\nEnter the movie number to view details:");
                        movieN = sc.nextInt();
                        p1.getMovie(movieN);
                        break;
                    case 2:
                        System.out.println("\nTop 5 Recent Releases:");
                        r1.dislayRecent();
                        System.out.println("\nEnter the movie number to view details:");
                        movieN = sc.nextInt();
                        r1.getMovie(movieN);
                        break;
                    case 5:
                        System.out.println("\nAll the available movies:");
                        m1.displayAll();
                        System.out.println("\nEnter the movie number to view details:");
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

        System.out.println("Thank you!🙂");
        sc.close();
    }
}
