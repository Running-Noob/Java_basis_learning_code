package com.f.chapter18.reader_;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author fzy
 * @date 2023/7/11 15:26
 * ʹ�� `BufferedReader` ��ȡ�ı��ļ�������ʾ�ڿ���̨��
 */
public class BufferedReader_ {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\1\\Code Project\\Java project\\javaedu\\src\\com\\f\\chapter10\\TestMainParam.java";
        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(new FileReader(filePath));
        String line = null;
        int cnt = 1;
        //bufferedReader.readLine() �ǰ��ж�ȡ�ļ��������� null ʱ����ʾ�ļ���ȡ��ϡ�
        while ((line = bufferedReader.readLine()) != null) {
            System.out.print("��ȡ��" + (cnt++) + "�У�");
            System.out.println(line);
        }

        //��Ҫ���ǹر�����ֻ��Ҫ�ر���������ɣ���Ϊ�ײ��ȥ�Զ��رսڵ���
        bufferedReader.close();
    }
}