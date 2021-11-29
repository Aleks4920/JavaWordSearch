/**
* Author: Aleksandr Zheleznov
* description: This is my final project for comp 1030
* This project can create a word search puzzle of any size with any number of words in it
* Date: nov 19,2021 
* Time: 13:30
*/
import java.util.Random;

public class FillGrid {
    private String lett = "abcdefghijklmnopqrstuvwxyz";
    Random random = new Random();




    public char[][] fillGrid(char gridLetters[][]){

        //loop through every position of grid letters and give every empty space 
        //the value of a random letter
        for (int row = 0; row < gridLetters.length; row++){
            for (int col = 0; col < gridLetters[row].length; col++){
                if(gridLetters[row][col] == '\u0000' ||gridLetters[row][col] == ' '){
                    gridLetters[row][col] = lett.charAt(random.nextInt(26)); 
                }
                
            }
        }

        
        return gridLetters;
    }
}
