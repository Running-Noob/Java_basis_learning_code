package com.f.chapter18.writer_;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author fzy
 * @date 2023/7/10 21:09
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\1\\Code Project\\Java project\\file\\note.txt";
        FileWriter fileWriter = null;
        char[] chars = {'h', 'd', 'l', 'g', 'd', 'x', '\n'};
        try {
            fileWriter = new FileWriter(filePath, true);    //append��Ϊtrue����ʾ׷��
            fileWriter.write('F');  //д�뵥���ַ�
            fileWriter.write('\n'); //����
            fileWriter.write(chars);    //д���ַ�����
            fileWriter.write(chars, 0, chars.length);
            fileWriter.write("д����һ��\n");    //д���ַ���
            fileWriter.write("д����һ�е�һ����", 0, 3);    //�� ��д���⡱ д�����ļ�
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileWriter.close(); //����Ҫ�رգ�`close`����ˢ�£�`flush`��������д�벻��ָ�����ļ���
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("�������...");
        }
    }
}
