package commands;

import cryptors.CustomCryptor;

public class CustomCryptorCommand extends AbstractCryptorCommand {

    private final CustomCryptor customCryptor = new CustomCryptor();

    @Override
    public String getCommandName() {
        return "CustomCryptor";
    }

    @Override
    String encrypt(String text) {
        return customCryptor.encode(text.substring(0, text.lastIndexOf(" ")),
                text.substring(text.lastIndexOf(" ") + 1));
    }

    @Override
    String decrypt(String text) {
        return customCryptor.decode(text.substring(0, text.lastIndexOf(" ")),
                text.substring(text.lastIndexOf(" ") + 1));
    }
}
