package com.mycompany.app;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=== Тестування таблиці множення ===");
        System.out.print("Скільки запитань? (натисніть Enter для 10): ");
        String countLine = myScanner.nextLine();
        int questions = 10;
        try {
            if (!countLine.trim().isEmpty()) {
                questions = Integer.parseInt(countLine.trim());
                if (questions <= 0) {
                    System.out.println("Невірна кількість, встановлено 10 запитань.");
                    questions = 10;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Невірний ввід, буде використано 10 запитань.");
            questions = 10;
        }

        System.out.print("Максимальний множник (наприклад 10) [натисніть Enter для 10]: ");
        String maxLine = myScanner.nextLine();
        int max = 10;
        try {
            if (!maxLine.trim().isEmpty()) {
                max = Integer.parseInt(maxLine.trim());
                if (max <= 0) {
                    System.out.println("Невірний множник, встановлено 10.");
                    max = 10;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Невірний ввід, буде використано 10.");
            max = 10;
        }

        int correct = 0;
        for (int i = 1; i <= questions; i++) {
            int a = rand.nextInt(max) + 1;
            int b = rand.nextInt(max) + 1;
            int answer = a * b;
            System.out.print("Питання " + i + ": " + a + " × " + b + " = ");
            String ansLine = myScanner.nextLine();
            try {
                int given = Integer.parseInt(ansLine.trim());
                if (given == answer) {
                    System.out.println("Правильно!");
                    correct++;
                } else {
                    System.out.println("Неправильно. Правильна відповідь: " + answer);
                }
            } catch (NumberFormatException e) {
                System.out.println("Невірний ввід. Правильна відповідь: " + answer);
            }
        }

        System.out.println();
        System.out.println("Результат: Ви відповіли правильно на " + correct + " з " + questions + ".");
        myScanner.close();
    }
}