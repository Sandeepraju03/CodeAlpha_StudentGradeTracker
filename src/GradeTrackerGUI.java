package com.codealpha.grade;

import javax.swing.*;
import java.awt.*;

public class GradeTrackerGUI extends JFrame {
    private StudentManager manager = new StudentManager();
    private JTextArea reportArea;
    private JTextField nameField, scoreField;

    public GradeTrackerGUI() {
        setTitle("Student Grade Tracker (GUI)");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField(10);
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Score:"));
        scoreField = new JTextField(5);
        inputPanel.add(scoreField);

        JButton addButton = new JButton("Add Student");
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        // Report Area
        reportArea = new JTextArea();
        reportArea.setEditable(false);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        // Add Button Action
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            try {
                int score = Integer.parseInt(scoreField.getText());
                manager.addStudent(name, score);
                updateReport();
                nameField.setText("");
                scoreField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid score!");
            }
        });
    }

    private void updateReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Report ---\n");
        for (Student s : manager.getStudents())
            sb.append(s).append("\n");
        sb.append("\nAverage Score: ").append(manager.getAverageScore());
        sb.append("\nHighest: ").append(manager.getHighestScore());
        sb.append("\nLowest: ").append(manager.getLowestScore());
        reportArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GradeTrackerGUI().setVisible(true));
    }
}
