package com.f.chapter18.inputstream_;

//Ϊ���÷����л����Dog��Ķ����ܵ���Dog��ķ�����������Ҫ�������ø�Dog��
import com.f.chapter18.outputstream_.Dog;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author fzy
 * @date 2023/7/11 20:51
 */
public class ObjectInputStream_ {
    public static void main(String[] args) {
        //ָ�������л����ļ�
        String filePath = "C:\\Users\\1\\Code Project\\Java project\\file\\data.dat";
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

            //ע�⣺��ȡ(�����л�)��˳����Ҫ���㱣������(���л�)��˳��һ��
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readBoolean());
            System.out.println(objectInputStream.readChar());
            System.out.println(objectInputStream.readDouble());
            System.out.println(objectInputStream.readUTF());
            Object obj = null;
            try {
                obj = objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println(obj + " ����������Ϊ " + obj.getClass());
            Dog dog = (Dog) obj;
            System.out.println(dog.getName());  //����Dog���getName����
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectInputStream.close();
                System.out.println("��ȡ�ɹ���");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}