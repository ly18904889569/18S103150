package main;

public class Board
{
	public char[][] board;
	public Piece piece;

	public Piece getPiece()
	{
		return piece;
	}

	public void setPiece(Piece piece)
	{
		this.piece = piece;
	}

	public char[][] createBoard(int n)
	{
		board = new char[n][n];
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				board[i][j] = '0';
			}
		}
		if (n == 8)
		{
			board[0][0] = 'R';
			board[7][0] = 'r';
			board[0][7] = 'R';
			board[7][7] = 'r';
			board[0][1] = 'K';
			board[7][1] = 'k';
			board[0][6] = 'K';
			board[7][6] = 'k';
			board[0][2] = 'B';
			board[7][2] = 'b';
			board[0][5] = 'B';
			board[7][5] = 'b';
			board[0][3] = 'W';
			board[7][3] = 'w';
			board[0][4] = 'Q';
			board[7][4] = 'q';
			for (int i = 0; i < n; i++)
			{
				board[1][i] = 'P';
				board[6][i] = 'p';
			}
		}
		return board;
	}

	public void print()
	{
		if (board == null || board.length == 0)
		{
			System.out.println("Initialize the chessboard first");
		} else
		{
			for (int i = 0; i < board.length; i++)
			{
				for (int j = 0; j < board[0].length; j++)
				{
					System.out.print(board[i][j] + " ");

				}
				System.out.println();
			}
		}
	}

	public char[][] getBoa()
	{
		return board;
	}

	public void setBoa(char[][] boa)
	{
		this.board = boa;
	}

	public void goPlay(int x, int y, char type)
	{
		board[x - 1][y - 1] = type;
	}

	public void chessPlay(int x, int y, int x1, int y1)
	{
		board[x1 - 1][y1 - 1] = board[x - 1][y - 1];
		board[x - 1][y - 1] = '0';
	}
}
