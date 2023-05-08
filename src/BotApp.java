import sources.ConsoleSource;
import sources.HardcodedSource;
import sources.Source;
import sources.TelegramSource;
import exception.UnknownCommandException;


public class BotApp {
    private static Source source;
    private static CommandHandler commandHandler = CommandHandler.getCommandHandler();

    public static void main(String[] args) {
        getSource(args);
        System.out.println("Bot start with source " + source.getSourceType());
        source.initSource();
        String specifiedCommand = source.getValue();
        while (!"exit".equalsIgnoreCase(specifiedCommand)) {
            System.out.println("Execute text " + specifiedCommand.toUpperCase());
            try {
                System.out.println(commandHandler.handleCommand(specifiedCommand));
            } catch (UnknownCommandException uce) {
                System.out.println("Try to enter new command again");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            specifiedCommand = source.getValue();
        }
        System.out.println("Exiting programm");
    }

    private static void getSource(String[] args) {
        if (args.length == 0) {
            source = new HardcodedSource();
            return;
        }
        String sourceName = args[0];
        switch (sourceName) {
            case "telegram":
                source = new TelegramSource();
                break;
            case "console":
                source = new ConsoleSource();
                break;
            default:
                source = new HardcodedSource();
        }

    }
}
