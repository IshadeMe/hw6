package org.example;

/**
 * Код Морзе состоит из символов точка(.) и тире(-).<br/>
 * Разделителем между символами в слове является пробел( )<br/>
 * Разделителем между словами является слэш(/).<br/>
 * <br/>
 * Пример исходного сообщения: 'hello world'<br/>
 * Пример закодированного: '.... . .-.. .-.. --- / .-- --- .-. .-.. -..'<br/>
 * <p>
 * Для кодирования\декодирования можно воспользоваться префиксным деревом (hint.png)<br/>
 * Словарь можно посмотреть в morse.jpg<br/>
 *
 * @see <a href="https://morsecodetranslator.com/">https://morsecodetranslator.com/</a>
 */
public interface MorseTranslator {


    /**
     * Расшифровка кода Морзе
     *
     * @param morseCode
     * @return
     */
    String decode(String morseCode);

    /**
     * Шифрование кодом Морзе
     *
     * @param source
     * @return
     */
    String encode(String source);
}
