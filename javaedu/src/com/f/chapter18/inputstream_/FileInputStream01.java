package com.f.chapter18.inputstream_;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author fzy
 * @date 2023/7/8 13:47
 * 演示FileInputStream的使用（字节输入流：文件 --> 程序）
 */
public class FileInputStream01 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\1\\Desktop\\java\\file\\hello.txt";
        int readContent = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取文件内容
            fileInputStream = new FileInputStream(filePath);
            //从 fileInputStream 读取一个字节的数据，如果未达到文件的末尾，则不停地读取
            //如果 read 方法返回 -1，则表示读取完毕
            //单个字节的读取，效率较低
            while ((readContent = fileInputStream.read()) != -1) {
                System.out.print((char) readContent);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //在 finally 里关闭流，避免资源的浪费
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
