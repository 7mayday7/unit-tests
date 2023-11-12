package homework3.Tests;

import homework3.NumberParity.CheckNumberParity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNumberParity {

    /* Задание 1/
       Напишите тесты, покрывающие на 100% метод evenOddNumber,
       который проверяет, является ли переданное число четным или нечетным.
    */

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 5})
    public void evenNumberSentForTrue(int n) {
        assertTrue(CheckNumberParity.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 5})
    public void oddNumberSentForFalse(int n) {
        assertFalse(CheckNumberParity.evenOddNumber(n));
    }


    /* Задание 2.
       Разработайте и протестируйте метод numberInInterval,
       который проверяет, попадает ли переданное число в интервал (25;100).
    */


    @ParameterizedTest
    @ValueSource(ints = {30, 90})
    public void numberInIntervalIsTrue(int n) {
        assertTrue(CheckNumberParity.numberInInterval(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 100})
    public void numberInIntervalIsFalse(int n) {
        assertFalse(CheckNumberParity.numberInInterval(n));
    }
}
