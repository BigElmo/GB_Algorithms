package com.bigelmo.algorithms.lesson5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RaiserTest {

    @ParameterizedTest(name = "{0}^{1} = {2}")
    @CsvSource({
            "3, 3, 27",
            "3, 1, 3",
            "3, 0, 1",
            "2, 3, 8",
            "2, 1, 2",
            "2, 0, 1",
            "2, -3, 0.125",
            "2, -1, 0.5"
    })
    void raiseToPower(double number, int power, double expectedResult) {
        Raiser raiser = new Raiser();
        assertEquals(expectedResult, raiser.raiseToPower(number, power),
                () -> number + " в степени " + power + " = " + expectedResult);
    }
}
