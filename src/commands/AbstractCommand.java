package commands;

public interface AbstractCommand {

    String getCommandName();

    String execute(String text);
}
