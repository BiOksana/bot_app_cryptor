package commands;

public abstract class AbstractCryptorCommand implements AbstractCommand{
    public String execute(String text) {
        if ("encode".equalsIgnoreCase(text.substring(0, text.indexOf(" ")))) {
            text = text.replace("encode ", "");
            return encrypt(text);
        }
        if ("decode".equalsIgnoreCase(text.substring(0, text.indexOf(" ")))) {
            text = text.replace("decode ", "");
            return decrypt(text);
        }
        return "Cryptor doesn't know this command";
    }

    abstract String encrypt(String text);
    abstract String decrypt(String text);
}
