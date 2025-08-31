package com.hangman.game;


public class Main {
    public static void main(String[] args) {

        WordManager wm = new WordManager("words.txt");

        System.out.println(wm.getRandomWord());



    }
}