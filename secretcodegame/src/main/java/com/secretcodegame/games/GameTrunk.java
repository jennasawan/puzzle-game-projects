package com.secretcodegame.games;

import java.util.Map;

public class GameTrunk {

    private SecretNumberGame numberGame;
    private SecretWordGame letterGame;
    private InstructionManual instructionManual;

    public GameTrunk() {
        numberGame = new SecretNumberGame();
        letterGame = new SecretWordGame();
        instructionManual = new InstructionManual();
    }

    private String historyLog;
    private int attemptNumber;

    public String getHistoryLog() {
        return historyLog;
    }

    public void setHistoryLog(String historyLog) {
        this.historyLog = historyLog;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public void setNumberAnswer() {
        numberGame.setNumberAnswer();
    }

    public void setWordAnswer(){
        letterGame.setWordAnswer();
    }

    public void printInstructions() {
        String instructions = instructionManual.getInstructions();
        System.out.println(instructions);
    }

    public String runNumberGame(String userGuess) {

        Map<Character, Integer> answerMap = numberGame.getNumberAnswer();

        char[] guess = userGuess.toCharArray();
        int tildeCount = 0;
        int exclamationCount = 0;
        int zeroesCount = 0;

        boolean isDigits = true;
        String result = "";

        for (int i = 0; i < userGuess.length(); i++) {
            if (!Character.isDigit(userGuess.charAt(i))) {
                isDigits = false;
            }
        }

        if ((userGuess.length() != 5) || (!isDigits)) {
            result = "\n***Don't do that. All guesses must consist of five digits.***";
            System.out.println(result);
        } else {
            for (int i = 0; i < guess.length; i++) {
                if (answerMap.containsKey(guess[i])) {
                    if (answerMap.get(guess[i]) == i) {
                        tildeCount++;
                    } else {
                        exclamationCount++;
                    }
                } else {
                    zeroesCount++;
                }
            }

            result = (userGuess + " : " + "~".repeat(tildeCount) + "!".repeat(exclamationCount) + "0".repeat(zeroesCount));
            addHistoryLog(result);

            if (tildeCount == 5) {
                System.out.println("\n**********************************");
                System.out.println("       YOU'RE A WINNER!    ");
                System.out.println("    The secret code was: " + userGuess);
                System.out.println("**********************************");
                System.out.println("  You won in " + getAttemptNumber() + " tries. Well done!");
                System.out.println("**********************************");
                result = "WINNER";
            }
        }
        return result;
    }

    public String runWordGame(String userGuess) {

        Map<Character, Integer> answerMap = letterGame.getWordAnswer();

        int tildeCount = 0;
        int exclamationCount = 0;
        int zeroesCount = 0;

        boolean isLetters = true;
        String result;

        for (int i = 0; i < userGuess.length(); i++) {
            if (!Character.isLetter(userGuess.charAt(i))) {
                isLetters = false;
            }
        }

        if((userGuess.length() != 5) || (!isLetters)) {
            result = "\n***Don't do that. All guesses must consist of five letters.***";
            System.out.println(result);
        } else {
            for (int i = 0; i < userGuess.length(); i++) {
                if (answerMap.containsKey(userGuess.charAt(i))){
                    if (answerMap.get(userGuess.charAt(i)) == i) {
                        tildeCount++;
                    } else {
                        exclamationCount++;
                    }
                } else {
                    zeroesCount++;
                }
            }
            result = (userGuess + " : " + "~".repeat(tildeCount) + "!".repeat(exclamationCount) + "0".repeat(zeroesCount));
            addHistoryLog(result);

            if (tildeCount == 5) {
                System.out.println("\n**********************************");
                System.out.println("       YOU'RE A WINNER!    ");
                System.out.println("    The secret word was: " + userGuess);
                System.out.println("**********************************");
                System.out.println("  You won in " + getAttemptNumber() + " tries. Well done!");
                System.out.println("**********************************");
                result = "WINNER";
            }
        }
        return result;
    }

    public void addHistoryLog(String newGuess){
       String history = getHistoryLog() + "\n" + newGuess;
       setHistoryLog(history);
       setAttemptNumber(getAttemptNumber() + 1);
    }
}




