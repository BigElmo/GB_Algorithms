package com.bigelmo.algorithms.lesson5;

//1. Написать программу по возведению числа в степень с помощью рекурсии
public class Raiser {
    public double raiseToPower(double number, int power) {
        if (power == 0) {
            return 1;
        } else if (power > 0) {
            if (power == 1) {
                return number;
            }
            return number * raiseToPower(number, power - 1);
        } else {
            if (power == -1) {
                return 1 / number;
            }
            return (1 / number) * raiseToPower(number, power + 1);
        }
    }
}
