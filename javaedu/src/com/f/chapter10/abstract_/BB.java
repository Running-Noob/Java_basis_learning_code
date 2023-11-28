package com.f.chapter10.abstract_;

public class BB extends Template{
    @Override
    public void job() {
        long sum = 0;

        for (int i = 0; i < 80000; i++) {
            sum *= i;
        }
    }
}