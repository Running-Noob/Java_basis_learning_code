package com.f.chapter12.try_;

public class TryCatchDetail {
    public static void main(String[] args) {
        try {
            //��ctrl+alt+t��ݼ��������try-catch��
            String s = "com";
            int num = Integer.parseInt(s);
            //����쳣�����ˣ����쳣��������Ĵ��벻��ִ�У�ֱ�ӽ��뵽catch��
            System.out.println("���� = " + num);
        } catch (NumberFormatException e) {
            System.out.println("�쳣��Ϣ��" + e.getMessage());
        }
        System.out.println("�������ִ��...");
    }
}
