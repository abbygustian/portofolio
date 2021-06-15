import java.util.*;

public class TicTacToe {
	static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();
	static String  user;
	static int userSymbol;
	TicTacToe(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Your Name : ");
		user = scan.nextLine();
		System.out.println("Enter Your choice symbol \n 1 . 'X' \n 2. 'O' \n\t\t : ");
		userSymbol = scan.nextInt();
		while(userSymbol >2 || userSymbol <=0) {
			if(userSymbol == 1 || userSymbol == 2) {
					userSymbol = scan.nextInt();
			}
			else {
				System.out.println("Oops... It's a wrong choice :( \n ");
				System.out.println("Please select \n 1 . 'X' \n 2. 'O' \t : ");
				userSymbol = scan.nextInt();
			}
		}
	}

	public static void main(String[] args) {
		new TicTacToe();
		
		char[][] gameBoard = {
				{ ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-', '+', '-', '+', '-' },
				{ ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-', '+', '-', '+', '-' },
				{ ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-', '+', '-', '+', '-' },
				{ ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-', '+', '-', '+', '-' },
				{ ' ', '|', ' ', '|', ' ', '|', ' ', '|', ' ' },
		};
		printGameConsole(gameBoard);
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("\n Enter Your placement number (1-25): ");
			int playerPlacement = sc.nextInt();
			while (playerPosition.contains(playerPlacement) || cpuPosition.contains(playerPlacement)) {
				System.out.println("\n The position has been taken! .. Choose another position : ");
				playerPlacement = sc.nextInt();
			}
			String finalResult = winner();
			if (finalResult.length() > 0) {
				System.out.print(finalResult);
				break;
			}
			placePiece(gameBoard, playerPlacement,user);
			printGameConsole(gameBoard);
			finalResult = winner();
			if (finalResult.length() > 0) {
				System.out.print(finalResult);
				break;
			}
			Random rand = new Random();
			int cpuPlacement = rand.nextInt(25) + 1;
			while (playerPosition.contains(cpuPlacement) || cpuPosition.contains(cpuPlacement)) {
				cpuPlacement = rand.nextInt(25) + 1;
			}
			placePiece(gameBoard, cpuPlacement, "cpu");
			printGameConsole(gameBoard);
		}
	}

	public static void placePiece(char[][] gameBoard, int placement, String user) {
		char symbol;
		char cpuIcon;
		char userIcon;
		if(userSymbol == 1) {
			cpuIcon = 'O';
			userIcon = 'X';
		} else {
			cpuIcon = 'X';
			userIcon = 'O';
		}
		if(user.equals("cpu")) {
			symbol = cpuIcon;
			cpuPosition.add(placement);
			System.out.println("\n Cpu placed at at " + placement);
			
		} else {
			symbol = userIcon;
			playerPosition.add(placement);
			System.out.println("\n" + user+ "  Placed at " + placement);
			
		}
		switch (placement) {

		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[0][6] = symbol;
			break;
		case 5:
			gameBoard[0][8] = symbol;
			break;
		case 6:
			gameBoard[2][0] = symbol;
			break;
		case 7:
			gameBoard[2][2] = symbol;
			break;
		case 8:
			gameBoard[2][4] = symbol;
			break;
		case 9:
			gameBoard[2][6] = symbol;
			break;
		case 10:
			gameBoard[2][8] = symbol;
			break;
		case 11:
			gameBoard[4][0] = symbol;
			break;
		case 12:
			gameBoard[4][2] = symbol;
			break;
		case 13:
			gameBoard[4][4] = symbol;
			break;
		case 14:
			gameBoard[4][6] = symbol;
			break;
		case 15:
			gameBoard[4][8] = symbol;
			break;
		case 16:
			gameBoard[6][0] = symbol;
			break;
		case 17:
			gameBoard[6][2] = symbol;
			break;
		case 18:
			gameBoard[6][4] = symbol;
			break;
		case 19:
			gameBoard[6][6] = symbol;
			break;
		case 20:
			gameBoard[6][8] = symbol;
			break;
		case 21:
			gameBoard[8][0] = symbol;
			break;
		case 22:
			gameBoard[8][2] = symbol;
			break;
		case 23:
			gameBoard[8][4] = symbol;
			break;
		case 24:
			gameBoard[8][6] = symbol;
			break;
		case 25:
			gameBoard[8][8] = symbol;
			break;

		}

	}

	// printing to console
	public static void printGameConsole(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	// Method to check the winner

	public static String winner() {
		List<List<Integer>> winCon = new ArrayList<List<Integer>>();
		winCon.add(Arrays.asList(1, 2, 3, 4, 5)); // first Row of the table
		winCon.add(Arrays.asList(6, 7, 8, 9, 10)); // Second Row of the table
		winCon.add(Arrays.asList(11, 12, 13, 14, 15)); // Third Row of the table
		winCon.add(Arrays.asList(16, 17, 18, 19, 20)); // Fourth Row of the table
		winCon.add(Arrays.asList(21, 22, 23, 24, 25)); // Fifth Row of the table
		winCon.add(Arrays.asList(1, 6, 11, 16, 21)); // First Column of the table
		winCon.add(Arrays.asList(2, 7, 12, 17, 22)); // Second Column of the table
		winCon.add(Arrays.asList(3, 8, 13, 18, 23)); // Third Column of the table
		winCon.add(Arrays.asList(4, 9, 14, 19, 24)); // Fourth Column of the table
		winCon.add(Arrays.asList(5, 10, 15, 20, 25)); // Fifth Column of the table
		winCon.add(Arrays.asList(1, 7, 13, 19, 25)); // first diagonal of the table
		winCon.add(Arrays.asList(5, 9, 13, 17, 21)); // Second diagonal of the table

		for (List<Integer> l : winCon) {
			if (playerPosition.containsAll(l)) {
				return "Congratulations! "+user+", You Won.";
			} else if (cpuPosition.containsAll(l)) {
				return "Cpu Won!, Sorry :( ";
			} else if (playerPosition.size() + cpuPosition.size() == 25) {
				return "Draw!!!";
			}   
		}
		return "";
	}

}
