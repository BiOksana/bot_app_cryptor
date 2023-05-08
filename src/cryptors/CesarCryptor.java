package cryptors;

public class CesarCryptor {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public String encode(String toCode, int offset) {
        StringBuilder encodedString = new StringBuilder();
        for (int i = 0; i < toCode.length(); i++) {
            int letterIndex = ALPHABET.indexOf(toCode.charAt(i));
            if (!Character.isLetter(toCode.charAt(i))) {
                encodedString.append(toCode.charAt(i));
                continue;
            }
            int letterIndexWithOffset = letterIndex + offset;

            if (letterIndexWithOffset > ALPHABET.length()) {
                letterIndexWithOffset -= ALPHABET.length();
            }
            encodedString.append(ALPHABET.charAt(letterIndexWithOffset));
        }


        return encodedString.toString();
    }

    public String decode(String encodedString, int offset) {
        StringBuilder decodedString = new StringBuilder();
        for (int i = 0; i < encodedString.length(); i++) {
            int letterIndex = ALPHABET.indexOf(encodedString.charAt(i));
            if (!Character.isLetter(encodedString.charAt(i))) {
                decodedString.append(encodedString.charAt(i));
                continue;
            }
            int letterIndexWithoutOffset = letterIndex - offset;

            if (letterIndexWithoutOffset < 0) {
                letterIndexWithoutOffset += ALPHABET.length();
            }
            decodedString.append(ALPHABET.charAt(letterIndexWithoutOffset));
        }
        return decodedString.toString();
    }
}
