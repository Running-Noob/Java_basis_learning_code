package com.f.chapter18.outputstream_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author fzy
 * @date 2023/7/11 20:57
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) {
        //���л��󣬱�����ļ���ʽ���Ǵ��ı��ģ����ǰ������ĸ�ʽ�������
        String filePath = "C:\\Users\\1\\Code Project\\Java project\\file\\data.dat";
        ObjectOutputStream objectOutputStream = null;
        try {
            //ObjectOutputStream�Ǵ�����
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

            //���л����ݵ��ļ���
            objectOutputStream.writeInt(100);  //int --�Զ�װ��--> Integer��Integerʵ���� Serializable �ӿ�
            objectOutputStream.writeBoolean(true);  //ԭ��ͬ�� boolean -> Boolean
            objectOutputStream.writeChar('a');  //ԭ��ͬ�� char -> Character
            objectOutputStream.writeDouble(1.1);    //ԭ��ͬ�� double -> Double
            objectOutputStream.writeUTF("Java");    //д���ַ������� writeUTF
            objectOutputStream.writeObject(new Dog("С��", 3));   //д��Dog����
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectOutputStream.close();
                System.out.println("���ݱ�����ɣ����л���ʽ��");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
