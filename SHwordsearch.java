// Programmer name: Shelby Hahn
// Date: 5/30/22
// Class: CS 145
// Assignment: 1 - Word Search
// Purpose: To take words from user and turn them into a word search game


import java.util.*;


public class SHwordsearch{
  
  //intializations
  private static int width;
  private static int length;
  private static int wordCount;
  private static  ArrayList<String> words;
  private static  int[] positions;
  private static char [][] search; 
  private  static String input;

 
  //begin main method
  public static void  main  (String [] args){
      Scanner input = new Scanner(System.in);

      generate();
      print();
    
  }
  
 
  //Prints the finished wordsearch
  public static void print(){
    for(int i =0; i <width; i++){
      for(int ind =0; ind<length; ind ++){
        System.out.print(search[i][ind]+ " ");
      }
      System.out.println(" "); 
    }
    System.out.println();
  }
 
 
  //Creates the wordsearch
  public static void generate(){
    System.out.println("Welcome to my word search generator!");
    System.out.println("This program will create a word search based on words of your choice.");
    System.out.println();
    printIntro();
    takeInput();
    measurements();
    fill();
  }
  
  //Fills up the search array, applies the inputted words, 
  //and randomly generates the rest of the characters.
  public static void fill(){
    int between,  strlength;
    int x, y ;
    positions = new int[wordCount]; 
    for(int i =0; i < wordCount; i++){ //for each word in list
      strlength = words.get(i).length();
      between = width -strlength; 
      x = randomRange(0, between);   
      y = randomRange(0, length-5); 
      positions[i] = y; 
      for(int ind =0; ind <strlength; ind++){   // for each letter in the word, 
        search[x][y] = words.get(i).charAt(ind); //put char into search array
        x++;
      } 
    }
    // fill empty slots
    for (int i =0; i <length; i ++){
      for (int ind =0; ind< width; ind++){
        if(search[ind][i] == 0){
          char t = (char) randomRange(97, 122); 
          search[ind][i] = t;
        }
      }
    }
    
  }//end method
  

  //random number genertator for values 
  public static int randomRange(int low, int high){ 
    Random generator = new Random();
    return generator.nextInt(high-low+1) + low;
  } //end method
  

  //Takes user input and processes it 
  public static void takeInput(){
    Scanner scan = new Scanner(System.in);
    wordCount =0; 
    words=  new ArrayList<String>(); 
    System.out.println("Enter the words you want to look for! Type each word on its own line." );
    System.out.println("Enter 'end' when you're finished.");
    while (scan.hasNextLine()){
      input = scan.next(); 
      if(input.equals("end")){
        scan.close();
        break;
      }
      wordCount++;
      words.add(input);
    }
  }//end method
  

  //Calculates size of the char array the word search uses. 
  public static void measurements(){
    System.out.println("Creating the word search...");
    int i;
    for(i =0; i<words.size(); i++){
      if(words.get(i).length() > width){
        width = words.get(i).length();
      }
    }
    width = width *2; 
    length = width + (width/3);
    search = new char [width][length]; 
  }
  
  
  //begin printIntro method
  public static String printIntro() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please select an option: ");
        System.out.println("Generate a new word search (g)");
        System.out.println("Print out your word search (p)");
        System.out.println("Show the solution to your word search (s)");
        System.out.println("Quit the program (q)");
        String response = input.next();
        return response;
  }

    
}//end wordsearch class