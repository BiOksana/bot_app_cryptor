import commands.AbstractCommand;
import commands.CesarCryptorCommand;
import commands.CustomCryptorCommand;
import commands.UpperCaseCommand;
import exception.UnknownCommandException;

public class CommandHandler {

    private final static AbstractCommand[] commands = {new CesarCryptorCommand(), new CustomCryptorCommand(), new UpperCaseCommand()};

    private final static CommandHandler handler = new CommandHandler();

    private CommandHandler() {

    }

    public static CommandHandler getCommandHandler() {
        return handler;
    }

    public String handleCommand(String text) {
        if (checkOfCommand(text)) {
            text = text.replace("/", "");
            String commandString = text.substring(0, text.indexOf(" "));
            AbstractCommand abstractCommand = getCommand(commandString);
            return abstractCommand.execute(text.substring(text.indexOf(" ") + 1));
        } else {
            return "Unknown command. Command list is: \n" + getListOfCommand();
        }
    }

    public String getListOfCommand() {
        StringBuilder builder = new StringBuilder();
        for (AbstractCommand command : commands) {
            builder.append(command.getCommandName()).append("\n");
        }
        return builder.toString();
    }

    public boolean checkOfCommand(String text) {
        return text.startsWith("/");
    }

    public AbstractCommand getCommand(String text) {
        for (int i = 0; i < commands.length; i++) {
            if (text.equalsIgnoreCase(commands[i].getCommandName())) {
                return commands[i];
            }
        }
        throw new UnknownCommandException();
    }
}
