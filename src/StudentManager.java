package com.codealpha.grade;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name, int score) {
        students.add(new Student(name, score));
    }

    public double getAverageScore() {
        if (students.isEmpty()) return 0;
        int total = 0;
        for (Student s : students) total += s.getScore();
        return (double) total / students.size();
    }

    public Student getHighestScore() {
        if (students.isEmpty()) return null;
        Student max = students.get(0);
        for (Student s : students) {
            if (s.getScore() > max.getScore()) max = s;
        }
        return max;
    }

    public Student getLowestScore() {
        if (students.isEmpty()) return null;
        Student min = students.get(0);
        for (Student s : students) {
            if (s.getScore() < min.getScore()) min = s;
        }
        return min;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
