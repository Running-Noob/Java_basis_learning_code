package com.f.chapter10.singleMode;

public class SingleTon01 {
    public static void main(String[] args) {
        //ͨ��������ȡ����ʵ��
        A a = A.getaInstance();
    }
}

class A{
    private String name;

    //2. ������ڲ���������
    private static A aInstance = new A("a");

    //1. ������˽�л�����ʱ�� main �����У��Ѿ�����ֱ�� new ������
    private A(String name) {
        this.name = name;
    }

    //3. ���Ⱪ¶һ����̬�Ĺ���������-> getInstance
    public static A getaInstance(){
        return A.aInstance;
    }
}