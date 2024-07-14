package javatask;
import java.util.*;

	public class Task1{

	    public static int GenerateRandom(){
	        Random random = new Random();
	        int randomNumber = (random.nextInt(100) + 1); // between 1 -100
	        return randomNumber;
	    }

	    public static void GuessNumberGame(){
	        Scanner sobj = new Scanner(System.in);

	        int[] Score = new int[3]; 
	        System.out.println("\nThere are 3 Rounds, \nin each roud you will have 5 attempts to guess the correct number , based on it you will get score.");
	        System.out.println("Rules : \nIf you guessed the number in first attemp 5 points, if in second guess 4 points and so on.");

	        for(int i = 0; i < 3; i++){
	            int randomNumber = GenerateRandom();
	            System.out.println("\n-----------------------------------------------------");
	            System.out.println("Round "+(i + 1)+" started");
	            System.out.println("Random number is : "+randomNumber);
	            int attempts = 5;
	            int iCnt = 1;
	            while(iCnt <= attempts){
	                System.out.println("-----------------------------------------------------");
	                System.out.println("Attempts left : "+(attempts - iCnt));
	                System.out.println("Enter a number : ");
	                int number = sobj.nextInt();
	                iCnt++;

	                if(number == randomNumber){
	                    System.out.println("Your guess is correct!!\n");
	                    System.out.println("Score : "+(attempts - iCnt + 2));
	                    Score[i] = attempts - iCnt + 2;
	                    break;
	                }else{
	                    System.out.println("Your guess is wrong!, try again!");
	                }

	                System.out.println("-----------------------------------------------------");
	            }

	            if(iCnt > attempts + 1){
	                Score[i] = 0;
	                System.out.println("You have zero attempts left!, Game Over");
	            }
	        }

	        System.out.println("\n-------------------------------------------\nScoreboard\nRounds\tScore");
	        for (int i = 0; i < 3; i++){
	            System.out.println("-------------------------------------------");
	            System.out.println("Round "+(i+1)+" | "+Score[i]);
	        }

	        System.out.println("-------------------------------------------");
	        System.out.println("\nThank you for playing this game.");

	        sobj.close();
	    }

	    public static void main(String args[]){
	        
	        GuessNumberGame();
	    }
	}

