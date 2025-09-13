package com.hangman.game;

import java.util.HashSet;


public class GuessManager {

    private static final int MAX_HANGMAN_STAGES = 6;
    private HashSet<Character> correctGuesses;
    private HashSet<Character> incorrectGuesses;


    public GuessManager() {
        correctGuesses = new HashSet<>();
        incorrectGuesses = new HashSet<>();
    }

    public boolean hasBeenGuessed(char letter) {
        return (correctGuesses.contains(letter) || incorrectGuesses.contains(letter));
    }

    public void addCorrectGuess(char letter) {
        correctGuesses.add(letter);
    }

    public void addIncorrectGuess(char letter) {
        incorrectGuesses.add(letter);
    }

    public boolean isGameOver() {
        return getWrongGuessCount() == MAX_HANGMAN_STAGES;
    }

    public int getWrongGuessCount() {
        return incorrectGuesses.size();
    }



}
