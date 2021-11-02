/**
 * Contains the Text Editor life cycle
 *
 * @author weberph5
 * @version 1.0.0
 */

public class TextEditor {
    ConsoleInputReader inputReader = new ConsoleInputReader();
    Commands commands = new Commands();

    public TextEditor() {
    }

    /**
     *  Starts the Text Editor and keeps it running
     */
    public void start() {
        System.out.println("***********************************");
        System.out.println("* Welcome to the best TextEditor! *");
        System.out.println("***********************************");
        commands.showCommands();
        boolean isRunning = true;
        while (isRunning) {
            editText();
        }
    }

    private void editText() {
        System.out.println("Please enter a command:");
        inputReader.stringInputReader();
    }
}

