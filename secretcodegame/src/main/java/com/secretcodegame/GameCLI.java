package com.secretcodegame;

import com.secretcodegame.games.GameTrunk;

import java.util.Scanner;

public class GameCLI {

    private static final String MAIN_MENU_OPTION_PLAY = "New Game";
    private static final String MAIN_MENU_OPTION_INSTRUCTIONS = "Instructions";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";

    private static final String GAME_MENU_OPTION_SECRET_CODE_NUMBERS = "Select Code Game: Numbers Edition";
    private static final String GAME_MENU_OPTION_SECRET_CODE_LETTERS = "Select Code Game: Word Edition";
    private static final String GAME_MENU_OPTION_BACK_TO_MAIN_MENU = "Back to the Main Menu";

    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_PLAY, MAIN_MENU_OPTION_INSTRUCTIONS, MAIN_MENU_OPTION_EXIT };
    private static final String[] GAME_MENU_OPTIONS = { GAME_MENU_OPTION_SECRET_CODE_NUMBERS, GAME_MENU_OPTION_SECRET_CODE_LETTERS, GAME_MENU_OPTION_BACK_TO_MAIN_MENU };

    private Scanner userInput;
    private GameTrunk gameTrunk;

    public GameCLI(){
        userInput = new Scanner(System.in);
    }

    public void run(){

        gameTrunk = new GameTrunk();
        boolean runMenu = true;
        String[] currentMenu = MAIN_MENU_OPTIONS;

        System.out.println("**********************************");
        System.out.println("\n Welcome to the Secret Code Game!");

        while(runMenu){

            displayMenu(currentMenu);

            System.out.print("\nWhat would you like to do?: ");
            String selection = userInput.nextLine();

            try{

                int selectionIndex = Integer.parseInt(selection) - 1;

                String menuOption = currentMenu[selectionIndex];

                switch(menuOption) {

                    case MAIN_MENU_OPTION_PLAY:
                        gameTrunk.setHistoryLog(" ");
                        gameTrunk.setNumberAnswer();
                        gameTrunk.setWordAnswer();
                        gameTrunk.setAttemptNumber(0);
                        currentMenu = GAME_MENU_OPTIONS;
                        break;

                    case MAIN_MENU_OPTION_INSTRUCTIONS:
                        gameTrunk.printInstructions();
                        String input = userInput.nextLine().strip().toUpperCase();
                        if (input.equals("Y")) {
                            currentMenu = GAME_MENU_OPTIONS;
                        }
                        break;

                    case MAIN_MENU_OPTION_EXIT:
                        runMenu = false;
                        System.out.println("\nThanks for playing! Or not playing. I don't know what you did. Bye!");
                        break;

                    case GAME_MENU_OPTION_SECRET_CODE_NUMBERS:
                        System.out.println("\n****************************************************");
                        System.out.println("            Secret Code: Numbers Edition");
                        System.out.print("****************************************************");
                        System.out.print("\nTo quit at any time, enter 'I quit'. Quitter.");


                        while (true) {
                            System.out.println(gameTrunk.getHistoryLog());
                            System.out.println("\nPlease enter your five-digit guess: ");
                            String userGuess = userInput.nextLine().strip().toLowerCase();
                            if (((userGuess.equals("I quit".toLowerCase())) || gameTrunk.runNumberGame(userGuess).equals("WINNER"))){
                                currentMenu = MAIN_MENU_OPTIONS;
                                break;
                            }
                        }
                        break;

                    case GAME_MENU_OPTION_SECRET_CODE_LETTERS:
                        System.out.println("\n****************************************************");
                        System.out.println("             Secret Code: Word Edition");
                        System.out.print("****************************************************");
                        System.out.print("\nTo quit at any time, enter 'I quit'. Quitter.");

                        while (true) {
                            System.out.println(gameTrunk.getHistoryLog());
                            System.out.println("\nPlease enter your five-letter guess: ");
                            String userGuess = userInput.nextLine().strip().toLowerCase();
                            if (((userGuess.equals("I quit".toLowerCase())) || gameTrunk.runWordGame(userGuess).equals("WINNER"))){
                                currentMenu = MAIN_MENU_OPTIONS;
                                break;
                            }
                        }
                        break;
                    case GAME_MENU_OPTION_BACK_TO_MAIN_MENU:
                        currentMenu = MAIN_MENU_OPTIONS;
                        break;
                    }
            }catch (Exception x){
                System.out.println("\nInvalid option. Please try again.\n");
            }
        }
    }

    private void displayMenu(String[] menu){

        System.out.println("\n**********************************");
        for(int i = 0; i < menu.length; i++){
            System.out.printf("(%1$s) %2$s\n", i + 1, menu[i]);
            }
        System.out.println("**********************************");
    }

    public static void main(String[] args) {
        GameCLI cli = new GameCLI();
        cli.run();
    }

}

//TODO: anagram game, change one letter to make a new word game, synonym/antonym game, etc;
