import java.util.Scanner;
import java.util.ArrayList;
/*import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;*/



class Wordle {
    public static void main(String args[]) {

        Users users = Users.restore();
        if (users == null)
          users = new Users();
    
        System.out.println ("Current users:\n" + users);

        User user;

      
          String name = Utils.input ("Enter your user name: ").trim().toLowerCase();
          
          if (users.usersHashmap.get(name) == null) { 
            user = new User(name, 0);
            users.usersHashmap.put(name, user);
            users.save();
            System.out.println ("Welcome!");
          } else {                                    
            user = users.usersHashmap.get(name);
            System.out.println ("Welcome back");
            System.out.println("Score: "+ user.score ); 
          } 
        
        
        System.out.println ("Updated users:\n" + users);
        Scanner scan = new Scanner(System.in); 
        //HashMap<String, Integer> user = new HashMap<String, Integer>();
        //user.put("User 1", 0);

        String word = ""; 
        int length = 0; 
        String guess = "";
        String base = ""; 
        int numGuesses = 0; 
        ArrayList<String> pastAttempts = new ArrayList<>();
        //String bestGuess = "";
        int guesses = 1;  
        boolean run = true;

        System.out.println("Welcome to Wordle 2.0. In this modified Wordle game, you can choose the length of your word (between 1 and 6).");
        System.out.println("The length of the word is also the number of attempts you get. If you choose a number not between 1-6, you will get a random word. ");
        System.out.println("After you input your guess, a result will be returned. A capital letter means that this letter appears in the secret word, and it’s in exactly the right place"); 
        System.out.println("A lowercase letter  means that this letter appears in the secret word, but it’s in the wrong spot within the word. Note that even if a letter appears twice in the guess but only once in the secret word, both letters will appear in the returned result."); 
        System.out.println("A '*' means that this letter does not appear in the secret word at all");

        //creating the word
        int choice = 0;

        /*
        try{
        
            System.out.println("Choose a number between 1 and 6: "); 
            choice =  scan.nextInt(); 
            //fix input error
            scan.nextLine();
        } catch(Exception e){
                System.out.println("I said 1-6 >:( )");
                choice = 7; 
            
        }
        */
        choice = Utils.inputIntRange("Choose a number between 1 and 6: ", Integer.MIN_VALUE, Integer.MAX_VALUE);

        switch(choice){ 
            case 1:
                word = ("a");
                break;
            case 2:
                word = ("to");
                break;
            case 3:
                word = ("cat");
                break;
            case 4: 
                word = ("rats");
                break;
            case 5: 
                word = ("trees");
                break;
            case 6:
                word = ("tyrant");
                break; 
            default:
                word = ("goat");
        }
    
        //System.out.println(word); 

        length = word.length(); 
        numGuesses = word.length(); 
        
        for (int i = 0; i < length; i ++){
            base += "*"; 
        }

        char[] aWord = word.toCharArray();
        char[] aBase = base.toCharArray();

        System.out.println("Word is: " + base); 
        
        while (numGuesses > 0 && run) {
            //prints past attempts

            System.out.println("Past Attempts: ");
            for (int i = 0; i < guesses - 1; i++){
                
                System.out.println(pastAttempts.get(i)); 
            }




            //getting user's first guess 
            //System.out.println("Best Guess: " + bestGuess); 
            System.out.print("Enter your guess: "); 
            guess = scan.nextLine();
            if (guess.equals(word)){
                run = false; 
                break; 
            
            }
            if (guess.length()!= word.length()){
                System.out.println("Your guess was not the correct length. Your guess must be " + word.length() + " long.");
                continue; 
            }

            char[] aGuess = guess.toCharArray();
        
            //comparing the two words
            for (int i = 0; i < aWord.length; i++) {
                //if the letter is in the word but not in the right position
                for (int k = 0; k < aGuess.length; k++){
                    if (aWord[i] == aGuess[k]){
                        aBase[k] = aGuess[k]; 
                    }

                }

                //if the letter is in the correct location
                if (aWord[i] == (aGuess[i])){
                    aBase[i] = Character.toUpperCase(aGuess[i]); 
                }


            }

            System.out.println("Returned word: " + String.valueOf(aBase));
            //bestGuess = String.valueOf(aBase); 

            pastAttempts.add(String.valueOf(aGuess) + " -> " + String.valueOf(aBase));

            guesses ++; 
            numGuesses --;

            //resets the console
            for (int i = 0; i < aBase.length; i++){
                    aBase[i] =  '*'; 
                }

            

            System.out.println("Number of guesses left: " + numGuesses);
            System.out.println("\n");




        }
    
        scan.close(); 

        System.out.println("\n");
        if (guess.equals(word)){
            System.out.println("Good job! The word was " + word); 
            user.score++;
            System.out.println("Your score is now " + user.score);
            users.save();
        }
        else{
            System.out.println("You ran out of guesses. The correct word was " + word); 
        }








       System.out.println("Updated Score:\n" + users);
}


}
