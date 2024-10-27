package org.example;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@FieldDefaults(level = AccessLevel.PACKAGE)
public class MorseTranslatorImpl implements MorseTranslator {

    static Map<Character, String> decodeMap;
    static Node<String, Character> root = new Node<>();

    static {
        decodeMap = Map.ofEntries(
                Map.entry('A', ".-"),
                Map.entry('B', "-..."),
                Map.entry('C', "-.-."),
                Map.entry('D', "-.."),
                Map.entry('E', "."),
                Map.entry('F', "..-."),
                Map.entry('G', "--."),
                Map.entry('H', "...."),
                Map.entry('I', ".."),
                Map.entry('J', ".---"),
                Map.entry('K', "-.-"),
                Map.entry('L', ".-.."),
                Map.entry('M', "--"),
                Map.entry('N', "-."),
                Map.entry('O', "---"),
                Map.entry('P', ".--."),
                Map.entry('Q', "--.-"),
                Map.entry('R', ".-."),
                Map.entry('S', "..."),
                Map.entry('T', "-"),
                Map.entry('U', "..-"),
                Map.entry('V', "...-"),
                Map.entry('W', ".--"),
                Map.entry('X', "-..-"),
                Map.entry('Y', "-.--"),
                Map.entry('Z', "--.."),
                Map.entry('0', "-----"),
                Map.entry('1', ".----"),
                Map.entry('2', "..---"),
                Map.entry('3', "...--"),
                Map.entry('4', "....-"),
                Map.entry('5', "....."),
                Map.entry('6', "-...."),
                Map.entry('7', "--..."),
                Map.entry('8', "---.."),
                Map.entry('9', "----.")
        );
        decodeMap.forEach((k, v) -> addLetterCode(v, k));
    }

    private static void addLetterCode(String code, Character letter) {
        var curr = root;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '.') {
                curr.left = null == curr.left ? new Node<>() : curr.left;
                curr = curr.left;
            } else {
                curr.right = null == curr.right ? new Node<>() : curr.right;
                curr = curr.right;
            }
        }
        curr.value = letter;
    }

    /**
     * Расшифровка кода Морзе
     *
     * @param morseCode
     * @return
     */
    @Override
    public String decode(String morseCode) {
        var sb = new StringBuilder();
        var words = morseCode.split(" / ");
        for (String word : words) {
            var chars = word.split(" ");
            for (String code : chars) {
                sb.append(get(code));
            }
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * Шифрование кодом Морзе
     *
     * @param source
     * @return
     */
    @Override
    public String encode(String source) {
        var sb = new StringBuilder();
        var words = source.toUpperCase().split(" ");
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                var code = word.charAt(i);
                sb.append(decodeMap.get(code)).append(" ");
            }
            sb.append("/ ");
        }
        return sb.substring(0, sb.length() - 3);
    }

    private Character get(String code) {
        var curr = root;
        for (int i = 0; i < code.length(); i++) {
            curr = code.charAt(i) == '.' && curr.left != null ? curr.left : curr.right;
        }
        return curr.value;
    }

    @FieldDefaults(level = AccessLevel.PRIVATE)
    static class Node<T, E> {
        E value;
        Node<T, E> left;
        Node<T, E> right;

    }
}
