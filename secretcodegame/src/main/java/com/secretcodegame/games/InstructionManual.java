package com.secretcodegame.games;

public class InstructionManual {

    InstructionManual(){};

    public String getInstructions() {

        return "\nThe goal of this game is to guess the secret five-digit or five-letter code. After you submit a guess, the amount of digits or letters you got correct will be indicated in the following way: " +
                "\n     Digits/letters that are in the correct place will be denoted with a ~. Digits/letters that are in the solution but are in the incorrect place will be denoted with an !. " +
                "\n     Any digits or letters in your guess that are not in the solution will remain 0s." +
                "\n     Example: " +
                "\n     The secret answer: 39254" +
                "\n     Your guess: 59421 " +
                "\n     Your result: ~!!!0" +
                "\nYour result indicates one of your digits is in the correct place (9), three of your digits are in the code but are in the incorrect place (5, 4, 2), and one of your digits is nowhere in the solution (1). " +
                "\nNote that the position of the ~, !, and 0 symbols is not related to the position of the digit it is based on (i.e., the ~ symbol does not necessarily mean the 5 is the number that is in the correct place). " +
                "\nThe secret code will consist of non-repeating numbers 1 through 9, or five case-insensitive letters that make up a real word. Have fun!" +
                "\n To quit your game at any time, just type 'I quit'. "+
                "\n\nReady to play? Enter 'Y' to go to the game menu, or enter anything else to go back to the main menu: ";
    }

}
