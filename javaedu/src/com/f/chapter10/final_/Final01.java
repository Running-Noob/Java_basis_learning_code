package com.f.chapter10.final_;

public class Final01 {
    public static void main(String[] args) {
        /*
        //�� 3 ���������ʱ������ֵ�����޸�
        E.TAX_RATE = 0.01;
        */
    }
}

final class A {
}

/*
//�� 1 ���������ʱ B ���ܼ̳� A
class B extends A{ }
*/

class C {
    public final void hi() {
    }
}

class D extends C {
/*
    //�� 2 ���������ʱ C �еķ��� hi() ���ܱ���д
    @Override
    public void hi() {}
*/
}

class E {
    public static final double TAX_RATE = 0.08;
}

class F {
    private final int NUM = 1;
    public void hi(){
        /*
        //�� 4 ���������ʱ�þֲ����������޸ģ���ʱ�ñ���Ҳ��Ϊ�ֲ�����
        NUM = 2;
        */
    }
}