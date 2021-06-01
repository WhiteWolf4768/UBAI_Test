package com.developersunknown.ubai.utils;

public class RangeCalculator {
    public static float calculateRange(float minRange, float minValue, float maxRange, float maxValue, float rangeValue) {

        if (rangeValue <= minRange) {
            return minValue;
        } else if (rangeValue >= maxRange) {
            return maxValue;
        } else {
            float range = maxRange - minRange;
            float correctedStartValue = rangeValue - minRange;
            float percentage = ((correctedStartValue * 100) / range) / 100;

            if (minValue > maxValue) {
                percentage = 1 - percentage;
            }

            return percentage;
        }
    }
}
