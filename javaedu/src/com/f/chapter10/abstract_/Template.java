package com.f.chapter10.abstract_;

public abstract class Template {
    public void calculateTime() {
        long start = System.currentTimeMillis();
        long sum = 0;
        job();      //�漰����̬�󶨣������ö��󷽷���ʱ�򣬸÷�����͸ö����ڴ��ַ/�������Ͱ󶨣�
        long end = System.currentTimeMillis();
        System.out.println("�����ʱ" + (end - start) + "ms");
    }

    //���Ϊ���� job ������ͬ��ӦΪ���󷽷���ʵ�ʲ������ֲ�Ϊ���󷽷�Ҳ���˴���
    public abstract void job();
}
