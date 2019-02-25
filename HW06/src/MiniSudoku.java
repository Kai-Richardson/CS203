/*
 * Class Sudoku - this program creates a simpler version of the classic
 * Sudoku game.
 *
 * @author Instructors CS203
 * @author Kai Richardson
 *
 * @version Fall 2018
 */

import java.util.Random;
import java.util.Scanner;

public class MiniSudoku {

	// constants
	private static final int BOARD_SIZE = 2; //Board size in X by X
	private static final int HARD_THRESHOLD = 2;


	/**
	 * completeRow function, checks if the given row is compliant
	 *
	 * @param rowNum - given row to check
	 * @param board  - board to check
	 * @return - true if valid, false if invalid
	 */
	private static boolean completeRow(int rowNum, int[][] board) {

		boolean[] seenNums = new boolean[BOARD_SIZE * 2]; //array to hold truth values

		for (int rows = 0; rows < board.length; rows++) {
			for (int columns = 0; columns < board[rows].length; columns++) {
				if (seenNums[columns]) { //if any value is already true, error
					return false; //early returns are OK if it's clear why
				}
				seenNums[columns] = true;
			}
		}

		return true;
	}

	/**
	 * completeRow function, checks if the given column is compliant
	 *
	 * @param colNum - given column to check
	 * @param board  - board to check
	 * @return - true if valid, false if invalid
	 */
	private static boolean completeCol(int colNum, int[][] board) {
		boolean[] seenNums = new boolean[BOARD_SIZE * 2]; //array to hold truth values

		for (int row = 0; row < board[colNum].length; row++) { //check to see if
			if (seenNums[row]) { //if any value is already true, error
				return false; //early returns are OK if it's clear why
			}
			seenNums[row] = true;
		}
		return true;
	}

	/**
	 * checkBocks method, let's check if the whole board works all at once
	 *
	 * @param board  - board to check
	 * @return - true if valid, false if invalid
	 */
	private static boolean checkBlocks(int[][] board) {

		for (int block = 0; block < (BOARD_SIZE * BOARD_SIZE); block++) {

			boolean[] checkRef = new boolean[BOARD_SIZE * BOARD_SIZE];
			for (int i = block / BOARD_SIZE * BOARD_SIZE; i < block / BOARD_SIZE * BOARD_SIZE + BOARD_SIZE; i++) {
				for (int j = block % BOARD_SIZE * BOARD_SIZE; j < block % BOARD_SIZE * BOARD_SIZE + BOARD_SIZE; j++) {
					if (board[i][j] != '.') {
						if (checkRef[(int) (board[i][j] - 1)]) {
							return false;
						}
						checkRef[(int) (board[i][j] - 1)] = true;
					}
				}
			}
		}

		return true;
	}//completeBlock


	/**
	 * validSolution
	 * determines if solution is valid, all rows have each number
	 * all cols have each number, and all blocks have each number
	 * Use the methods above to help solve this method. You want to
	 * check that all rows are completeRows, all cols are
	 * completeCols, and all blocks are completeBlocks. Return true
	 * if solution is valid, and false otherwise.
	 */
	private static boolean CompleteBoard(int[][] board) {
		// you need to implement this method
		//replace these comments with your code
		return true;
	}//validSolution

	/**
	 * playGame
	 * plays the Sudoku game
	 * This is the main game engine loop
	 */
	private static void playGame(int[][] board) {
		// you need to implement this method
		//replace these comments with your code
		System.out.println("Sorry. The playGame method is not implemented!");
	}//playGame


	/**
	 * validMove
	 * checks if value can be placed in location row,col
	 */
	public static boolean validMove(int row, int col, int value, int[][] board) {
		//you need to implement this method
		//replace these comments with your code
		return true;
	}//validMove


	/*======================================================================
	 * Completed Methods.YOU DON'T HAVE TO EDIT THIS METHODS.
	 *----------------------------------------------------------------------
	 */

	/**
	 * makeHoles
	 * creates random holes in the board. The number of holes will be determined
	 * by the level of the game that the user chose.
	 * This method is ready. YOU DON'T HAVE TO EDIT THIS METHOD.
	 */
	private static void makeHoles(int level, int[][] board) {
       /* For this version of game, difficulty is defined as follows:
            Easy: less than half the number of squares are holes  
            Hard: More than half the number of squares are holes
        */

		Random randNumber = new Random();
		int holesToMake = randNumber.nextInt(NUM_ROWS * NUM_ROWS / HARD_THRESHOLD);
		holesToMake++;
		if (level == 2)
			holesToMake = holesToMake + NUM_ROWS * NUM_ROWS / HARD_THRESHOLD;

		double remainingSquares = NUM_ROWS * NUM_ROWS;
		double remainingHoles = (double) holesToMake;

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++) {
				double holeChance = remainingHoles / remainingSquares;
				if (Math.random() <= holeChance) {
					board[i][j] = 0;
					remainingHoles--;
				}
				remainingSquares--;
			}
	}

	/**
	 * printBoard
	 * prints the Sudoku board
	 * This method is ready. YOU DON'T HAVE TO EDIT THIS METHOD.
	 */
	public static void printBoard(int[][] board) { //This was originally in a C-style deceleration.
		for (int i = 0; i < board.length; i++) {
			if (i % BLOCK_SIZE == 0)
				System.out.println("+-----+-----+");
			for (int j = 0; j < board[i].length; j++) {
				if (j % BLOCK_SIZE == 0)
					System.out.print("| ");
				if (board[i][j] == 0)
					System.out.print(". ");
				else
					System.out.print(board[i][j] + " ");
			}
			System.out.print("| ");
			System.out.println();
		}
		System.out.println("+-----+-----+");
	}

	/**
	 * main
	 * this is the main method.
	 * This method is ready. YOU DON'T HAVE TO EDIT THIS METHOD.
	 */
	public static void main(String[] str) {
		// a 2D array to store the playing board
		int[][] board = {{1, 2, 3, 4}, {3, 4, 1, 2}, {4, 3, 2, 1}, {2, 1, 4, 3}};

		System.out.println("Welcome to Mini-Sudoku game");
		boolean doneInitialize = false;
		do {
			System.out.println("Which level you would like to play?");
			System.out.println("Please enter 1 for easy and 2 for hard.");
			Scanner keyboard = new Scanner(System.in);
			int level = keyboard.nextInt();

			if (level == 1 || level == 2) {
				makeHoles(level, board);
				doneInitialize = true;
			} else {
				System.out.println("Sorry, this is not a valid level. Please try again.");
			}
		} while (!doneInitialize);

		playGame(board);
	}


}//class Sudoku
