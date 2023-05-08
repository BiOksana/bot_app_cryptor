package cryptors;

public class CustomCryptor {

    public String encode(String toCode, String key) {
        return evaluate(toCode, key, new EncodeAction());
    }

    public String decode(String encoded, String key) {
        return evaluate(encoded, key, new DecodeAction());
    }

    private String evaluate(String str, String key, Action action) {
        char[] strArray = str.toCharArray();
        char[] keyArray = key.toCharArray();
        String result = "";
        int keyIter = 0;
        for (int i = 0; i < strArray.length; i++) {
            int strLetter = (int) strArray[i];
            int keyLetter = (int) keyArray[keyIter++];
            if (keyIter > key.length() - 1) {
                keyIter = 0;
            }
            result += (char) action.eval(strLetter, keyLetter);
        }
        return result;
    }

    abstract static class Action {
        abstract char eval(int a, int b);
    }

    public static class EncodeAction extends Action {
        @Override
        char eval(int a, int b) {
            return (char) (a + b);
        }
    }

    public static class DecodeAction extends Action {
        @Override
        char eval(int a, int b) {
            return (char) (a - b);
        }
    }
}
