/**
* Author: Aleksandr Zheleznov
* description: This is my final project for comp 1030
* This project can create a word search puzzle of any size with any number of words in it
* Date: nov 19,2021 
* Time: 13:30
*/
public class WordSearchTestHarness {
    
    public static void main(String args[]){

        //create new WordSearch object
        WordSearch grid = new WordSearch();

        // print seed and final grid
        System.out.println("Seed: "+grid.getSeed());
        System.out.println(grid.createGrid());
    }
}