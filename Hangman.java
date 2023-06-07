import java.util.Scanner;
//import java.util.HashMap;
//import java.util.Map;


class Hangman {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in); 
        //HashMap<String, Integer> user = new HashMap<String, Integer>();

        String word = ""; 
        int length = 0; 
        String guess = "";
        String base = ""; 
        int numGuesses = 0; 
    
        //creating the word
        System.out.println("Choose a number between 1 and 5: "); 
        int choice =  scan.nextInt(); 
        //fix input error
        scan.nextLine();

        switch(choice){
            case 1:
                word = ("goodbye");
                break;
            case 2:
                word = ("chocolate");
                break;
            case 3:
                word = ("frisbee");
                break;
            case 4: 
                word = ("mango");
                break;
            case 5: 
                word = ("rat");
                break;
            default:
                word = ("goat");
        }
         

        length = word.length(); 
        numGuesses = word.length(); 
        
        for (int i = 0; i < length; i ++){
            base += "*"; 
        }

        char[] aWord = word.toCharArray();
        char[] aBase = base.toCharArray();
        
        //getting user's first guess 
        System.out.println("Word is: " + base); 
        System.out.println("Enter your guess: "); 
        guess = scan.nextLine();
        char[] aGuess = guess.toCharArray();
        //System.out.println(guess);

        //comparing the two words
        for (int i = 0; i < aWord.length; i++) {
            //if the letter is correct
            if (aWord[i] == (aGuess[i])){
                aBase[i] = aGuess[i]; 
            }

        }

        System.out.println(aBase);
        System.out.println(aWord);
        System.out.println(aGuess);



        scan.close(); 
        //System.out.println("Scanner Closed.");
    }



}
