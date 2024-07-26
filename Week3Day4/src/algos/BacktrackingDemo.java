package algos;

// Backtracking: algorithmic technique for solving problems recursively by trying to build
// a solution incrementally, removing solutions that fail to satisfy the constraints of the
// problem at any point. (brute force)

public class BacktrackingDemo {

	public static void main(String[] args) {
		NQueens nq = new NQueens(4);
		nq.solve();
	}
}

//-------------------
//| Q | . | . | . | 
//| . | . | . | . | 
//| . | . | . | . | 
//| . | . | . | . | 
//-------------------
//| Q | . | . | . | 
//| . | . | Q | . | 
//| . | . | . | . | 
//| . | . | . | . | 
//-------------------
//| Q | . | . | . | 
//| . | . | Q | . | 
//| . | Q | . | . | 
//| . | . | . | . | 
//-------------------
//| Q | . | . | . | 
//| . | . | . | Q | 
//| . | . | . | . | 
//| . | . | . | . | 
//-------------------
//| Q | . | . | . | 
//| . | . | . | Q | 
//| . | Q | . | . | 
//| . | . | . | . | 
//-------------------
//| . | Q | . | . | 
//| . | . | . | . | 
//| . | . | . | . | 
//| . | . | . | . | 
//-------------------
//| . | Q | . | . | 
//| Q | . | . | . | 
//| . | . | . | . | 
//| . | . | . | . | 
//-------------------
//| . | Q | . | . | 
//| Q | . | . | . | 
//| . | . | Q | . | 
//| . | . | . | . | 
//-------------------
//| . | Q | . | . | 
//| . | . | . | Q | 
//| . | . | . | . | 
//| . | . | . | . | 
//-------------------
//| . | Q | . | . | 
//| . | . | . | Q | 
//| Q | . | . | . | 
//| . | . | . | . | 
//-------------------
//| . | Q | . | . | 
//| . | . | . | Q | 
//| Q | . | . | . | 
//| . | . | Q | . | 
//-------------------
//| . | Q | . | . | 
//| . | . | . | Q | 
//| Q | . | . | . | 
//| . | . | Q | . | 
//-------------------

// Solving the N-Queens problem
class NQueens {
	private int boardSize;
	private int[][] board;
	
	public NQueens() {
		this.boardSize = 4;
		this.board = new int[boardSize][boardSize];
	}
	
	public NQueens(int boardSize) {
		setBoardSize(boardSize);
		this.board = new int[boardSize][boardSize];
	}
	
	public void solve() {
		if(solveUtil(board, 0)) {
			printBoard(board);
		} else {
			System.out.println("No solution exists");
		}
	}
	
	private boolean solveUtil(int[][] board, int row) {
		if(row >= boardSize) {
			return true; // All queens placed successfully
		}
		for(int col = 0; col < boardSize; col++) {
			if(isSafe(board, row, col)) {
				board[row][col] = 1; // Place queen in a spot
				printBoard(board);
				if(solveUtil(board, row + 1)) {
					return true;
				}
				// Backtracking
				board[row][col] = 0;
			}
		}
		return false;
	}
	
	private boolean isSafe(int[][] board, int row, int col) {
		for(int i = 0; i < row; i++) {
			if(board[i][col] == 1) {
				return false;
			}
		}
		for(int i = row, j = col; i >= 0 && j >= 0; i--,j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		for(int i = row, j = col; i >= 0 && j >= boardSize; i--, j++) {
			if(board[i][j] == 1) {
				return false;
			}
		}	
		return true;
	}

	private void printBoard(int[][] board) {
		int i = 0;
		while(i < boardSize) {
			i++;
			System.out.print("-----");
		}
		System.out.println();
		for(int[] row : board) {
			System.out.print("| ");
			for(int cell : row) {
				if(cell == 1) {
					System.out.print("Q | ");
				} else {
					System.out.print(". | ");
				}				
			}
			System.out.println();
		}
		while(i > 0) {
			i--;
			System.out.print("-----");
		}
	}
	
	public int getBoardSize() {
		return boardSize;
	}
	
	public void setBoardSize(int boardSize) {
		if(boardSize < 4) {
			this.boardSize = 4;
			System.err.println("Board size cannot be less than 4.  Board size automatically set to 4.");
		} else {
			this.boardSize = boardSize;
		}		
	}
}