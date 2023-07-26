import java.util.Scanner;

public class InputOutput {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public String inputReader(String prompt, String resultPrompt) {
        System.out.printf("""
                %s%s%s%n""", ANSI_RED, prompt, ANSI_RESET);

        Scanner scanner = new Scanner(System.in);

        String result = scanner.nextLine();

        System.out.printf("""
                %s%s%n""", resultPrompt, result);
        return result;
    }

    public void printData(String dataForPrint) {
        System.out.println(dataForPrint);
    }
}
