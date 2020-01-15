package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int a;
        int b;
        Random random = new Random();

        System.out.println("| MENU                         |");
        System.out.println("| Options:                     |");
        System.out.println("|        1. Number comparision |");
        System.out.println("|        2. Sentence histogram |");
        System.out.println("|        3. Exit               |");

        System.out.println("Select option");
        int option;
        Scanner scanner = new Scanner( System.in );
        option = scanner.nextInt();

        if (option == 1) {
            System.out.println("Choose your number:");
            a = scanner.nextInt();
            b = random.nextInt(100);

            System.out.println(a + " " + b);
            System.out.println("Check if your number is greater than computer's number");
            if (a > b) {
                System.out.printf("A is grater than B%n");
            } else {
                System.out.printf("B is grater than A%n");
            }

            validate(a, b);
        } else if (option == 2) {
            System.out.println("Provide your sentence:");
            scanner.nextLine();
            String sentence = scanner.nextLine();
            sentenceHistogram(sentence);
        } else if (option == 3) {
            System.out.println("Bye bye!");
            System.exit(0);
        } else {
            System.out.println("Invalid selection");
        }
    }

    public static void validate(int a, int b) {
        if(a > 10) {
            System.out.println("A is greater than 10!");
            multiply(a, b);

            if (b < 10) {
                System.out.println("B is less than A!");
            } else {
                System.out.println("B is greater than or equal 10!");
                if(a < b) {
                    System.out.println("The numbers entered do not match the conditions!");
                }
            }
        }
    }

    public static int multiply(int a, int b) {
        return a*b;
    }

    public static void sentenceHistogram(String sentence) {
        sentence = sentence.toUpperCase().replaceAll("\\s+","");
        int cnt = 0;
        Map<Character, Integer> histogram = new HashMap<>();

        for (int i = 0; i < sentence.length(); i++) {
            Character ch = sentence.charAt(i);
            if (ch.equals(" ")) {
                continue;
            }
            if (histogram.containsKey(ch)) {
                continue;
            }

            for (int j = 0; j < sentence.length(); j++) {
                if (sentence.charAt(j) == ch)
                    cnt++;
            }
            histogram.put(ch, cnt);
            cnt = 0;
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
