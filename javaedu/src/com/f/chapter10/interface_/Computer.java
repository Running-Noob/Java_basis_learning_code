package com.f.chapter10.interface_;

public class Computer {
    public static void work(UsbInterface usbInterface){
        usbInterface.start();
        usbInterface.stop();
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        Camera camera = new Camera();
        work(phone);
        work(camera);
    }
}

interface UsbInterface{
    void start();
    void stop();
}

class Phone implements UsbInterface{
    @Override
    public void start() {
        System.out.println("�ֻ�����usb�ӿ�...");
    }

    @Override
    public void stop() {
        System.out.println("�ֻ��γ�usb�ӿ�...");
    }
}

class Camera implements UsbInterface{
    @Override
    public void start() {
        System.out.println("�������usb�ӿ�...");
    }

    @Override
    public void stop() {
        System.out.println("����γ�usb�ӿ�...");
    }
}