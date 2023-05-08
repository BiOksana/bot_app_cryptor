package sources;

import java.util.Scanner;

public class ConsoleSource implements Source {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getSourceType() {
        return "Console";
    }

    @Override
    public void initSource() {
        System.out.println("Enter command: ");
    }

    @Override
    public String getValue() {
        return scanner.nextLine();
    }
}
