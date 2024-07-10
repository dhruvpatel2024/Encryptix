import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();
        
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }
        
        double averagePercentage = (double) totalMarks / numSubjects;
        
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        System.err.println("***********************************************");
        System.out.println("Total Marks: " + totalMarks);
        System.out.format("Average Percentage: %.2f", averagePercentage);
        System.out.println("%\nGrade: " + grade);
        System.err.println("***********************************************");
        
        sc.close();
    }
}
