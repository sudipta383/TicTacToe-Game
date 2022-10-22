import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Tictactoe {

	static ArrayList<Integer> playerpos=new ArrayList<>();
	static ArrayList<Integer> CPUpos=new ArrayList<>();
	static int result=0;
	

	public static void main(String[] args) {
		
		
		char[][]boardstructure= {
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
		};

		Scanner sc = new Scanner(System.in);

		while(true)
		{
			System.out.println("Player 1: ");
			System.out.println("Enter your move based on 1-9");
			int pos=sc.nextInt();
			while(playerpos.contains(pos)|| CPUpos.contains(pos))
			{
				System.out.println("Position already taken! please try again");
				pos=sc.nextInt();

			}
			placeholder(boardstructure, pos, "Player");
			printBoard(boardstructure);
			System.out.println(Winnerprediction());

			/* Random rand= new Random(); */

			System.out.println("Player 2: ");
			System.out.println("Enter your move based on 1-9");
			int cpupos=sc.nextInt();
			while(playerpos.contains(cpupos)|| CPUpos.contains(cpupos))
			{
				System.out.println("Position already taken! please try again");
				cpupos=sc.nextInt();

			}
			placeholder(boardstructure, cpupos, "CPU");
			printBoard(boardstructure);
			System.out.println(Winnerprediction());

			String result = Winnerprediction();
			if(result.length()==9)
			{
				System.out.println("GAME OVER!");

			}
			System.out.println(Winnerprediction());

			
			

		}
		
		

		


		
		

	}
	
	static void printBoard(char[][]board)
	{
		for(char []c:board)
		{
			for(char d:c)
			{
				System.out.print(d);
			}
			System.out.println();
			
		}
	}

	static void placeholder(char [][]boardstructure, int pos, String user)
	{
		char symbol=' ';
		if(user.equals("Player"))
		{
			symbol='X';
			playerpos.add(pos);

		}
		else if(user.equals("CPU"))
		{
			symbol='O';
			CPUpos.add(pos);
		}
		{

		}
		switch(pos)
		{
			case 1: 
					boardstructure[0][0]=symbol;
					break;
			case 2: 
					boardstructure[0][2]=symbol;
					break;
			case 3: 
					boardstructure[0][4]=symbol;
					break;
			case 4: 
					boardstructure[2][0]=symbol;
					break;
			case 5: 
					boardstructure[2][2]=symbol;
					break;
			case 6: 
					boardstructure[2][4]=symbol;
					break;
			case 7: 
					boardstructure[4][0]=symbol;
					break;
			case 8: 
					boardstructure[4][2]=symbol;
					break;
			case 9: 
					boardstructure[4][4]=symbol;
					break;
			default:System.out.println("You have entered an wrong option");
					break;
		}

	}

	static String Winnerprediction()
	{
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List bottomRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(7,5,3);

		List<List> winner =new ArrayList<>();
		winner.add(topRow);
		winner.add(midRow);
		winner.add(bottomRow);
		winner.add(leftCol);
		winner.add(midCol);
		winner.add(rightCol);
		winner.add(cross1);
		winner.add(cross2);


		for(List l: winner)
		{
			if(playerpos.containsAll(l))
			{
				
				return "Congratulation You Won";
			}
				else if(CPUpos.containsAll(l))
				{
					return"Sorry! CPU Won";
					
				}
			else if(playerpos.size()+CPUpos.size()==9)
			{
				return"Match Draw";

			}
		}





		return "";
	}

}
