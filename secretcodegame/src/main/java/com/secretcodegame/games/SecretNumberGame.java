package com.secretcodegame.games;

import java.util.*;

public class SecretNumberGame {

    public SecretNumberGame() {}

    private Map<Character, Integer> numberAnswer;

    public Map<Character, Integer> getNumberAnswer() {
        return numberAnswer;
    }

    public void setNumberAnswer() {
        this.numberAnswer = generateRandomNumber();
    }

    public Map<Character, Integer> generateRandomNumber() {
            String randomNumberString = "";
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
            Collections.shuffle(numbers);

            randomNumberString = String.valueOf(numbers.get(0));
            randomNumberString += String.valueOf(numbers.get(1));
            randomNumberString += String.valueOf(numbers.get(2));
            randomNumberString += String.valueOf(numbers.get(3));
            randomNumberString += String.valueOf(numbers.get(4));

            char[] randomArray = randomNumberString.toCharArray();

            Map<Character, Integer> answerMap = new HashMap<>();

            for (int i = 0; i < randomArray.length; i++) {
                answerMap.put(randomArray[i], i);
            }

            return answerMap;
        }

    }


