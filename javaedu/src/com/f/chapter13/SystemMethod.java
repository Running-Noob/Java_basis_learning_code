package com.f.chapter13;

import java.util.Arrays;

/**
 * @author fzy
 * @date 2023/4/27 20:44
 */
public class SystemMethod {
    public static void main(String[] args) {
        //1. exit �˳���ǰ����
        //System.exit(0);     //0 ��ʾһ��״̬��������״̬

        //2. arraycopy ��������Ԫ�أ��Ƚ��ʺϵײ���ã�һ��������Arrays.copyOf�������ĸ���
        /*
         * @param      src      Դ����
         * @param      srcPos   Դ���鿪ʼ������λ��
         * @param      dest     Ŀ������
         * @param      destPos  Ŀ�����鿪ʼճ����λ��
         * @param      length   ������Ԫ�ظ���
         * */
        int[] src = {1, 2, -3, 6, 7};
        int[] dest = new int[src.length + 1];
        System.arraycopy(src, 0, dest, 0, src.length);
        System.out.println(Arrays.toString(dest));  //[1, 2, -3, 6, 7, 0]

        //3.currentTimeMillis ���ص�ǰʱ�����1970-1-1�ĺ�����
        System.out.println(System.currentTimeMillis());
    }
}
