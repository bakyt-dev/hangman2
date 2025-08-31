package com.hangman.game;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordManager {

    private static ArrayList<String> words;
    private static String randomWord = "";

    public WordManager(String filePath) {

        words = new ArrayList<>();

        try {
            File file = new File("src/com/hangman/game/words.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    words.add(line.toUpperCase());
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

    }

    public String getRandomWord() {
        randomWord = words.get((int)(Math.random() * words.size()));
        return randomWord;
    }




}
