package sources;

public class TelegramSource implements Source {


    @Override
    public String getSourceType() {
        return "Telegram";
    }

    @Override
    public void initSource() {
        System.out.println("Start watching Telegram");
    }

    @Override
    public String getValue() {
        return "exit";
    }
}
