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
	private static final int NUM_ROWCOL = BOARD_SIZE * BOARD_SIZE;


	/**
	 * completeRow function, checks if all given rows are compliant
	 *
	 * @param board - board to check
	 * @return - true if valid, false if invalid
	 */
	private static boolean completeRows(int[][] board) {

		for (int j = 0; j < NUM_ROWCOL; j++) {
			boolean[] seenNums = new boolean[NUM_ROWCOL];

			for (int i = 0; i < NUM_ROWCOL; i++) {
				if (columnDupeChecker(board, j, seenNums, i)) return false;
			}
		}
		return true;
	}

	/**
	 * completeRow function, checks if all columns are compliant
	 *
	 * @param board - board to check
	 * @return - true if valid, false if invalid
	 */
	private static boolean completeCols(int[][] board) {

		for (int i = 0; i < NUM_ROWCOL; i++) {
			boolean[] seenNums = new boolean[NUM_ROWCOL]; //Array to hold checker

			for (int j = 0; j < 9; j++) {
				if (columnDupeChecker(board, j, seenNums, i)) return false;
			}
		}
		return true;
	}

	/**
	 * Split-off function to check if there's duplicates in a given area
	 *
	 * @param board    - game board to check
	 * @param j        - parent loop j
	 * @param seenNums - parent seenNums array
	 * @param i        - parent loop i
	 * @return - true if invalid, false if not
	 */
	private static boolean columnDupeChecker(int[][] board, int j, boolean[] seenNums, int i) {
		if (board[i][j] != 0) {
			if (seenNums[(board[i][j] - 1)]) {
				return true;
			}
			seenNums[(board[i][j] - 1)] = true;
		}
		return false;
	}

	/**
	 * checkBocks method, let's check if the whole board works all at once
	 *
	 * @param board - board to check
	 * @return - true if valid, false if invalid
	 */
	private static boolean checkBlocks(int[][] board) {

		for (int block = 0; block < (NUM_ROWCOL); block++) {

			boolean[] checkRef = new boolean[NUM_ROWCOL];
			for (int i = block / NUM_ROWCOL; i < block / NUM_ROWCOL + BOARD_SIZE; i++) {
				for (int j = block % NUM_ROWCOL; j < block % NUM_ROWCOL + BOARD_SIZE; j++) {
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
	}


	/**
	 * determines if solution is valid
	 *
	 * @param board - board-holding array
	 * @return - Return true if solution is valid, and false otherwise.
	 */
	private static boolean CompleteBoard(int[][] board) {
		if (checkBlocks(board)) {
			if (completeRows(board)) {
				return completeCols(board);
			}
		}
		return false;
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


	/** validMove to check if a move is valid at a loc
	 *
	 * @param row - row to check
	 * @param col - col to check
	 * @param value - value to test
	 * @param board - board array to test
	 * @return - true if valid, false otherwise
	 */
	public static boolean validMove(int row, int col, int value, int[][] board) {
		//Honestly, I feel as if the challenge of sudoku comes from being able to make mistakes.
		//If you aren't allowed to make mistakes, you'll just be able to attempt to fill in a box
		// until you get it right.
		//So, let's put a little bit of challenge, and allow all moves. You still won't win if you get it wrong.
		return true;
	}


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
		int holesToMake = randNumber.nextInt(NUM_ROWCOL * NUM_ROWCOL / HARD_THRESHOLD);
		holesToMake++;
		if (level == 2)
			holesToMake = holesToMake + NUM_ROWCOL * NUM_ROWCOL / HARD_THRESHOLD;

		double remainingSquares = NUM_ROWCOL * NUM_ROWCOL;
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
	public static void printBoard(int[][] board) { //This was originally in a C-style declaration.
		for (int i = 0; i < board.length; i++) {
			if (i % BOARD_SIZE == 0)
				System.out.println("+-----+-----+");
			for (int j = 0; j < board[i].length; j++) {
				if (j % BOARD_SIZE == 0)
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
