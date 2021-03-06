package ch.zhaw.papp.commands;

import ch.zhaw.papp.TextData;

import static ch.zhaw.papp.ConsoleInputReader.readNextLine;

/**
 * Command class to add new text to the TextData in last or selected paragraph.
 *
 * @author weberph5
 * @version 1.0.0
 */
public class AddTextCommand {
    private final Command command;

    /**
     * Creates an instance of AddTextCommand with its related command information.
     *
     * @param command the information on how the command should be executed
     * @author abuechi
     */
    public AddTextCommand(Command command) {
        this.command = command;
    }

    /**
     * Executes the ADD command
     *
     * @param textData the current TextData object
     * @author weberph5
     */
    public void execute(TextData textData) {
        if (command != null) {
            if (command.hasParams() && (command.getNumericParams() <= textData.getParagraphs().size() + 1)) {
                System.out.println("Enter the text you want to add");
                String textToAdd = readNextLine();
                addTextCommand(textData, textToAdd, command.getNumericParams());
            } else if (!command.hasParams()) {
                System.out.println("Enter the text you want to add");
                String textToAdd = readNextLine();
                addTextCommand(textData, textToAdd, textData.getParagraphs().size() + 1);
            } else {
                System.err.println("Paragraph number is not valid");
            }

        } else {
            System.err.println("Command is missing the command information.");
        }
    }


    private void addTextCommand(TextData textData, String textToAdd, Integer offset) {
        final boolean successFull = textData.insertTextAt(offset, textToAdd);
        if (!successFull) {
            System.err.println("Adding text was not successful. Paragraph number is invalid");
        }
    }
}
