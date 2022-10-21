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
            System.out.print(chuckNorrisRepresentation(binaryRepresent)+" ");

        }
    }

    public static String chuckNorrisRepresentation(String str) {
        StringBuilder chuckRepresent = new StringBuilder();
        boolean isFirstBlock = true;

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isFirstBlock) {
                if (chars[i] == '1') {
                    chuckRepresent.append("0 0");
                } else {
                    chuckRepresent.append("00 0");
                }
                isFirstBlock = false;
            } else {
                if (chars[i] == chars[i - 1]) {
                    chuckRepresent.append("0");
                } else {
                    chuckRepresent.append(" ");
                    isFirstBlock = true;
                    i--;
                }
            }

        }
        return chuckRepresent.toString();
    }

}