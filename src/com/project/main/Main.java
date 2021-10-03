package com.project.main;
import com.project.movies.Movies;
import com.project.movies.PopularMovies;
import com.project.movies.RecentReleases;
import com.project.movies.ByGenre;
import com.project.movies.ByYear;
import com.project.rating.Rating;
import java.util.Scanner;



public class Main {

    public static void viewRrate(Movies m1){
        Scanner sc1 = new Scanner(System.in);
        Rating rr = new Rating(m1);
        int op, mn;
        
        System.out.println("\nPick a movie number");
        mn = sc1.nextInt();
        
        System.out.println("\n1.New Movie? - View Information\n2.Already watched the movie? - Give your rating");
        op = sc1.nextInt();

        if(op==1){
            m1.viewMovie(mn);
        } else if(op==2){
            rr.setRate(mn);
        }
        sc1.close();
    }


    public static void main(String[] args) {

        // loading the file
        int fileSize = 20;
        String filePath = "data.csv";
        Movies m1 = new Movies();
        m1.readFile(filePath, fileSize-1);

        // initialising the objects
        PopularMovies p1 = new PopularMovies(m1);
        RecentReleases r1 = new RecentReleases(m1);
        ByGenre g1 = new ByGenre(m1);
        ByYear y1 = new ByYear(m1);
        Rating r = new Rating(m1);
        
        // the start
        String ch = "n";
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--------------------Movie Recommendation System--------------------");

        do{ // displaying the menu
            System.out.println("\n1.Popular Films\n2.Recent Releases\n3.Based on your choice of Genre\n4.Based on Year of release\n5.All Movies\n6.Rate a movie\n0 - Exit");
            System.out.println("Choose a option to explore movies: ");
            try{
                choice = sc.nextInt();
            } catch (Exception e){
                System.out.println("Invalid choice!");
            }
            

            try {
                switch (choice) {           // using switchcase to implement menu
                    case 0:
                        System.out.println("Bye!");
                        break;
                    case 1:
                        System.out.println("\nTop 5 Most popular movies:");
                        p1.displayPopular();
                        viewRrate(m1);
                        break;
                    case 2:
                        System.out.println("\nTop 5 Recent Releases:");
                        r1.dislayRecent();
                        viewRrate(m1);
                        break;
                    case 3:
                        System.out.println("\nEnter your favorite Genre:");
                        g1.displayByGenre(sc.next());
                        viewRrate(m1);
                        break;
                    case 4:
                        System.out.println("\nSearch movies by year:");
                        y1.displayByYear(sc.nextInt());
                        viewRrate(m1);
                        break;
                    case 5:
                        System.out.println("\nAll the available movies:");
                        m1.displayAll();
                        viewRrate(m1);
                        break;
                    case 6:
                        System.out.println("\nAll the available movies:");
                        m1.displayAll();
                        System.out.println("\nPick a movie number");
                        r.setRate(sc.nextInt());
                        break;
                    default:
                        System.out.println("Try again!");
                        break;
                }
            } catch(Exception e) {
                System.out.println("Invalid Option!");
            }

        
            System.out.println("\nWant to continue exploring(Y/y): ");
            ch = sc.next();

        }while(ch.equalsIgnoreCase("y"));

        System.out.println("Thank you!🙂");
        m1.writeFile();                 //writing the changes to file
        sc.close();
    }
}
