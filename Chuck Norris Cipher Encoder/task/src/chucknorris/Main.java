package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input encoded string:");
        String inputStr = scanner.nextLine();
        System.out.println("The result:");
        System.out.println(chuckNorrisDecoder(inputStr));
    }


    public static String strToChuckEncode(String inputStr) {
        StringBuilder fullStrInChuck = new StringBuilder();
        for (char currentChar : inputStr.toCharArray()) {
            String binaryRepresent = String.format("%07d", Integer.parseInt(Integer.toBinaryString(currentChar)));
            fullStrInChuck.append(chuckNorrisEncoderBinary(binaryRepresent)).append(" ");
        }
        return fullStrInChuck.toString();
    }

    public static String chuckNorrisEncoderBinary(String str) {
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

    public static String chuckNorrisDecoder(String str) {
        String[] strInChuckFormat = str.split(" ");
        StringBuilder binaryRepresent = new StringBuilder();
        String firstSymbol;
        for (int i = 0; i < strInChuckFormat.length; i = i + 2) {
            if (strInChuckFormat[i].equals("00")) {
                firstSymbol = "0";
            } else {
                firstSymbol = "1";
            }
            binaryRepresent.append(firstSymbol.repeat(strInChuckFormat[i + 1].toCharArray().length));
        }
        char[] binaryArr = binaryRepresent.toString().toCharArray();
        StringBuilder stringFromBinary = new StringBuilder();
        for (int i = 0; i < binaryArr.length; i = i + 7) {
            char chrFromBin = (char) Integer.parseInt(binaryRepresent.substring(i, i + 7), 2);
            stringFromBinary.append(chrFromBin);
        }
        return stringFromBinary.toString();
    }
}