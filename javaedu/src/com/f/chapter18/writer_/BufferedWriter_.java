package com.f.chapter18.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * @author fzy
 * @date 2023/7/11 15:49
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\1\\Code Project\\Java project\\file\\note.txt";
        BufferedWriter bufferedWriter = null;
        bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));    //append��Ϊtrue��ʾ׷��
        bufferedWriter.write("���ļ���д����һ��...");
        //дһ���зָ����� �зָ����ַ�����ϵͳ����line.separator���壬����һ���ǵ������з���'\n'���ַ���
        bufferedWriter.newLine();
        System.out.println("д��ɹ���");
        bufferedWriter.close(); //�ر���
    }
}
