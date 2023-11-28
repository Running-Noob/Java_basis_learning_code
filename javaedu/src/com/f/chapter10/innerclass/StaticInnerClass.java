package com.f.chapter10.innerclass;

public class StaticInnerClass {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.hi();

        //�ⲿ��������ʾ�̬�ڲ���ĳ�Ա�����ַ�ʽ:
        //��һ�ַ�ʽ��new Outer.Inner()����Ϊ�Ǿ�̬�ڲ��࣬���Կ���ֱ���� Outer.Inner
        Outer.Inner inner01 = new Outer.Inner();
        inner01.say();

        //�ڶ��ַ�ʽ�����ⲿ���У���дһ������������Inner����ʵ��
        Outer.Inner inner02 = new Outer().getInnerInstance();
        inner02.say();
    }
}

class Outer {
    private int n1 = 10;
    private static String name = "����";

    public static class Inner {
        private String name = "����";

        public void say() {
            System.out.println("��̬�ڲ���ķǾ�̬����name��ֵΪ��" + name);
            System.out.println("�ⲿ��ľ�̬����name��ֵΪ��" + Outer.name);
            System.out.println("=====================================");
            //����ֱ�ӷ����ⲿ��ķǾ�̬��Ա
            //System.out.println(n1); //�޷�����
        }
    }

    public void hi() {
        System.out.print("������Outer��hi����...\t");
        Inner inner = new Inner();
        inner.say();
    }

    public Inner getInnerInstance() {
        return new Inner();
    }
}
