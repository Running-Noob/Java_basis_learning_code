package com.f.chapter18.transformation_;

import java.io.*;

/**
 * @author fzy
 * @date 2023/7/12 15:55
 */
public class InputStreamReader_ {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\1\\Code Project\\Java project\\file\\note.txt";
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            //�� FileInputStream(�ֽ���) ��װ�� InputStreamReader(�ַ���)����ָ���˱���Ϊ gbk
            inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "gbk");
            //�� InputStreamReader ���� BufferedReader�������Ч��
            bufferedReader = new BufferedReader(inputStreamReader);
            ////�����Ե�д��
            //bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "gbk"));
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close(); //�ر�������������
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
