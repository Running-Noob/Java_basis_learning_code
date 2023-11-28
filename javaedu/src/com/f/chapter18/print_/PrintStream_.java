package com.f.chapter18.print_;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author fzy
 * @date 2023/7/12 16:37
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;
        //��Ĭ������£�PrintStream ������ݵ�λ���Ǳ�׼���������ʾ��
        /*public void print(String s) {
            if (s == null) {
                s = "null";
            }
            write(s);
        }*/
        out.print("hello,world!\n");
        // ��Ϊprint�����õ���write����������Ҳ����ֱ�ӵ���write�����������
        out.write("hi!".getBytes());

        //�����޸Ĵ�ӡ�������λ��, �޸�Ϊ�� hi.txt �ļ���
        /*public static void setOut(PrintStream out) {
            checkIO();
            setOut0(out);   //native�������޸���out
        }*/
        System.setOut(new PrintStream("C:\\Users\\1\\Code Project\\Java project\\file\\hi.txt"));
        System.out.println("hi,txt!");

        out.close();    //�ر���
    }
}
