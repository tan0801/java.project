package javatask;

	import java.util.*;

	public class Task2{

	    public static float CalculatePercentage(int totalMarksObtained, int numberOfSubjects){
	        float avgPercentage = 0.0f;

	        avgPercentage = ( (float)totalMarksObtained / (float)numberOfSubjects);

	        return avgPercentage;
	    }

	    public static int MarksObtained(String[] subjects, int[] marks){
	        int totalMarksObtained = 0;
	        for(int i = 0; i < marks.length; i++){
	            totalMarksObtained = totalMarksObtained + marks[i];
	        }
	        return totalMarksObtained;
	    }

	    public static String CalculateGrade(float avgPercentage){

	        String grade;

	        if(avgPercentage >= 90.00){
	            grade = "A";
	        }else if(avgPercentage >= 75.00){
	            grade = "B";
	        }else if(avgPercentage >= 65.00){
	            grade = "C";
	        }else if(avgPercentage >= 55.00){
	            grade = "D";
	        }else{
	            grade = "Fail";
	        }

	        return grade;
	    }

	    public static void main(String args[]){
	        Scanner sobj = new Scanner(System.in);
	        System.out.println("Enter the number of subjects you have : ");
	        int numberOfSubjects = sobj.nextInt();
	        String[] subjects = new String[numberOfSubjects];
	        int[] marks = new int[numberOfSubjects];

	        System.out.println("Enter the names of Subject and marks obtained in that respective subject out of 100.\n");

	        for(int i = 0; i < numberOfSubjects; i++){
	            sobj.nextLine();
	            System.out.print((i+1)+".\tSubject : ");
	            subjects[i] = sobj.nextLine();
	            System.out.print(" \tMarks : ");
	            marks[i] = sobj.nextInt();
	            System.out.println();
	        }

	        int totalMarksObtained = MarksObtained(subjects, marks);
	        float avgPercentage = CalculatePercentage(totalMarksObtained, marks.length);
	        String grade = CalculateGrade(avgPercentage);

	        System.out.println("Total marks obtained : "+totalMarksObtained);
	        System.out.println("Average percentage : "+avgPercentage);
	        System.out.println("Grade : "+grade);

	        sobj.close();
	        
	    }
	}

