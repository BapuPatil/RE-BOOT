package com.example.microservices.limitsservice;

public class LimitsConfiguaration {
    int max;
    int min;

protected LimitsConfiguaration(){}

    public LimitsConfiguaration(int max, int min) {
        this.max = max;
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
