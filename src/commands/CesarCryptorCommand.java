package commands;

import cryptors.CesarCryptor;

public class CesarCryptorCommand extends AbstractCryptorCommand {

    private final CesarCryptor cesarCryptor = new CesarCryptor();

    @Override
    public String getCommandName() {
        return "Cesar";
    }

    @Override
    String encrypt(String text) {
        return cesarCryptor.encode(text.substring(0, text.lastIndexOf(" ")),
                Integer.parseInt(text.substring(text.lastIndexOf(" ") + 1)));
    }

    @Override
    String decrypt(String text) {
        return cesarCryptor.decode(text.substring(0, text.lastIndexOf(" ")),
                Integer.parseInt(text.substring(text.lastIndexOf(" ") + 1)));
    }
}
