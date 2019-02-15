/*
 * This program implements the word guessing game called Hangman. Thus, it is called Hangman.
 *
 * @author Kai Richardson
 * @version 2019-02-14
 *
 * * * * * * * * * * * * * * *
 * Enhancements: Accept upper/lowercase letters, only accept letters, win/loss count, no double guess
 * Bugs: None known
 * * * * * * * * * * * * * * *
 */

import java.util.Random;
import java.util.Scanner;

/**
 * Play one game of Hangman until the user wins (guesses all of the
 * letters in the secret word) or loses (guesses 7 incorrect letters).
 */
public class Hangman {

	private static final int MAX_BAD_GUESSES = 7;  //user can guess up to 7 characters

	private static int timesWon = 0;
	private static int timesLost = 0;

	public static void main(String[] args) throws DumbUser {
		//"SECRET" WORDS LIST
		String[] secretWordsList =   //choose secret word from these
				{"geography", "cat", "yesterday", "java", "truck", "opportunity",
						"fish", "token", "transportation", "history", "apple", "connection",
						"remote", "arizona", "terminology", "arm", "cranberry", "tool",
						"caterpillar", "spoon", "watermelon", "laptop", "toe", "toad",
						"fundamental", "capitol", "sweet", "anticipate", "competition",
						"red", "summer", "window"};

		// String obj holder to store our word
		String secretWord;

		// Randomly choose a word from list of words
		Random randIndex = new Random();
		secretWord = secretWordsList[randIndex.nextInt(secretWordsList.length)];


		// Init array to store the correct letters guessed
		char[] correctLetters = new char[secretWord.length()];

		// Fill the correct letters guessed array with underscores
		for (int i = 0; i < secretWord.length(); i++) {
			correctLetters[i] = '_';
		}

		char[] incorrectLetters = new char[MAX_BAD_GUESSES];

		int incorrectLettersGuessed = 0; //Since we're using arrays and not ArrayLists, we can't rely on dynamic .len

		Scanner keyboard = new Scanner(System.in); //for getting user input

		//Invite the player to play the game
		System.out.println("Would you like to play a guessing game?");
		String answer = keyboard.nextLine();
		answer = answer.trim().toLowerCase();
		//Get the user's answer to (would you like to play?)
		if ((answer.length() == 0) || (answer.charAt(0) != 'y')) {
			if ((answer.charAt(0) != 'n'))
				throw new DumbUser("input",
						"Illegal input given, please provide a yes or no.");
		}


		// main loop for game
		while (!gameWon(correctLetters) && incorrectLettersGuessed < MAX_BAD_GUESSES) {

			// Call method to print the Hangman picture (DONE).
			printHangman(incorrectLettersGuessed);

			// let's print correct and incorrect letters so far
			printCorrectGuessedLetters(correctLetters);

			//Prints a blank line to space things out
			System.out.println();

			printIncorrectGuessedLetters(incorrectLetters, incorrectLettersGuessed);

			//Prints a blank line to space things out
			System.out.println();

			System.out.println("What letter do you want to guess?");
			char guess = keyboard.next().charAt(0);

			//throw exception if a number is entered
			if (Character.isDigit(guess)) {
				throw new DumbUser("input type", "Illegal input, please input a letter.");
			}

			guess = Character.toLowerCase(guess);

			// declare found
			boolean found = false;

			//Check to see if we've guessed this letter before
			for (char c : correctLetters) {
				if (c == guess) throw new DumbUser("input", "You guessed a letter you already guessed.");
			}

			for (char c : incorrectLetters) {
				if (c == guess) throw new DumbUser("input", "You guessed a letter you already guessed.");
			}

			// go through the secret word character by character
			for (int i = 0; i < secretWord.length(); i++) {
				if (secretWord.charAt(i) == guess) { //if guess matches
					found = true;                    //the guess was correct
					correctLetters[i] = guess;       //record correct guess
				}
			}

			// check to see if found is true
			if (found) {
				System.out.println("*** Your guess of " + guess + " was correct!");
			} else {

				// since not correct, increment and add to array
				incorrectLetters[incorrectLettersGuessed] = guess;
				incorrectLettersGuessed++;

				System.out.println("*** Sorry, your guess of " + guess + " is not in the secret word");
			}
		}


		// end of game message
		System.out.println("\n********************************************");
		System.out.println("The secret word was: " + secretWord);
		if (gameWon(correctLetters)) {
			System.out.println("Congratulations, you won!");
			timesWon++;
		} else {
			System.out.println("Sorry, you lost the game.");
			printHangman(incorrectLettersGuessed);
			timesLost++;
		}

		System.out.println("Times Won: " + timesWon);
		System.out.println("Times Lost: " + timesLost);

	}


	/**
	 * Return true if the user has won the game;
	 * otherwise, return false.
	 *
	 * @param correctLetters passed correct letters array
	 * @return true if the user has won, false otherwise
	 */
	private static boolean gameWon(char[] correctLetters) {

		//Eval if there are no underscores in correctLetters array
		for (char correctLetter : correctLetters) {
			if (correctLetter == '_') return false;
		}

		return true;
	}


	/**
	 * Print the correct guesses in the secret word.
	 *
	 * @param correctLetters array of correct guessed letters
	 */
	private static void printCorrectGuessedLetters(char[] correctLetters) {
		String correctGuessString = "";
		//Loop through correctLetters and add chars to string, then display
		for (char correctLetter : correctLetters) {
			correctGuessString += correctLetter; //String buffer overhead in loop but eh
			correctGuessString += " ";
		}

		System.out.println(correctGuessString);
	}


	/**
	 * Print the incorrect letters that have been guessed.
	 *
	 * @param incorrectLettersArray   array of incorrect guessed letters
	 * @param incorrectLettersGuessed the num of incorrectly guessed letters
	 */
	private static void printIncorrectGuessedLetters(char[] incorrectLettersArray, int incorrectLettersGuessed) {

		//Loop through incorrectLetters for length filled and add chars to string, then display
		String incorrectGuessString = "Incorrect Letters: ";
		for (int i = 0; i < incorrectLettersGuessed; i++) {
			incorrectGuessString += incorrectLettersArray[i]; //String buffer overhead in loop but eh
			incorrectGuessString += " ";
		}

		System.out.println(incorrectGuessString);
	}


	/**
	 * Print the Hangman that corresponds to the given number of bad guesses so far. This method is DONE for you.
	 *
	 * @param badGuessesCount count of bad guesses so far
	 */
	private static void printHangman(int badGuessesCount) {
		int poleLines = 6;   // number of lines for hanging pole
		System.out.println("  ____");
		System.out.println("  |  |");

		if (badGuessesCount == 7) {
			System.out.println("  |  |");
			System.out.println("  |  |");
		}

		if (badGuessesCount > 0) {
			System.out.println("  |  O");
			poleLines = 5;
		}

		if (badGuessesCount > 1) {
			poleLines = 4;
			if (badGuessesCount == 2) {
				System.out.println("  |  |");
			} else if (badGuessesCount == 3) {
				System.out.println("  | \\|");
			} else if (badGuessesCount >= 4) { //This statement is always true??
				System.out.println("  | \\|/");
			}
		}

		if (badGuessesCount > 4) {
			poleLines = 3;
			System.out.println("  |  |");
		}

		if (badGuessesCount == 6) {
			poleLines = 2;
			System.out.println("  | /");
		} else if (badGuessesCount >= 7) {
			poleLines = 0;
			System.out.println("  | / \\");
		}

		for (int k = 0; k < poleLines; k++) {
			System.out.println("  |");
		}
		System.out.println("__|__");
		System.out.println();
	}

	/**
	 * DumbUser exception if the wrong type is inputted places where it doesn't belong
	 */
	private static class DumbUser extends Exception {
		private DumbUser(String type, String error) {
			System.out.println("Illegal " + type + " given.");
			System.out.println("Specific Error: " + error);
		}
	}

}
