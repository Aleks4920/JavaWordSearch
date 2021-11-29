/**
* Author: Aleksandr Zheleznov
* description: This is my final project for comp 1030
* This project can create a word search puzzle of any size with any number of words in it
* Date: nov 19,2021 
* Time: 13:30
*/
public class CreateWordSearch {

    private char gridLetters[][];
    private int size;
    private String gridLayout = "";
    private int words;

    public String createWordSearch(int seed){

        //find size and number of words needed from seed
        size = (seed/10000);
        words = Integer.parseInt(String.valueOf(seed).substring(2,3));

        //create a char array of size specified by seed
        gridLetters = new char[size][size];


        // create new instances of AddWords and FillGrid and then
        //use them to manipulate gridletters
        AddWords add = new AddWords();
        FillGrid fill = new FillGrid();

        gridLetters = add.addWords(gridLetters, size, words);
        gridLetters = fill.fillGrid(gridLetters);

        //change gridLetters (a char array) into a string
        for (int row=0; row <= size-1; row++){
            for (int col=0; col <= size-1; col++){
                gridLayout += gridLetters[row][col] + " " ;
            }
            gridLayout += "\n";
        }

        return gridLayout;
    }
    

    
    public int getSize() {
        return size;
    }

 
    public void setSize(int size) {
        this.size = size;
    }
}
