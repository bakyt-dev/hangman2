package com.hangman.game;

public class HangmanDraw {


    private static final String[] HANGMAN_STAGES = {
            "+----+\n|    |\n|     \n|     \n|     \n|     \n==========",
            "+----+\n|    |\n|    O\n|     \n|     \n|     \n==========",
            "+----+\n|    |\n|    0\n|    |\n|     \n|     \n==========",
            "+----+\n|    |\n|    0\n|   /|\n|     \n|     \n==========",
            "+----+\n|    |\n|    0\n|   /|\\\n|     \n|     \n==========",
            "+----+\n|    |\n|    0\n|   /|\\\n|   / \n|     \n==========",
            "+----+\n|    |\n|    0\n|   /|\\\n|   / \\\n|     \n=========="
    };

    public void drawHangman(int wrongCount) {
        if (wrongCount >= 0 && wrongCount < HANGMAN_STAGES.length) {
            System.out.println(HANGMAN_STAGES[wrongCount]);
        }
    }

}
