package com.f.chapter10;

public class StaticCodeBlock {
    public static void main(String[] args) {
        /*������Ϊ��
         * "AA�ľ�̬�����..."
         * "BB�ľ�̬�����..."
         * "AA����ͨ�����..."
         * "BB����ͨ�����..."
         * "AA����ͨ�����..."
         * "BB����ͨ�����..."*/
        //BB bb1 = new BB();
        //BB bb2 = new BB();
        CC cc = new CC();
    }
}

class AA {
    //static {
    //    System.out.println("AA�ľ�̬�����...");
    //}
    //
    //{
    //    System.out.println("AA����ͨ�����...");
    //}

    public AA() {
        System.out.println("AA�Ĺ��캯��");
    }

    public static void hi() {

    }
}

class BB extends AA {
    //static {
    //    System.out.println("BB�ľ�̬�����...");
    //}
    //
    //{
    //    System.out.println("BB����ͨ�����...");
    //}

    public BB() {
        System.out.println("BB�Ĺ��캯��");
    }
}

class CC extends BB{
    static {
        System.out.println("CC�ľ�̬�����...");
    }
}