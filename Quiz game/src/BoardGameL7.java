import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// Details regarding one player
//class Player {
//    int position;
//    int correctQuestions;
//    int incorrectQuestions;
//    boolean failedLastQuestion;
//}

public class BoardGameL7 {

    public static void main(String[] args) {
        playGame();
        System.exit(0);
    }

    // Gets a String from the user and returns it
    public static String inputString(String message) {
        System.out.println(message);
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    // Generates a random integer between the parsed range and returns it
    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    // Getters for the record Player
    public static int getPlayerPosition(Player player) {
        return player.position;
    }
    public static int getPlayerCorrectQuestions(Player player) {
        return player.correctQuestions;
    }
    public static int getPlayerIncorrectQuestions(Player player) {
        return player.incorrectQuestions;
    }
    public static boolean getPlayerFailedLastQuestion(Player player) {
        return player.failedLastQuestion;
    }

    // Setters for the record Player
    public static Player setPlayerPosition(Player player, int position) {
        player.position = position;
        return player;
    }
    public static Player setPlayerCorrectQuestions(Player player, int correctQuestions) {
        player.correctQuestions = correctQuestions;
        return player;
    }
    public static Player setPlayerIncorrectQuestions(Player player, int incorrectQuestions) {
        player.incorrectQuestions = incorrectQuestions;
        return player;
    }
    public static Player setPlayerFailedLastQuestion(Player player, boolean failedLastQuestion) {
        player.failedLastQuestion = failedLastQuestion;
        return player;
    }
    // Creates and returns a Player record
    public static Player newPlayer(int position, int correctQuestions, int incorrectQuestions) {
        Player player = new Player();
        player = setPlayerPosition(player, position);
        player = setPlayerCorrectQuestions(player, correctQuestions);
        player = setPlayerIncorrectQuestions(player, incorrectQuestions);
        player = setPlayerFailedLastQuestion(player, false);
        return player;
    }

    // Adds how much the player moves to the player record parsed in and returns the player
    public static Player movePlayer(Player player, int moves) {
        player.position += moves;
        return player;
    }

    // Increments player.correctQuestions from the Player parsed in and returns the player
    public static Player incrementPlayerCorrectQuestions(Player player) {
        player.correctQuestions++;
        return player;
    }

    // Increments player.incorrectQuestions from the Player parsed in and returns the player
    public static Player incrementPlayerIncorrectQuestions(Player player) {
        player.incorrectQuestions++;
        return player;
    }

    // Sorts and prints the players in order of the furthest ahead (uses Bubble-sort)
    // Takes in the array of all the player's Player objects and the number of players
    public static void printStandings(Player[] listOfPlayers, final int noPlayers) {
        if (noPlayers>1) {
            int[] allPlayerPositions = new int[noPlayers];
            int[] orderedListOfPlayerNo = new int[noPlayers];
            for (int i = 0; i < noPlayers; i++) {
                orderedListOfPlayerNo[i] = i + 1;
                allPlayerPositions[i] = getPlayerPosition(listOfPlayers[i]);
            }

            // Bubblesort
            int tempPlayerPosition1;
            int tempPlayerPosition2;
            int tempPlayerNo;
            System.out.println("\n**************************");
            for (int i = 1; i < noPlayers; i++) {
                for (int j = 0; j < (noPlayers - i); j++) {
                    tempPlayerPosition1 = allPlayerPositions[orderedListOfPlayerNo[j] - 1];
                    tempPlayerPosition2 = allPlayerPositions[orderedListOfPlayerNo[j + 1] - 1];
                    if (tempPlayerPosition1 < tempPlayerPosition2) {
                        // Swaps the player No
                        tempPlayerNo = orderedListOfPlayerNo[j];
                        orderedListOfPlayerNo[j] = orderedListOfPlayerNo[j + 1];
                        orderedListOfPlayerNo[j + 1] = tempPlayerNo;
                    }
                }
            }

            System.out.println("Player " + orderedListOfPlayerNo[0] + " is in 1st place at position " +
                    allPlayerPositions[orderedListOfPlayerNo[0]-1] + ".");
            System.out.println("Player " + orderedListOfPlayerNo[1] + " is in 2nd place at position " +
                    allPlayerPositions[orderedListOfPlayerNo[1]-1] + ".");
            if (noPlayers > 2) {
                System.out.println("Player " + orderedListOfPlayerNo[2] + " is in 3rd place at position " +
                        allPlayerPositions[orderedListOfPlayerNo[2]-1] + ".");
                for (int i = 3; i < noPlayers; i++) {
                    System.out.println("Player " + orderedListOfPlayerNo[i] + " is in " + (i + 1) +
                            "th place at position " + allPlayerPositions[orderedListOfPlayerNo[i]-1] + ".");
                }
            }
            System.out.println("**************************");
        }
    }

    // Creates and returns a dictionary for all the questions and answers
    public static Map<String, String> loadQuestions() {
        Map<String, String> dictQuestionsAndAnswers = new HashMap<String, String>();
        dictQuestionsAndAnswers.put("What is the capital of Egypt", "Cairo");
        dictQuestionsAndAnswers.put("What is the capital of Afghanistan", "Kabul");
        dictQuestionsAndAnswers.put("What is the capital of China", "Beijing");
        dictQuestionsAndAnswers.put("What is the capital of India", "New Delhi");
        dictQuestionsAndAnswers.put("What is the capital of Israel", "Jerusalem");
        dictQuestionsAndAnswers.put("What is the capital of Japan", "Tokyo");
        dictQuestionsAndAnswers.put("What is the capital of Lebanon", "Beirut");
        dictQuestionsAndAnswers.put("What is the capital of Russia", "Moscow");
        dictQuestionsAndAnswers.put("What is the capital of Saudi Arabia", "Riyadh");
        dictQuestionsAndAnswers.put("What is the capital of Singapore", "Singapore");
        dictQuestionsAndAnswers.put("What is the capital of South Korea", "Seoul");
        dictQuestionsAndAnswers.put("What is the capital of What is the capital of Taiwan", "Taipei");
        dictQuestionsAndAnswers.put("What is the capital of Thailand", "Bangkok");
        dictQuestionsAndAnswers.put("What is the capital of Turkey", "Ankara");
        dictQuestionsAndAnswers.put("What is the capital of Australia", "Canberra");
        dictQuestionsAndAnswers.put("What is the capital of Austria", "Vienna");
        dictQuestionsAndAnswers.put("What is the capital of Belgium", "Brussels");
        dictQuestionsAndAnswers.put("What is the capital of Denmark", "Copenhagen");
        dictQuestionsAndAnswers.put("What is the capital of Finland", "Helsinki");
        dictQuestionsAndAnswers.put("What is the capital of France", "Paris");
        dictQuestionsAndAnswers.put("What is the capital of Germany", "Berlin");
        dictQuestionsAndAnswers.put("What is the capital of Greece", "Athens");
        dictQuestionsAndAnswers.put("What is the capital of Hungary", "Budapest");
        dictQuestionsAndAnswers.put("What is the capital of Iceland", "Reykjavik");
        dictQuestionsAndAnswers.put("What is the capital of Ireland", "Dublin");
        dictQuestionsAndAnswers.put("What is the capital of Italy", "Rome");
        dictQuestionsAndAnswers.put("What is the capital of Luxembourg", "Luxembourg");
        dictQuestionsAndAnswers.put("What is the capital of Monaco", "Monaco");
        dictQuestionsAndAnswers.put("What is the capital of Netherlands", "Amsterdam");
        dictQuestionsAndAnswers.put("What is the capital of Poland", "Warsaw");
        dictQuestionsAndAnswers.put("What is the capital of Portugal", "Lisbon");
        dictQuestionsAndAnswers.put("What is the capital of Spain", "Madrid");
        dictQuestionsAndAnswers.put("What is the capital of Sweden", "Stockholm");
        dictQuestionsAndAnswers.put("What is the capital of England", "London");
        dictQuestionsAndAnswers.put("What is the capital of Wales", "Cardiff");
        dictQuestionsAndAnswers.put("What is the capital of the Vatican City", "Vatican City");
        dictQuestionsAndAnswers.put("What is the capital of Canada", "Ottawa");
        dictQuestionsAndAnswers.put("What is the capital of Cuba", "Havana");
        dictQuestionsAndAnswers.put("What is the capital of Mexico", "Mexico City");
        dictQuestionsAndAnswers.put("What is the capital of the United States of America", "Washington, D.C.");
        dictQuestionsAndAnswers.put("What is the capital of Brazil", "Brasilia");
        return dictQuestionsAndAnswers;
    }

    // Returns a question, its answer and 3 random answers
    // Takes a Map for all the questions and answers, an array of the questions in the Map, the number of questions -1
    public static String[] getQuestion(Map<String, String> dictQuestionsAndAnswers, String[] listOfQuestions,
                                       int noQuestionsMinusOne) {
        String key = listOfQuestions[generateRandomInt(0, noQuestionsMinusOne)];
        final String correctAnswer = dictQuestionsAndAnswers.get(key);
        String[] question = new String[] {key, correctAnswer, correctAnswer, correctAnswer, correctAnswer};
        final int noChoices = 4;
        for (int i=2; i<(noChoices+1); i++) {
            // Makes sure the generated incorrect answer is not actually the correct answer
            while (question[i].equals(correctAnswer)) {
                // Gets a random answer
                question[i] = dictQuestionsAndAnswers.get(listOfQuestions[generateRandomInt(0, noQuestionsMinusOne)]);
            }
        }
        return question;
    }

    // Asks a question to the user and checks whether it is correct (changes the player stats)
    // Takes in a player and a list with contents [question, correct answer, wrong answer, wrong answer, wrong answer]
    // Returns the Player object parsed in (changed during the method)
    public static Player askQuestion(Player player, final String[] question) {
        boolean hasFailed = false;
        System.out.println("\nYour question is: " + question[0]);
        final String[] answers = {question[1], question[2], question[3], question[4]};
        int startingNo = generateRandomInt(1, 4);
        String answer = inputString("Your choices are: " + answers[startingNo] + ", " +
                answers[(startingNo+1) % 4] + ", " +
                answers[(startingNo+2) % 4] + ", " +
                answers[(startingNo+3) % 4] + " ");

        if (answer.equals(question[1])) {
            System.out.println("You are right!");
            player = incrementPlayerCorrectQuestions(player);
            player = setPlayerFailedLastQuestion(player, false);
        }
        else {
            System.out.println("You are wrong! The correct answer is " + question[1]);
            player = incrementPlayerIncorrectQuestions(player);
            player = setPlayerFailedLastQuestion(player, true);
        }
        return player;
    }

    // Gets a valid number of players from the user, then returns it
    public static int inputNoPlayers() {
        int noPlayers = 0;
        boolean isCorrectNumber = false;
        while (!isCorrectNumber) {
            try {
                noPlayers = Integer.parseInt(inputString("How many players are there?"));
                if (noPlayers > 0) {
                    isCorrectNumber = true;
                }
                else {
                    System.out.println("Please enter a valid number of players.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number of players.");
            }
        }
        return noPlayers;
    }

    // Prints the start message and gets facts from the user (takes in the number of players)
    public static void printStartMessage(int noPlayers) {
        System.out.println("Welcome to the board game: Secret Traps and Passages");

        String[] facts = new String[2];
        for (int i=1; i<(noPlayers+1); i++) {
            System.out.println();
            System.out.println("Hello Player " + i + ", please enter 2 facts about yourself");
            for (int j=1; j<3; j++) {
                facts[j-1] = inputString("Fact " + j);
            }
            System.out.println("You said that " + facts[0] + ", quite neat!");
            System.out.println("You said that " + facts[1] + ", quite cool!");
        }
        System.out.println("Now with that out of the way, let the game begin!");
    }

    // The main method for playing the game
    public static void playGame() {
        Player currentPlayer = null;
        final int boardSize = 30;
        final List<Integer> trapSpaces = Arrays.asList(9,15,23,29);
        final List<Integer> secretPassageSpaces = Arrays.asList(7, 12, 21, 25);
        boolean hasWon = false;
        int diceRoll = 0;
        String playerWon = "Player";

        // At the start of the while loop, this will become the first player index
        int playerIndex = -1;
        final int noPlayers = inputNoPlayers();
        Player[] listOfPlayers = new Player[noPlayers];
        for (int i=0; i<noPlayers; i++) {
            listOfPlayers[i] = newPlayer(0, 0, 0);
        }

        Map<String, String> dictQuestionsAndAnswers = loadQuestions();
        // An array of all the questions only
        String[] listOfQuestions = dictQuestionsAndAnswers.keySet().toArray(new String[0]);
        // This variable is only used for generating random answers for the multiple choices to each question
        int noQuestionsMinusOne = dictQuestionsAndAnswers.size()-1;
        // question follows the format: [question, correct answer, fake answer1, fake answer 2, fake answer 3]
        String[] question;

        printStartMessage(noPlayers);
        while (!hasWon) {
            playerIndex = (playerIndex + 1) % noPlayers;
            currentPlayer = listOfPlayers[playerIndex];

            System.out.println();
            System.out.println("Your turn, Player " + (playerIndex+1) );
            System.out.println("You are on space " + getPlayerPosition(currentPlayer));
            diceRoll = generateRandomInt(1, 6);
            currentPlayer = movePlayer(currentPlayer, diceRoll);
            System.out.println("You rolled a " + diceRoll);
            System.out.println("You are now on space " + getPlayerPosition(currentPlayer));

            if (getPlayerPosition(currentPlayer) >= boardSize) {
                hasWon = true;
                listOfPlayers[playerIndex] = currentPlayer;
                playerWon = "Player " + (playerIndex+1);
            }
            else {
                question = getQuestion(dictQuestionsAndAnswers, listOfQuestions, noQuestionsMinusOne);

                // If they landed on a trap space
                if (trapSpaces.contains(getPlayerPosition(currentPlayer))) {
                    System.out.println("You have stepped on a trap space!");
                    System.out.println("If you lose then you will be sent 7 spaces backwards");
                    currentPlayer = askQuestion(currentPlayer, question);
                    if (getPlayerFailedLastQuestion(currentPlayer)) {
                        System.out.println("You have been sent 7 spaces backwards!");
                        currentPlayer = movePlayer(currentPlayer, -7);
                    } else {
                        System.out.println("You have escaped the trap!");
                    }
                }
                else if (secretPassageSpaces.contains(getPlayerPosition(currentPlayer))) {
                    System.out.println("There is a secret passage space!");
                    System.out.println("If you win then you will be sent 4 spaces forwards");
                    currentPlayer = askQuestion(currentPlayer, question);
                    if (!getPlayerFailedLastQuestion(currentPlayer)) {
                        System.out.println("You have found the secret passage and moved 4 spaces!");
                        currentPlayer = movePlayer(currentPlayer, 4);
                    } else {
                        System.out.println("You have failed to find the secret passage.");
                    }
                }
                else {
                    currentPlayer = askQuestion(currentPlayer, question);
                }

                listOfPlayers[playerIndex] = currentPlayer;
                // Checks if all players have had a turn this round (end of round check)
                if (playerIndex == noPlayers-1) {
                    printStandings(listOfPlayers, noPlayers);
                }
            }

        }
        System.out.println(playerWon + " wins!");
        printStandings(listOfPlayers, noPlayers);
        for (int i=0; i<noPlayers; i++) {
            System.out.println("\nPlayer " + (i+1) + ": ");
            System.out.println("You got " + getPlayerCorrectQuestions(listOfPlayers[i]) + " questions right.");
            System.out.println("You got " + getPlayerIncorrectQuestions(listOfPlayers[i]) + " questions wrong.");
        }
    }
}
