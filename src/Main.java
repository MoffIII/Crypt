import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";


    public static void main(String[] args) {

        int key = readInt();
        String string = readString();
        cryptText(string, key);
        deCryptText(string, key);

    }
    private static int readInt() {         //Ввод ключа
        //try catch ???
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число:");
        int a = sc.nextInt();
        System.out.println("Введено число:" + a);
        return a;
    }
    private static String readString() { // Ввод текста
        // try catch??
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите текст:");
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Введен текст: " + ANSI_RED + s + ANSI_RESET);
        return s;
    }
    public static int[] cryptText(String string, int key) { // Шифруем текст с ключом
        String[] result = string.split("");
        int[] ascArr = new int[result.length];
        char[] ascToSymArr = new char[result.length];

        for (int i = 0; i < result.length; i++) {
            int a = string.charAt(i);
            ascArr[i] = a + key;
        }
        for (int i = 0; i < ascArr.length; i++) {
            ascToSymArr[i] = (char) ascArr[i];
        }
        System.out.println("Закодированный цифровой текст: ");
        for (int j : ascArr) {
            System.out.print(ANSI_YELLOW + j + ANSI_RESET);
        }
        System.out.println();
        System.out.println("Закодированный текст в буквах: ");
        for (char c : ascToSymArr) {
            System.out.print(ANSI_PURPLE + c + ANSI_RESET);
        }
        return ascArr;
    }

    public static char[] deCryptText(String string, int key) { // дешифруем текст с ключом
        String[] result = string.split("");
        int[] ascArr = new int[result.length];
        char[] ascToSymArr = new char[result.length];
        for (int i = 0; i < result.length; i++) {
            int a = string.charAt(i);
            ascArr[i] = a;
        }
        for (int i = 0; i < ascArr.length; i++) {
            ascToSymArr[i] = (char) ascArr[i];
        }
        System.out.println();
        System.out.println("Расшифровка: ");
        for (char c : ascToSymArr) {
            System.out.print(ANSI_GREEN + c);
        }
        return ascToSymArr;
    }


}