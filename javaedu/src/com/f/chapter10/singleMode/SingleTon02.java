package com.f.chapter10.singleMode;

public class SingleTon02 {
    public static void main(String[] args) {
        //ͨ��������ȡ����ʵ��
        AA aa = AA.getaInstance();
        System.out.println(aa);
    }
}

class AA {
    private String name;

    //2. ���ڲ�����һ�� static ��̬���Զ���
    private static AA aaInstance;

    //1. ������˽�л�����ʱ�� main �����У��Ѿ�����ֱ�� new ������
    private AA(String name) {
        System.out.println("������ AA ������...");
        this.name = name;
    }

    //3. ���Ⱪ¶һ����̬�Ĺ���������-> getInstance
    public static AA getaInstance() {
        if (aaInstance == null) {   //�������û�д���
            aaInstance = new AA("aa");
        }
        return aaInstance;
    }
}