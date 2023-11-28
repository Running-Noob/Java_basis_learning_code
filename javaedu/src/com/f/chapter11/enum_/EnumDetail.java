package com.f.chapter11.enum_;

public class EnumDetail {
    public static void main(String[] args) {
        IPlayingMusic iPlayingMusic = Music.CLASSIC;
        iPlayingMusic.playingMusic();
    }
}

enum Music implements IPlayingMusic {
    CLASSIC("π≈µ‰");
    private String name;

    Music(String name) {
        this.name = name;
    }

    @Override
    public void playingMusic() {
        System.out.println("’˝‘⁄≤•∑≈" + this.name + "“Ù¿÷...");
    }
}

interface IPlayingMusic {
    void playingMusic();
}
