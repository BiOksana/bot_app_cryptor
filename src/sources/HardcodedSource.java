package sources;

public class HardcodedSource implements Source {

    private final String[] sources = {"/cesar encode hallo java 4", "/cesar decode lepps neze 4",
            "/customCryptor encode London is the capital of Great Britain", "/upperCase upperCase london", "exit"};
    private int cursor = 0;

    @Override
    public String getSourceType() {
        return "Hardcoded";
    }

    @Override
    public void initSource() {
        System.out.println("Only hardcode");
    }

    @Override
    public String getValue() {
        System.out.println("Execute command: " + sources[cursor].toUpperCase());
        return sources[cursor++];
    }
}
