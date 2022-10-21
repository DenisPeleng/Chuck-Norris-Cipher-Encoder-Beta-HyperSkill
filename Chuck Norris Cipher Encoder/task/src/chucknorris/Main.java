package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String inputStr = scanner.nextLine();
        for (char currentChar : inputStr.toCharArray()
        ) {
            System.out.print(currentChar + " ");
        }
    }
}