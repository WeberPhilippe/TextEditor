import java.util.HashSet;
import java.util.Set;

public class Commands {
    private static final String dummyText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam sed quam sit amet ex dapibus egestas vel congue metus. Donec id eleifend nisi, vitae eleifend tortor. Quisque euismod vitae nisi fringilla dignissim. In aliquam finibus nisl vel euismod. Ut ac sodales elit. Proin rhoncus libero turpis, eget tempor nisl consequat sed. Proin tempus erat magna, vitae sodales arcu fringilla sit amet. Nunc elementum, velit placerat iaculis feugiat, lectus dolor dapibus velit, in maximus sapien felis at arcu. Nulla mollis suscipit egestas. Phasellus a volutpat libero, nec tincidunt tortor. Aenean mattis ligula eu efficitur ultricies. Vestibulum ac nibh sodales, venenatis sapien vel, maximus nisi. Curabitur feugiat dictum tortor, a hendrerit urna tincidunt vitae.";
    ConsoleInputReader inputReader = new ConsoleInputReader();

    /**
     * Shows a list and description of all available commands.
     *
     * @author weberph5
     */
    public void showCommands() {
        System.out.println("Available Commands (Case sensitive!):");
        System.out.println();
        for (Command command : Command.values()) {
            System.out.println(command.getCommandInfo());
        }
        System.out.println();
    }

    public boolean executeDummyCommand(TextData text) {
        return text.insertTextAt(null, " " + dummyText);
    }

    public boolean executeDummyCommand(TextData text, int offset) {
        return text.insertTextAt(offset, " " + dummyText);
    }

    /**
     * Closes the TextEditor by setting isRunning in TextEditor to false.
     *
     * @return false
     * @author weberph5
     */
    public boolean exitEditor() {
        System.out.println("Closing the TextEditor. Bye.");
        inputReader.closeScanner();
        return false;
    }
}
