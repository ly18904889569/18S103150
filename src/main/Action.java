package main;

import javax.swing.border.Border;

public interface Action
{
	public void goPlaying(int x_before, int y_before, Board board, Player player, char type);

	public void takeAway(int x_before, int y_before, Board board);

	public void chessPlaying(int x_before, int y_before, int x_after, int y_after, Player player,
			Board board);
}
