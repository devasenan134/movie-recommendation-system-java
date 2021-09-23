package com.project;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


class MovieDataSet{

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
                String[] line = sc.nextLine().split("\t", 0);    
                titleId.add(line[0]);
                title.add(line[2]);
                genre.add(line[8]);
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



public class Main {
    public static void main(String[] args) {
        String filePath = "C:/Users/devas/Desktop/title.basics.tsv/data.tsv";
        MovieDataSet d1 = new MovieDataSet();
        d1.readFile(filePath, 20);
        d1.display();
    }
}
