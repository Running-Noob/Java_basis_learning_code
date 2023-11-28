package com.f.chapter15.generic;

/**
 * @author fzy
 * @date 2023/6/24 19:39
 */
public class Generic01 {
    public static void main(String[] args) {
        //���� String ���͸� E���� Person ��������Ϊ E �ĵط������Կ����� String ���
        Person<String> p1 = new Person<String>("hello");
        p1.show();  //class java.lang.String

        //���� Integer ���͸� E���� Person ��������Ϊ E �ĵط������Կ����� Integer ���
        Person<Integer> p2 = new Person<Integer>(10);
        p2.show();  //class java.lang.Integer
    }
}

class Person<E> {   //����� E ���Ƿ���
    //�� E ��ʾ s ���������ͣ��������������ڶ��� Person �����ʱ��ָ���ģ�
    // ���ڱ����ڼ䣬�Ϳ���ȷ�� E ��ʲô����
    E s;

    public Person(E s) {    //E Ҳ�����ǲ�������
        this.s = s;
    }

    public E getS() {   //E Ҳ�����Ƿ�������
        return s;
    }

    public void show(){
        System.out.println(s.getClass());
    }
}
