package org.example;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeWorkTest {

    HomeWork homeWork = new HomeWork();

    @Test
    void decode() {
        var translator = homeWork.morseTranslator();
        assertEquals("HELLO WORLD", translator.decode(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."));
    }

    @Test
    void encode() {
        var translator = homeWork.morseTranslator();
        assertEquals(".... . .-.. .-.. --- / .-- --- .-. .-.. -..", translator.encode("hello WORLD"));
    }

    @Test
    void decodePangram() {
        var translator = homeWork.morseTranslator();
        assertEquals(
                "Two driven jocks help fax my big quiz 0 123456 789".toUpperCase(Locale.ROOT),
                translator.decode("- .-- --- / -.. .-. .. ...- . -. / .--- --- -.-. -.- ... / .... . .-.. .--. / ..-. .- -..- / -- -.-- / -... .. --. / --.- ..- .. --.. / ----- / .---- ..--- ...-- ....- ..... -.... / --... ---.. ----.")
        );
    }
}