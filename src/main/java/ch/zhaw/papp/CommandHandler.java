package ch.zhaw.papp;

import ch.zhaw.papp.commands.*;

import static ch.zhaw.papp.ConsoleInputReader.readNextLine;
import static ch.zhaw.papp.commands.PrintCommand.print;
import static ch.zhaw.papp.commands.ReplaceCommand.replaceCommand;

/**
 * A class that handles all commands and makes sure the correct commands are executed.
 *
 * @author abuechi
 * @version 1.0.0
 */
public class CommandHandler {

    /**
     * Executes the command that was entered.
     *
     * @param command  command that represents arguments and command enum
     * @param textData the textdata object
     * @author abuechi
     */
    public void executeCommand(Command command, TextData textData) {
        switch (command.getCommand()) {
            case ADD:
                final AddTextCommand addTextCommand = new AddTextCommand(command);
                addTextCommand.execute(textData);
                print(textData);
                break;
            case DELETE:
                final DeleteCommand deleteCommand = new DeleteCommand(command);
                deleteCommand.execute(textData);
                break;
            case DUMMY:
                final DummyCommand dummyCommand = new DummyCommand(command);
                dummyCommand.execute(textData);
                print(textData);
                break;
            case EXIT:
                final ExitCommand exitCommand = new ExitCommand();
                exitCommand.execute();
                break;
            case INDEX:
                break;
            case PRINT:
                print(textData);
                break;
            case REPLACE:
                System.out.println("Write the word / text you want to replace.");
                String textToReplace = readNextLine();
                System.out.println("Write the word / text you want to replace it with.");
                String newText = readNextLine();
                replaceCommand(textData, textToReplace, newText, command);
                print(textData);
                break;
            case FORMAT_FIX:
                break;
            case FORMAT_RAW:
                break;
            case SHOW_COMMANDS:
                final ShowCommand showCommand = new ShowCommand();
                showCommand.execute();
                break;
            default:
                System.err.println("This command is not available. Use 'SHOW COMMANDS' for available commands.");
                break;
        }
    }
}
