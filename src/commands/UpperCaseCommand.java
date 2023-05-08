package commands;


import cryptors.ConvertStringToUpperlCase;

public class UpperCaseCommand implements AbstractCommand {

    private static final ConvertStringToUpperlCase toUpperCase = new ConvertStringToUpperlCase();

    @Override
    public String getCommandName() {
        return "UpperCase";
    }

    @Override
    public String execute(String text) {
        if (text.startsWith("upperCase")) {
            return toUpperCase.convertStringToUpperCase(text.replace("upperCase ", ""));
        }
        return "I don't know, what I must to do";
    }
}
