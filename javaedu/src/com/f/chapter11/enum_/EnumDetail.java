package com.f.chapter11.enum_;

public class EnumDetail {
    public static void main(String[] args) {
        IPlayingMusic iPlayingMusic = Music.CLASSIC;
        iPlayingMusic.playingMusic();
    }
}

enum Music implements IPlayingMusic {
    CLASSIC("�ŵ�");
    private String name;

    Music(String name) {
        this.name = name;
    }

    @Override
    public void playingMusic() {
        System.out.println("���ڲ���" + this.name + "����...");
    }
}

interface IPlayingMusic {
    void playingMusic();
}
