package com.f.chapter12.try_;

public class TryCatchDetail2 {
    public static void main(String[] args) {
        try{
            String s = null;
            System.out.println(s.length());
            int i = 10 / 0;
        }catch(NullPointerException e){
            System.out.println("��ָ���쳣...");
            System.out.println("����ԭ��Ϊ��" + e.getMessage());
        }catch(Exception e){
            System.out.println("�����쳣...");
            System.out.println("����ԭ��Ϊ��" + e.getMessage());
        }finally{
            System.out.println("�����Ƿ����쳣��һ����ִ��......");
        }
        System.out.println("�������ִ��...");
    }
}
