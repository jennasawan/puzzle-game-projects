package com.secretcodegame.games;

import java.util.*;

public class SecretWordGame {

    public SecretWordGame(){};

    private Map<Character, Integer> wordAnswer;

    public Map<Character, Integer> getWordAnswer() {
        return wordAnswer;
    }

    public void setWordAnswer() {
        this.wordAnswer = generateRandomWord();
    }

    public Map<Character, Integer> generateRandomWord() {

        List<String> words = Arrays.asList(
                "clown",
                "bikes",
                "house",
                "based",
                "laugh",
                "night",
                "party",
                "empty",
                "dance",
                "chair",
                "frank",
                "rainy",
                "debut",
                "judge",
                "grove",
                "movie",
                "alive",
                "tired",
                "drawn",
                "waved",
                "liked",
                "cakes",
                "snake",
                "prawn",
                "forks",
                "weird",
                "kites",
                "thumb",
                "beast",
                "plank",
                "vines",
                "cramp",
                "heart",
                "crumb",
                "lunch",
                "bunch",
                "punch",
                "cream",
                "charm",
                "lucky",
                "ducks",
                "frame",
                "shame",
                "track",
                "smack",
                "trash",
                "pants",
                "polka",
                "razor",
                "laser",
                "shove",
                "shave",
                "poker",
                "yikes",
                "bites");

        Collections.shuffle(words);

        String randomWord = words.get(0);

        Map<Character, Integer> answerMap = new HashMap<>();

        for (int i = 0; i < randomWord.length(); i++) {
            answerMap.put(randomWord.charAt(i), i);
        }

        return answerMap;
    }

}
