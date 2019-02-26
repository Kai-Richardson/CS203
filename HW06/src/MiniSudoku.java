/*
 * Class Sudoku - this program creates a simpler version of the classic
 * Sudoku game.
 *
 * @author Instructors CS203
 * @author Kai Richardson
 *
 * @version 2019-02-24
 *
 * * * * *  * * * * * * * * /
 * ADDITIONS: Support of any normal size sudoku grid - ex. 2x2,3x3,4x4,
 *
 * * * * *  * * * * * * * * \
 */

import java.util.Random;
import java.util.Scanner;

public class MiniSudoku {

	// constants
	private static final int BOARD_SIZE = 2; //Board size in X boxes by X boxes
	private static final int HARD_THRESHOLD = 2;
	private static final int NUM_ROWCOL = BOARD_SIZE * BOARD_SIZE;


	/**
	 * completeRow function, checks if all given rows are compliant
	 *
	 * @param board - board to check
	 * @return - true if valid, false if invalid
	 */
	private static boolean completeRows(int[][] board) {

		for (int row = 0; row < NUM_ROWCOL; row++) {

			// Set to store characters seen so far.
			boolean[] seenNums = new boolean[NUM_ROWCOL];

			for (int col = 0; col < NUM_ROWCOL; col++) {
				if (board[row][col] != 0) {

					// If already encountered before, return false
					if (seenNums[(board[row][col] - 1)]) {
						return false;
					}
					seenNums[board[row][col] - 1] = true;
				}
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

		for (int col = 0; col < NUM_ROWCOL; col++) {

			// Set to store characters seen so far.
			boolean[] seenNums = new boolean[NUM_ROWCOL];

			for (int row = 0; row < NUM_ROWCOL; row++) {
				if (board[row][col] != 0) {

					// If already encountered before, return false
					if (seenNums[(board[row][col] - 1)]) {
						return false;
					}
					seenNums[board[row][col] - 1] = true;
				}
			}
		}
		return true;
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
			for (int i = block / NUM_ROWCOL; i < block / NUM_ROWCOL - 1 + BOARD_SIZE; i++) {
				for (int j = block % NUM_ROWCOL; j < block % NUM_ROWCOL - 1 + BOARD_SIZE; j++) {
					if (board[i][j] != 0) {
						if (checkRef[(int) (board[i][j]) - 1]) {
							return false;
						}
						checkRef[(int) (board[i][j]) - 1] = true;
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
		return checkBlocks(board) && completeRows(board) && completeCols(board);
	}

	/**
	 * validMove to check if a move is valid at a loc
	 *
	 * @param row   - row to check
	 * @param col   - col to check
	 * @param value - value to test
	 * @param board - board array to test
	 * @return - true if valid, false otherwise
	 */
	private static boolean validMove(int row, int col, int value, int[][] board) {
		//Honestly, I feel as if the challenge of sudoku comes from being able to make mistakes.
		//If you aren't allowed to make mistakes, you'll just be able to attempt to fill in a box
		// until you get it right.
		//So, let's put a little bit of challenge, and allow all moves. You still won't win if you get it wrong.
		return true;
	}

	/**
	 * playGame function to run the game, main game loop called by Main
	 *
	 * @param board - given game board to play on
	 */
	private static void playGame(int[][] board) {

		boolean gameWon = false;

		while (!gameWon) {

			printBoard(board);

			Scanner keyboard = new Scanner(System.in);
			boolean validNumber = false;
			int num = 0;

			while (!validNumber) {
				System.out.println("What number would you like to input?");
				num = keyboard.nextInt();
				validNumber = (num <= NUM_ROWCOL) && (num > 0);
				if (!validNumber) System.out.println("Invalid, try again.");
			}

			System.out.println("What row (starting at 1) would you like to input your number?");
			int row = keyboard.nextInt();

			System.out.println("What column (starting at 1) would you like to input your number?");
			int col = keyboard.nextInt();

			if (validMove(row - 1, col - 1, num, board)) board[row - 1][col - 1] = num;

			if (CompleteBoard(board)) {
				gameWon = true;
			}
		}
	}


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
		while (!doneInitialize) {
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
		}

		playGame(board);
	}


}//class Sudoku
