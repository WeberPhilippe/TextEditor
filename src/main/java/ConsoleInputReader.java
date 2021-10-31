import java.util.Scanner;
import java.util.regex.*;

public class ConsoleInputReader {

    private final Scanner inputReader;
    private static final String notAllowedTextElements = "[^a-zA-Z0-9.,:;!?’()\"%@+*\\-\\[\\]{}/&#$]";
    private static final Pattern regExSymbols = Pattern.compile(notAllowedTextElements);

    public ConsoleInputReader() {
        inputReader = new Scanner(System.in);
    }

    public String stringInputReader() {
        String userTextInput = inputReader.nextLine();
        Matcher regExMatcher = regExSymbols.matcher(userTextInput);
        if (regExMatcher.matches()) {
            System.err.println("Your text doesn't just contain letters, numbers, spaces or punctuation marks such as .,:;-!?’()\"%@+*[]{}/&#$");
            return stringInputReader();
        } else {
            return userTextInput.trim();
        }
    }

    public int numberInputReader() {
        if (inputReader.hasNextInt()) {
            int userNumberInput = inputReader.nextInt();
            if (userNumberInput < 1) {
                System.err.println("Type in a number greater than one");
                return numberInputReader();
            } else {
                return userNumberInput;
            }
        } else {
            System.err.println("Type in a number");
            inputReader.next();
            return numberInputReader();
        }
    }


    //Im Whileloop methode aufrufen.
    public void closeScanner() {
        inputReader.close();
    }

}
