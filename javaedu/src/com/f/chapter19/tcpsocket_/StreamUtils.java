package com.f.chapter19.tcpsocket_;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author fzy
 * @date 2023/7/15 14:20
 */
public class StreamUtils {
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = is.read(buf)) != -1) {
            bos.write(buf, 0, readLen); //�Ѷ�ȡ��������д��bos
        }
        byte[] bytes = bos.toByteArray();   //��bos�е�����ת��Ϊ�ֽ�����
        bos.close();
        return bytes;
    }
}
