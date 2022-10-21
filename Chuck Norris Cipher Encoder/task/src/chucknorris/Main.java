package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string:");
        String inputStr = scanner.nextLine();
        System.out.println("The result:");
        for (char currentChar : inputStr.toCharArray()
        ) {
            String binaryRepresent = String.format("%07d", Integer.parseInt(Integer.toBinaryString(currentChar)));
            System.out.printf("%c = %s%n", currentChar, binaryRepresent);
        }
    }

}