package com.f.chapter18.transformation_;

import java.io.*;

/**
 * @author fzy
 * @date 2023/7/12 16:21
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\1\\Code Project\\Java project\\file\\note.txt";
        OutputStreamWriter outputStreamWriter = null;
        String charSet = "gbk";
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
            outputStreamWriter.write("��ã�");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                outputStreamWriter.close();
                System.out.println("���� " + charSet + " ���뷽ʽ�����ļ��ɹ���");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}