package com.f.chapter18.reader_;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author fzy
 * @date 2023/7/10 20:18
 * ��ʾFileReader��ʹ�ã��ַ����������ļ� --> ����
 */
public class FileReader_ {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\1\\Code Project\\Java project\\file\\hello.txt";
        FileReader fileReader = null;
        char[] buf = new char[8];
        int readLen = 0;
        try {
            fileReader = new FileReader(filePath);
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.println(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
