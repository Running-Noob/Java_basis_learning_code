package com.f.chapter18.file;

import java.io.File;

/**
 * @author fzy
 * @date 2023/7/8 12:55
 */
public class Directoty_ {
    public static void main(String[] args) {
        String dirPath = "C:\\Users\\1\\Desktop\\java\\file2";
        File dir = new File(dirPath);
        if (dir.exists()) {
            System.out.println(dirPath + " �Ѵ��ڣ�׼��ɾ��");
            //ɾ����Ŀ¼
            if (dir.delete()) {
                System.out.println(dirPath + " ɾ���ɹ�");
            } else {
                System.out.println(dirPath + " ɾ��ʧ��");
            }
        } else {
            if (dir.mkdirs()) {     //�����༶Ŀ¼��mkdirs()
                System.out.println(dir + " �����ɹ�");
            } else {
                System.out.println(dir + " ����ʧ��");
            }
        }
    }
}
