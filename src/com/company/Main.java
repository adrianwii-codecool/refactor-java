package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner( System.in );
    private static Random random = new Random();

    public static void main(String[] args) {
        menu();
        System.out.println("Select option");

        switch(scanner.nextInt()) {
            case 1:
                System.out.println("Choose your number:");
                int a = scanner.nextInt();
                int b = random.nextInt(100);
                compareNumbers(a, b);
                break;
            case 2:
                System.out.println("Provide your sentence:");
                scanner.nextLine();
                String sentence = scanner.nextLine();
                sentenceHistogram(sentence);
                break;
            case 3:
                System.out.println("Bye bye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection");
        }
    }

    private static void compareNumbers(int a, int b) {
        System.out.println(a + " " + b);
        System.out.println("Check if your number is greater than computer's number");
        System.out.println((a > b) ? "A is grater than B" : "B is grater than A");

        validate(a, b);
    }

    public static void menu() {
        System.out.println("| MENU                         |");
        System.out.println("| Options:                     |");
        System.out.println("|        1. Number comparision |");
        System.out.println("|        2. Sentence histogram |");
        System.out.println("|        3. Exit               |");
    }

    public static void validate(int a, int b) {
        if(isNumberInRange(a, 0, 10)) {
            return;
        }

        System.out.println("A is greater than 10!");
        multiply(a, b);
        System.out.println((b < 10) ? "B is less than A!" : "B is greater than or equal 10!");

        if(a < b) {
            System.out.println("The numbers entered do not match the conditions!");
            return;
        }
    }

    public static boolean isNumberInRange(int number, int a, int b) {
        return number < b && number > a;
    }

    public static int multiply(int a, int b) {
        return a*b;
    }

    public static void sentenceHistogram(String sentence) {
        sentence = sentence.toUpperCase().replaceAll("\\s+","");
        int counter = 0;
        int length = sentence.length();
        Map<Character, Integer> histogram = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Character ch = sentence.charAt(i);

            if (histogram.containsKey(ch)) {
                continue;
            }

            for (int j = 0; j < length; j++) {
                if (sentence.charAt(j) == ch) {
                    counter++;
                }
            }
            histogram.put(ch, counter);
            counter = 0;
        }

        printHistogram(histogram);
    }

    private static void printHistogram(Map<Character, Integer> histogram) {
        for(Character key : histogram.keySet()) {
            Integer value = histogram.get(key);
            System.out.println(key + ": " + "+".repeat(value));
        }
    }
}
