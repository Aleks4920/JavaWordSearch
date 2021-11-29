/**
* Author: Aleksandr Zheleznov
* description: This is my final project for comp 1030
* This project can create a word search puzzle of any size with any number of words in it
* Date: nov 19,2021 
* Time: 13:30
*/
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Random;
import java.util.Scanner;

public class AddWords {
    
    private char word[];
    private int direction;
    private int positionX;
    private int positionY;
    private boolean tryAgain = true;
    private int count = -1;
    private String[] dict = new String[200];

    


    public char[][] addWords(char gridLetters[][], int size, int words){

        

        boolean success =false;
        Random random = new Random();

        //reads a file called dict.txt, each line is treated as a word, and
        // is added to the dict String array
        try{
            Scanner inFile = new Scanner(new File("dict.txt"));
            while(inFile.hasNext()){
    
                dict[++count] = inFile.nextLine();
            }
            if(count > 0){
                inFile.close();
            }else{
                System.exit(0);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        

        
        
        int j = 0;
        //this block attempts to place a randomly chosen word into a random position 
        // with a random orreantation 
        do{
            tryAgain = true;
            direction = random.nextInt(1,9);
            positionX = random.nextInt(size);
            positionY = random.nextInt(size);
            
            word = dict[random.nextInt(count)].replaceAll("\\s+","").toCharArray();
           
            while(tryAgain){
                // LR = 1, RL = 2, UD = 3, DU 4, DL = 5, UL = 6, DR = 7, DL = 8 

                switch(direction){

                    // Left to right 
                    case 1:
                        
                        try{
                            //check if word can fit
                            for(int i=0; i < word.length; i++){  
                                if(gridLetters[positionY][positionX + i] != word[i] && gridLetters[positionY][positionX + i] != '\u0000'){
                                    //if word cant fit rotate and try again
                                    direction++;
                                    continue;
                                }                                                   
                            }
                            //if word fits place it in
                            for(int i=0; i < word.length; i++){                  
                                gridLetters[positionY][positionX + i] = word[i];                                   
                            }
                        //if word cant fit rotate and try again
                        }catch(ArrayIndexOutOfBoundsException e){
                            direction++;
                            continue;
                        }
                        break;

                    // right to left
                    case 2:
                        
                        try{
                            for(int i=0; i < word.length; i++){  
                                if(gridLetters[positionY][positionX - i] != word[i] && gridLetters[positionY][positionX - i] != '\u0000'){
                                    direction++;
                                    continue;
                                }                                                  
                            }
                            for(int i=0; i < word.length; i++){                  
                                gridLetters[positionY][positionX - i] = word[i];                                    
                            }
                        }catch(ArrayIndexOutOfBoundsException e){
                            direction++;
                            continue;
                        }
                        break;

                    // up to down
                    case 3:
                        
                        try{
                            for(int i=0; i < word.length; i++){  
                                if(gridLetters[positionY+i][positionX] != word[i] && gridLetters[positionY+i][positionX] != '\u0000'){
                                    direction++;
                                    continue;
                                }                                                    
                            }
                            for(int i=0; i < word.length; i++){                    
                                gridLetters[positionY+i][positionX] = word[i];                                      
                            }
                        }catch(ArrayIndexOutOfBoundsException e){
                            direction++;
                            continue;
                        }
                        break;

                    // down to up
                    case 4:
                        
                        try{
                            for(int i=0; i < word.length; i++){  
                                if(gridLetters[positionY-i][positionX] != word[i] && gridLetters[positionY-i][positionX] != '\u0000'){
                                    direction++;
                                    continue;
                                }                                                   
                            }
                            for(int i=0; i < word.length; i++){                   
                                gridLetters[positionY-i][positionX] = word[i];                  
                            }
                        }catch(ArrayIndexOutOfBoundsException e){
                            direction++;
                            continue;
                        }
                        break;

                    // down left
                    case 5: 
                        
                        try{
                            for(int i=0; i < word.length; i++){  
                                if(gridLetters[positionY+i][positionX + i] != word[i] && gridLetters[positionY+i][positionX + i] != '\u0000'){
                                    direction++;
                                    continue;
                                }                                                     
                            }
                            for(int i=0; i < word.length; i++){                   
                                gridLetters[positionY+i][positionX + i] = word[i];      
                            }
                        }catch(ArrayIndexOutOfBoundsException e){
                            direction++;
                            continue;
                        }
                        break;

                    // down right
                    case 6:
                        
                        try{
                            for(int i=0; i < word.length; i++){  
                                if(gridLetters[positionY+i][positionX-1] != word[i] && gridLetters[positionY+i][positionX-1] != '\u0000'){
                                    direction++;
                                    continue;
                                }                                                    
                            }
                            for(int i=0; i < word.length; i++){                    
                                gridLetters[positionY+i][positionX-1] = word[i];                                       
                            }
                        }catch(ArrayIndexOutOfBoundsException e){
                            direction++;
                            continue;
                        }
                        break;

                    // up right
                    case 7:
                       
                        try{
                            for(int i=0; i < word.length; i++){  
                                if(gridLetters[positionY-i][positionX+i] != word[i] && gridLetters[positionY-i][positionX+i] != '\u0000'){
                                    direction++;
                                    continue;
                                }                                                      
                            }
                            for(int i=0; i < word.length; i++){                   
                                gridLetters[positionY-i][positionX+i] = word[i];                                       
                            }
                        }catch(ArrayIndexOutOfBoundsException e){
                            direction++;;
                            continue;
                        }
                        break;
                    
                    // up to left
                    case 8:
                        
                        try{
                            for(int i=0; i < word.length; i++){  
                                if(gridLetters[positionY-i][positionX-i] != word[i] && gridLetters[positionY-i][positionX-i] != '\u0000'){
                                    //if word cant fit rotate and pick a new position and try again
                                    direction = random.nextInt(1,9);
                                    positionX = random.nextInt(size);
                                    positionY = random.nextInt(size);
                                    continue;
                                }                                                
                            }
                            for(int i=0; i < word.length; i++){                   
                                gridLetters[positionY-i][positionX-i] = word[i];  
                            }
                        }catch(ArrayIndexOutOfBoundsException e){
                            //if word cant fit rotate and pick a new position and try again
                            direction = random.nextInt(1,9);
                            positionX = random.nextInt(size);
                            positionY = random.nextInt(size);
                            continue;
                        }
                        break;
                    default:
                        direction = 1;
                        continue;
                }
                //print word and position to user
                System.out.print(word);
                System.out.println("- "+ (positionX+1) + "," +(positionY+1) );
                tryAgain = false;
            }//end while

            j++;
        }while(j < words);
        return gridLetters;
    }

}