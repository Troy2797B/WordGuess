package com.github.zipcodewilmington.sample;

import java.util.Random;
import java.util.Scanner;

public class Wordguess {
    //Troyanna LOL
    String[] wordsToGuess = {"run", "cat", "hen", "fig", "god", "dog", "fun", "fit", "rub", "pet", "jug", "bed", "zip", "van", "ivy", "few", "cop", "icy", "gas", "pot"};
    char[] playerGuess = {'_', '_', '_'};
    Scanner userInput = new Scanner(System.in);

    public String chooseRandomWord() {
        int random = new Random().nextInt(wordsToGuess.length);
        return wordsToGuess[random];
    }

    public char[] randomWordToCharArray() {
        return chooseRandomWord().toCharArray();
    }

    public boolean checkIfPlayerGuessIsALetter(String input) {
        //while it isn't the end and user didn't choose a letter yet
            //if the input is only one character long AND is a letter
            if (input.matches("[a-zA-Z]") && input.length() == 1) {
                //turn it into a char
//                input.charAt(0);
                return true;
            } else if (input.length() > 1) {
                System.out.println("Please enter only a letter");
                return false;
            } else if (!input.matches("[a-zA-Z]")) {
                System.out.println("Please enter a character in the alphabet.");
                return false;
            }
            return false;
    }

    public boolean checkIfGuessedLetterMatches(char playerLetter, char[] charArray){
        //loop through the given character array
        for (int i = 0; i < 3; i++){
            if (charArray[i] == playerLetter){
                return true;
            }
        } return false;
        //if the index matches, return true
    }

    public void replaceArrayElementWithCorrectLetter(char playerLetter, char [] randomWord){
        for(int i = 0; i < 3; i++){
            if (randomWord[i] == playerLetter){
                playerGuess[i] = playerLetter;
            }
        }
    }

    public void run(){
        //set the word
        char[] word = randomWordToCharArray();
        System.out.println(word);
        boolean end = false;
        int numberOfGuesses = 0;
        do {

            System.out.println("Guess a letter");
            String guess = userInput.nextLine();
             if (!checkIfPlayerGuessIsALetter(guess)){
                 //loops back to guess a letter
            } else if(checkIfPlayerGuessIsALetter(guess)){
                 //turn into a character
                 char playerLetter = guess.charAt(0);
                 System.out.println("You chose : "+ playerLetter + ".");
                 //then continue the game
                 //checking if the letter matches anything or not
                 if (!checkIfGuessedLetterMatches(playerLetter, word)){
                     numberOfGuesses++;
                     System.out.println("Too bad! You used "+ numberOfGuesses + " guess.");
                     break;
                 } else if (checkIfGuessedLetterMatches(playerLetter, word)){
                     replaceArrayElementWithCorrectLetter(playerLetter, word);
                     System.out.println(playerGuess);
                 }
             }
        } while (numberOfGuesses < 5 || !end);
    }

}
