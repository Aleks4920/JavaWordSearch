/**
* Author: Aleksandr Zheleznov
* description: This is my final project for comp 1030
* This project can create a word search puzzle of any size with any number of words in it
* Date: nov 19,2021 
* Time: 13:30
*/
import java.util.Random;


public class WordSearch {


    /* seed first 2 numbers of the seed are size
    * Third number is words to put in
    * then next two do not serve a purpose as of yet
    */
    private int seed;
    
    

    Random random = new Random();

    public WordSearch(){
        seed = random.nextInt(100101,141212);
        
    }

    //Not used as of this example, serves as an overloaded method if user were
    // to add their own seed
    public WordSearch(int userSeed){
        seed = userSeed;
    }

    public WordSearch(String seed){}

    
    //create grid method
    public String createGrid(){
        CreateWordSearch ws = new CreateWordSearch();
        return ws.createWordSearch(seed);
    }



    public int getSeed() {
        return seed;
    }


    public void setSeed(int seed) {
        this.seed = seed;
    }

 
    

}
