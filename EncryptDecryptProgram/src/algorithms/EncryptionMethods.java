package algorithms;

public class EncryptionMethods {
    private static final String asciiCharacters = "' '!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
    private static final String alphabetLetters = "abcdefghijklmnopqrstuvwxyz";

    public static String rot1Encrypt(String text) {
        StringBuilder codedString = new StringBuilder();
        int character;

        for (int i = 0; i < text.length(); i++) {
            //if the alphabet contains the char in the user's message.
            if (alphabetLetters.contains(text.substring(i, i + 1))) {
                //find the location of the char of the user's text inside the alphabet.
                character = alphabetLetters.indexOf(text.substring(i, i + 1));
                if (character == 25) {
                    codedString.append("a");
                } else {
                    //add the char one place to the right.
                    codedString.append(alphabetLetters.charAt(character + 1));
                }
            } else {
                //add the current char from the user's message.
                codedString.append(text.charAt(i));
            }
        }
        //System.out.println(codedString);
        return codedString.toString();
    }

    public static String rot1Decrypt(String text) {
        StringBuilder decodedString = new StringBuilder();
        int letter;
        for (int i = 0; i < text.length(); i++) {
            //if the alphabet contains the char in the user's message.
            if (alphabetLetters.contains(text.substring(i, i + 1))) {
                //find the location of the char of the user's text inside the alphabet.
                letter = alphabetLetters.indexOf(text.substring(i, i + 1));
                {
                    //add the char one place to the left.
                    decodedString.append(alphabetLetters.charAt(letter - 1));
                }
            } else {
                //add the current char from alphabet.
                decodedString.append(text.charAt(i));
            }
        }
        //System.out.println(decodedString);
        return decodedString.toString();

    }

    public static String rot13(String text) {
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'm') {
                c += 13;
            } else if (c >= 'A' && c <= 'M') {
                c += 13;
            } else if (c >= 'n' && c <= 'z') {
                c -= 13;
            } else if (c >= 'N' && c <= 'Z') {
                c -= 13;
            }
            message.append(c);
        }
        return message.toString();
    }

    public static String caesarCipherEncryptMethod(String text) {
        StringBuilder encryptedText = new StringBuilder();
        int charPosition;
        int shiftVal = 3;
        int shiftedPosition;

        for (int i = 0; i < text.length(); i++) {
            charPosition = asciiCharacters.indexOf(text.charAt(i));
            shiftedPosition = charPosition + shiftVal;
            char replaceVal = asciiCharacters.charAt(shiftedPosition);

            encryptedText.append(replaceVal);
        }
        return encryptedText.toString();
    }

    public static String caesarCipherDecryptMethod(String text) {
        int charPosition;
        int shiftVal = 3;
        int keyValue;
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            charPosition = asciiCharacters.indexOf(text.charAt(i));
            keyValue = (charPosition - shiftVal) % 95;
            if (keyValue < 0) {
                keyValue = asciiCharacters.length() + keyValue;
            }

            char replaceVal = asciiCharacters.charAt(keyValue);
            decryptedMessage.append(replaceVal);
        }
        return decryptedMessage.toString();
    }
}

