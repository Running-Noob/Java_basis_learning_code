package com.f.chapter10.interface_;

public class InterfacePolyPass {
    public static void main(String[] args) {
        //�ӿ����͵ı�������ָ�� ʵ���˸ýӿڵ��� �Ķ���ʵ��
        IB ib = new Teacher();
        //����ӿ� IB �̳��� IA����ô IA �ı���Ҳ����ָ�� ʵ���˽ӿ�IB���� �Ķ���ʵ��
        //�༴��ʵ���Ͼ��൱�� Teacher ��ҲҪʵ�� IA �ӿ�
        IA ia = new Teacher();
    }
}

interface IA {}
interface IB extends IA {}
class Teacher implements IB {}