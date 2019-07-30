package main;

public class GoPlayer implements DPA
{
	public String player1name;
	public String player2name;

	@Override
	public void addPlayer(String player1, String player2)
	{
		player1name = player1;
		player2name = player2;

	}

	public void getPlayersName()
	{
		System.out.println("play1's name ：" + player1name + "    player2's name"
				+ player2name);
	}

}
