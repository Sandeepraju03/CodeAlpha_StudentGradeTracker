package com.codealpha.grade;

import java.util.Scanner;

public class ConsoleGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        System.out.println("=== Student Grade Tracker (Console) ===");

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = sc.next();
                    System.out.print("Enter score: ");
                    int score = sc.nextInt();
                    manager.addStudent(name, score);
                    System.out.println("✅ Student added!");
                    break;

                case 2:
                    System.out.println("\n--- Report ---");
                    for (Student s : manager.getStudents())
                        System.out.println(s);
                    System.out.println("Average Score: " + manager.getAverageScore());
                    System.out.println("Highest Scorer: " + manager.getHighestScore());
                    System.out.println("Lowest Scorer: " + manager.getLowestScore());
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
