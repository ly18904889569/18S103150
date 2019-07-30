package main;

import java.util.Scanner;

public class Game
{

	public static final String Chess = "chess";
	public static final String Go = "go";
	public static final String End = "end";

	public Game()
	{

		Scanner in = new Scanner(System.in);
		boolean flag = true; // crazy:cyclic marker
		boolean flag2 = true;
		boolean flag3 = true;
		// crazy:coordinate
		// crazy:(x_before,y_before) turn into (x_later,y_later)
		int x_before = 0, y_before = 0;
		int x_later = 0, y_later = 0;
		int choice = 0;
		int record = 0;
		int bre = -1;
		int bre2 = -1;

		while (flag)
		{
			System.out.println("********************☺********************");
			System.out
					.println("Please enter the game type：chess, go or end(such as chess)");
			String opt = in.next();
			if (opt.equals(End))
			{
				flag = false; // crazy:termination of the cycle
				break;
			}
			System.out.println("********************☺********************");
			System.out
					.println("Please enter the name of Player 1:(such as liyang)");
			String playerName = in.next();
			Player playerOne = new Player();
			playerOne.setPlayername(playerName);

			System.out.println("********************☺********************");
			System.out
					.println("Please enter the name of Player 2:(such as weixi)");
			playerName = in.next();

			Player playerTwo = new Player();
			playerTwo.setPlayername(playerName);
			GoAction action = new GoAction();

			// ********************chess********************

			if (opt.equals(Chess))
			{
				Board chess = new Board();
				chess.createBoard(8);

				while (flag2)
				{
					System.out
							.println("********************☺********************");
					System.out
							.println("Operations of Player One: 1 drop a chess piece  2 Close the Round  3 end (such as 1)");
					// crazy:Operations of Player One
					choice = in.nextInt();
					bre=Choice(choice,flag2,playerOne,action,chess);
					if (bre == 3)
					{
						break;
					}
					
					// crazy:Operations of Player Two
					System.out
							.println("Operations of Player Two: 1 drop a chess piece  2 Close the Round  3 end (such as 1)");
					choice = in.nextInt();
					bre=Choice(choice,flag2,playerTwo,action,chess);
					if (bre == 3)
					{
						break;
					}
				}
				Record(playerOne,playerTwo);

			} 
			
			// ********************go********************
			
			
			else if (opt.equals(Go))
			{
				Board go = new Board();
				go.createBoard(18);
				while (flag3)
				{
					// crazy:Operations of Player One
					System.out
							.println("********************☺********************");
					System.out
							.println("Operations of Player One: 1 drop a chess piece  2 Close the Round  3 end (such as 1)");
					choice = in.nextInt();
					bre2=Choice2(choice,flag3,playerOne,action,go);
					if (bre2 == 3)
					{
						break;
					}
					
					// crazy:operation of player2
					System.out.println("********************☺********************");
					System.out
							.println("Operations of Player Two: 1 drop a chess piece  2 Close the Round  3 end (such as 1)");
					choice = in.nextInt();
					bre2=Choice3(choice,flag3,playerTwo,action,go);
					if (bre2 == 3)
					{
						break;
					}
				}
				Record(playerOne,playerTwo);
			} 
			
			else
			{
				System.out.println("Invalid input!");
			}

		}

	}

	private void Player()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("********************☺********************");
		System.out
				.println("Please enter the name of Player 1:(such as liyang)");
		String playerName = in.next();
		Player playerOne = new Player();
		playerOne.setPlayername(playerName);

		System.out.println("********************☺********************");
		System.out
				.println("Please enter the name of Player 2:(such as weixi)");
		playerName = in.next();

		Player playerTwo = new Player();
		playerTwo.setPlayername(playerName);
		
	}

	private int Choice3(int choice, boolean flag3, Player playerTwo,
			GoAction action, Board go)
	{
		Scanner in = new Scanner(System.in);
		int x_before = 0,y_before = 0;	
		int x_later= 0,y_later= 0;
		if (choice == 1)
		{
			System.out.println("********************☺********************");
			System.out.println("Please enter coordinates like 1 1");
			x_before = in.nextInt();
			y_before = in.nextInt();
			// go
			action.goPlaying(x_before, y_before, go, playerTwo, 'B');
			System.out.println("********************☺********************");
			System.out
					.println("Please enter the number of tizi,0 is not tizi(such as 0)");
			int killNumber = in.nextInt();
			while (killNumber > 0)
			{
				System.out.println("********************☺********************");
				System.out
						.println("Please enter coordinates like 1 1");
				x_before = in.nextInt();
				y_before = in.nextInt();
				action.takeAway(x_before, y_before, go);
				killNumber--;
			}
			System.out.println("This phase ends");
		}
		if (choice == 2)
		{
			System.out.println("Skip round");
		}
		if (choice == 3)
		{
			System.out
					.println("Player 1 wins at the end of the game");
			return 3;
		}
		go.print();
		return 0;
	}

	private int Choice2(int choice, boolean flag3, Player player,
			GoAction action, Board go)
	{
		Scanner in = new Scanner(System.in);
		int x_before = 0,y_before = 0;	
		int x_later= 0,y_later= 0;
		
		if (choice == 1)
		{
			System.out.println("********************☺********************");
			System.out.println("Please enter coordinates like 1 1");
			x_before = in.nextInt();
			y_before = in.nextInt();
			// crazy:go
			action.goPlaying(x_before, y_before, go, player, 'A');
			System.out.println("********************☺********************");
			System.out
					.println("Please enter the number of tizi,0 is not tizi (such as 0)");
			int killNumber = in.nextInt();
			while (killNumber > 0)
			{
				System.out.println("********************☺********************");
				System.out
						.println("Please enter coordinates like 1 1");
				x_before = in.nextInt();
				y_before = in.nextInt();
				action.takeAway(x_before, y_before, go);
				killNumber--;
			}
			System.out.println("This phase ends");
		}
		if (choice == 2)
		{
			System.out.println("Skip round");
		}
		if (choice == 3)
		{
			System.out
					.println("Player 2 wins at the end of the game");
			return 3;
		}
		go.print();
		return 0;
	}

	private void Record(Player playerOne,Player playerTwo)
	{
		Scanner in = new Scanner(System.in);
		int record = 0;
		System.out.println("********************☺********************");
		System.out
				.println("Whether Chess Records of Player No.1？ 1 yes  2 no (such as 1)");
		record = in.nextInt();
		if (record == 1)
		{
			playerOne.printRecord();
		}
		System.out.println("********************☺********************");
		System.out
				.println("Whether Chess Records of Player No.2？ 1 yes  2 no (such as 1)");
		record = in.nextInt();
		if (record == 1)
		{
			playerTwo.printRecord();
		}
		
	}

	private int Choice(int choice, boolean flag2, Player playerOne, GoAction action, Board chess)
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int x_before = 0,y_before = 0;	
		int x_later= 0,y_later= 0;
		if(choice == 1)
		{
			System.out.println("Please move the chess pieces like that");
			Print();
			x_before = in.nextInt();
			y_before = in.nextInt();
			x_later= in.nextInt();
			y_later= in.nextInt();
			action.chessPlaying(x_before, y_before, x_later, y_later, playerOne, chess);
		}
		if(choice == 2)
		{
			System.out.println("Round skip");
		}
		if(choice == 3)
		{
			System.out.println("Player 2 wins at the end of the game");
			flag2 = false;
			return 3;
		}
		chess.print();
		return 0;
		
		
	}
	
	private void Print()
	{
		System.out.println("1");
		System.out.println("1");
		System.out.println("2");
		System.out.println("2");
		System.out.println("this means (1,1) turns to (2,2)");

	}
}
