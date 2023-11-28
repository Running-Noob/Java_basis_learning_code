package com.f.chapter10.abstract_;

public class AA extends Template{
    @Override
    public void job() {
        long sum = 0;

        for (int i = 0; i < 800000; i++) {
            sum += i;
        }
    }
}