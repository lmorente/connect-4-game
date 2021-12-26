package game.utils;

import java.util.Scanner;

public class Printer {

    private final static Scanner scanner = new Scanner(System.in);

    public static void print(String message) {
        System.out.print(message);
    }

    public static void printLine(String message) {
        System.out.println(message);
    }

    public static String getOrderColumn() {
        return scanner.nextLine();
    }
}
