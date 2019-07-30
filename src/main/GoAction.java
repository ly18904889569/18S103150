package main;

public class GoAction implements Action
{

	public void goPlaying(int x, int y, Board boa, Player player, char type)
	{
		boa.goPlay(x, y, type);
		player.record(x, y);
	}

	@Override
	public void takeAway(int x, int y, Board boa)
	{
		boa.goPlay(x, y, '0');

	}

	@Override
	public void chessPlaying(int x, int y, int x1, int y1, Player player,
			Board boa)
	{
		boa.chessPlay(x, y, x1, y1);
		player.chessRecord(x, y, x1, y1, boa.getBoa()[x1 - 1][y1 - 1]);

	}

}
