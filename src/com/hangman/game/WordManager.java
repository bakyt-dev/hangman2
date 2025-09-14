package com.hangman.game;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class WordManager {

    private static ArrayList<String> words;
    private String currentWord;

    public WordManager() {

        words = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader("src/com/hangman/game/words.txt"))) {

                while (scanner.hasNext()) {
                    words.add(scanner.next().toUpperCase());
                }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

    }

    public String getRandomWord() {
        String randomWord = words.get((int)(Math.random() * words.size()));
        currentWord = randomWord;
        return randomWord;
    }

    public boolean isWordComplete(HashSet<Character> revealedLetters) {
        int foundLetters = 0;

        for (char letter : currentWord.toCharArray()) {
           if (revealedLetters.contains(letter)) {
               foundLetters++;
           }
        }
        return foundLetters == currentWord.length();
    }

    public void displayWordState(HashSet<Character> revealedLetters) {
        String result = "";

        for (char letter : currentWord.toCharArray()) {
            if (revealedLetters.contains(letter)) {
                result = result + letter;
            } else {
                result = result + " _ ";
            }
        }
        System.out.println(result);
    }

    public boolean isLetterInTheWord(char revealedLetters) {
        return currentWord.contains(Character.toString(revealedLetters));
    }

}
