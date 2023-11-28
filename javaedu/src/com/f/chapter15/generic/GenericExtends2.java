package com.f.chapter15.generic;

import java.util.List;

/**
 * @author fzy
 * @date 2023/6/30 14:43
 */
public class GenericExtends2 {
    public static void main(String[] args) {
        P<String> p1 = new P<>();   //T�ᱻ�滻��String
        P<Integer> p2 = new P<>();  //T�ᱻ�滻��Integer
        P<List> p3 = new P<List>(); //T�ᱻ�滻��List
        /*
         * �������� p1.set(p2) ������ô��������Ĳ���Ϊp2����p2ʹ�õķ�������ΪInteger��
         *   ����P���set���������� <> �ڵ�������Կ�����Ҫ�������һ��P��Ķ���
         *   ��ʱ�ٿ� <> �ڲ�����ʾ��������P��Ķ�����ʹ�õķ�������ӦΪList�������࣬
         *   ��p2ʹ�õķ�������ΪInteger�������� <> �ڵ�Ҫ��������������ᱨ��
         * */
        //p1.set(p2); //�����
        p1.set(p3); //��ȷ��
    }
}

class P<T> {
    private T t;

    public T getT() {
        return t;
    }

    //ͨ���
    //����ָ�����͵ķ�Χ��������Χ�ͻᱨ��
    //extends : ָ����Χ��������(������List)����
    public void set(P<? extends List> p) {
        return;
    }

    //super : ָ�����ͱ�������(������List)����
    public void setSuper(P<? super List> p) {
        return;
    }
}