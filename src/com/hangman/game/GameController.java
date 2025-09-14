package com.hangman.game;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Scanner;

public class GameController {

    private static final int MAX_WRONG_COUNT = 6;
    private HangmanDraw hangmanDraw;
    private WordManager wordManager;
    private GuessManager guessManager;
    private Scanner scanner;


    public GameController() {
        this.hangmanDraw = new HangmanDraw();
        this.wordManager = new WordManager();
        this.guessManager = new GuessManager();
        this.scanner = new Scanner(System.in);
    }

    public void initialPlayerChose() {
        System.out.println("\nWelcome to HANGMAN game!");
        System.out.println("\nWant to start a game? (Y/N): ");
        String initialGame = this.scanner.nextLine();

        if (initialGame.equals("Y") || initialGame.equals("y") || initialGame.equals("Yes") || initialGame.equals("yes")) {
            startGame();
        } else {
            System.out.println("\nThanks for playing!");
        }
        this.scanner.close();
    }

    public void startGame() {

        String randomWord = this.wordManager.getRandomWord();
        System.out.println(randomWord);

        while (!this.guessManager.isGameOver() &&
                !this.wordManager.isWordComplete(this.guessManager.getCorrectGuesses())) {

            this.hangmanDraw.drawHangman(this.guessManager.getWrongGuessCount());
            System.out.println("Current state of the word:");
            this.wordManager.displayWordState(this.guessManager.getCorrectGuesses());

            System.out.print("\nGuess a one English letter: ");
            String input = this.scanner.nextLine();

            if (input.isEmpty() || !input.matches(".*[a-zA-Z].*") || input.length() > 1) {
                System.out.print("\nGuess a one English letter: \n");
            } else {
                char playerGuess = input.toUpperCase().charAt(0);

                if (this.guessManager.hasBeenGuessed(playerGuess)) {
                    System.out.println("\nYou already guessed that letter!");
                } else {
                    if (this.wordManager.isLetterInTheWord(playerGuess)) {
                        this.guessManager.addCorrectGuess(playerGuess);
                    } else {
                        this.guessManager.addIncorrectGuess(playerGuess);
                    }
                }
            }
        }

        if (this.wordManager.isWordComplete(this.guessManager.getCorrectGuesses())) {
            System.out.println("\nMOLODEC! YOU WON!");
            System.out.println("The word was: " + randomWord);
            reStartGame();
        } else {
            System.out.println("\nGAME OVER! YOU LOST!");
            System.out.println("The word was: " + randomWord);
            this.hangmanDraw.drawHangman(MAX_WRONG_COUNT);
            reStartGame();
        }

        this.scanner.close();
    }


    private void reStartGame() {
        System.out.println("\nOne more time? (Y/N)");
        String playAgain = this.scanner.nextLine();

        if (playAgain.equals("Y") || playAgain.equals("y") || playAgain.equals("Yes") || playAgain.equals("yes")) {
            resetGame();
            startGame();
        } else {
            System.out.println("\nThanks for playing!");
        }
        this.scanner.close();
    }

    private void resetGame() {
        this.guessManager = new GuessManager();
        this.wordManager.getRandomWord();
    }


}
