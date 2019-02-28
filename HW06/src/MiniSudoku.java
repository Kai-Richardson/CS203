/*
 * Class Sudoku - this program creates a simpler version of the classic
 * Sudoku game.
 *
 * @author Instructors CS203
 * @author Kai Richardson
 *
 * @version 2019-02-26
 *
 * * * * *  * * * * * * * * /
 * ADDITIONS:
 *          Supports NxN sized static boards. Currently 2x2 and 3x3. Just declare more sizes in initBoard()
 *
 * * * * *  * * * * * * * * \
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class MiniSudoku {

	private static final int HARD_THRESHOLD = 2;
	// constants
	private static int BOARD_SIZE = 2; //Board size in X boxes by X boxes
	private static int NUM_ROWCOL = BOARD_SIZE * BOARD_SIZE; //Abstracted number of rows and columns


	/**
	 * completeRow function, checks if all given rows are compliant
	 *
	 * @param board - board to check
	 * @return - true if valid, false if invalid
	 */
	private static boolean completeRows(int[][] board) {

		for (int row = 0; row < NUM_ROWCOL; row++) {

			// Set to store characters seen so far.
			boolean[] seenRowNums = new boolean[NUM_ROWCOL];

			for (int col = 0; col < NUM_ROWCOL; col++) {
				if (board[row][col] != 0) {

					// If already encountered before, return false
					if (seenRowNums[(board[row][col] - 1)]) {
						return false;
					}
					seenRowNums[board[row][col] - 1] = true;
				} else return false;
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
			boolean[] seenColNums = new boolean[NUM_ROWCOL];

			for (int row = 0; row < NUM_ROWCOL; row++) {
				if (board[row][col] != 0) {

					// If already encountered before, return false
					if (seenColNums[(board[row][col] - 1)]) {
						return false;
					}
					seenColNums[board[row][col] - 1] = true;
				} else return false;
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

			boolean[] checkRef = new boolean[NUM_ROWCOL]; //init bool to store if we've seen a number
			for (int i = block / NUM_ROWCOL; i < block / NUM_ROWCOL - 1 + BOARD_SIZE; i++) { //iterate block row
				for (int j = block % NUM_ROWCOL; j < block % NUM_ROWCOL - 1 + BOARD_SIZE; j++) { //..  ..    col
					if (board[i][j] != 0) { //if it's not empty
						if (checkRef[(board[i][j]) - 1]) { //if we've seen it before
							return false;
						}
						checkRef[(board[i][j]) - 1] = true; // say that we've seen it
					} else return false;
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
				validNumber = (num <= NUM_ROWCOL) && (num > 0); //only allow numbers from 1-number of rows/cols
				if (!validNumber) System.out.println("Invalid, try again.");
			}

			System.out.println("What row (starting at 1) would you like to input your number?");
			int row = keyboard.nextInt();

			System.out.println("What column (starting at 1) would you like to input your number?");
			int col = keyboard.nextInt();

			if (validMove(row - 1, col - 1, num, board)) board[row - 1][col - 1] = num; //if valid, set

			if (CompleteBoard(board)) { //check for win
				gameWon = true;
			}
		}

		printBoard(board);

		System.out.println("Congratulations! You've won the game. Great work.");

	}

	/**
	 * printBoard
	 * prints the Sudoku board
	 * This method is ready. YOU DON'T HAVE TO EDIT THIS METHOD.
	 */
	private static void printBoard(int[][] board) { //This was originally in a C-style declaration??
		for (int i = 0; i < board.length; i++) {
			if (i % BOARD_SIZE == 0) { //only every N rows
				buildPrintedRows();
			}
			for (int j = 0; j < board[i].length; j++) { //how often to write a 'column'
				if (j % BOARD_SIZE == 0)
					System.out.print("| ");
				if (board[i][j] == 0) //print a period if the array loc is empty
					System.out.print(". ");
				else
					System.out.print(board[i][j] + " ");
			}

			System.out.print("| "); //bound the edge
			System.out.println();
		}
		buildPrintedRows();
	}

	/**
	 * A method to build the rows to print, to cut down on duplicate code.
	 */
	private static void buildPrintedRows() {
		System.out.print("+ ");
		for (int k = 0; k < BOARD_SIZE; k++) { //how many 'boxes' to bound
			for (int l = 0; l < BOARD_SIZE; l++) { //how many 'rows' of numbers to bound
				System.out.print("- ");
			}
			System.out.print("+ ");
		}
		System.out.println();
	}

	/**
	 * Creates the boards for the game to use.
	 *
	 * @return boardHold - the arrayList of 2d array object holders
	 */
	private static ArrayList<Array2D> initBoard() {

		ArrayList<Array2D> boardHold = new ArrayList<>();

		int[][] board2 = {
				{1, 2, 3, 4},
				{3, 4, 1, 2},
				{4, 3, 2, 1},
				{2, 1, 4, 3}};

		int[][] board3 = {
				{5, 3, 4, 6, 7, 8, 9, 1, 2},
				{6, 7, 2, 1, 9, 5, 3, 4, 8},
				{1, 9, 8, 3, 4, 2, 5, 6, 7},

				{8, 5, 9, 7, 6, 1, 4, 2, 3},
				{4, 2, 6, 8, 5, 3, 7, 9, 1},
				{7, 1, 3, 9, 2, 4, 8, 5, 6},

				{9, 6, 1, 5, 3, 7, 2, 8, 4},
				{2, 8, 7, 4, 1, 9, 6, 3, 5},
				{3, 4, 5, 2, 8, 6, 1, 7, 9}
		};

		boardHold.add(0, new Array2D(board2));
		boardHold.add(1, new Array2D(board3));

		return boardHold;
	}

	/**
	 * main
	 * this is the main method.
	 * This method is ready. YOU DON'T HAVE TO EDIT THIS METHOD.
	 */
	public static void main(String[] str) {

		ArrayList<Array2D> boardHolder = initBoard(); //Init board method

		int[][] played_board = {{0}, {0}}; //Temp board holder

		System.out.println("Welcome to Mini-Sudoku game");
		boolean doneInitialize = false;

		while (!doneInitialize) {
			System.out.println("Which level would you like to play?");
			System.out.println("Please enter 1 for easy and 2 for hard.");
			Scanner keyboard = new Scanner(System.in);
			int level = keyboard.nextInt();

			System.out.println("Which size board would you like to play?");
			System.out.println("Please enter 2 for 2x2 and 3 for 3x3.");
			int board_number = keyboard.nextInt();

			if (level == 1 || level == 2) {
				BOARD_SIZE = board_number;

				//go through all arrays
				for (Array2D obj : boardHolder) {

					if ((boardHolder.indexOf(obj) + 2) == board_number) { //if the board is the right dimension, use it
						played_board = obj.array;
						makeHoles(level, played_board);
						doneInitialize = true;
						break;
					}
				}
				if (!doneInitialize) System.out.println("Sorry, that's not a valid board size. Please try again.");
			} else {
				System.out.println("Sorry, this is not a valid level. Please try again.");
			}
		}

		playGame(played_board);
	}

	/**
	 * Object wrapper to hold 2D arrays
	 * from: stackoverflow.com/questions/10785760
	 */
	static class Array2D {
		int[][] array;

		private Array2D(int[][] initialArray) {
			array = initialArray;
		}
	}

}