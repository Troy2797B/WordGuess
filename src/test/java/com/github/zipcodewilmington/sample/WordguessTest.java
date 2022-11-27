package com.github.zipcodewilmington.sample;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordguessTest {
    String [] wordsToGuess= {"run", "cat", "hen", "fig", "god", "dog", "fun", "fit", "rub",
                "pet", "jug", "bed", "zip", "van", "ivy", "few", "cop", "icy", "gas", "pot"};
    Wordguess g = new Wordguess();

    @Test
    public void chooseRandomWordTest(){
        String word = g.chooseRandomWord();
        assertNotNull(word);
    }
    @Test
    public void randomWordToCharArrayTest(){
        char[] actual = g.randomWordToCharArray();
        assertTrue(actual.length == 3);
    }
    @Test
    public void checkIfPlayerGuessIsALetterTest(){

    }
}