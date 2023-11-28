package com.f.chapter15.customgeneric;

/**
 * @author fzy
 * @date 2023/6/29 21:09
 */
public class CustomGenericInterface {
    public static void main(String[] args) {
    }
}

//��ΪIA�̳�IUsb�ӿ�ʱ��ָ����TΪString���ͣ�RΪDouble���ͣ�
// ��������AAʵ��IA�ӿ�ʱ���ͻ���String�滻T����Double�滻R
class AA implements IA {
    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(String s) {

    }

    @Override
    public void run(String s, Double aDouble) {

    }
}

//�ڼ̳нӿ�ʱȷ����������
interface IA extends IUsb<String, Double> {
}

//��ʵ�ֽӿ�ʱȷ����������
class U implements IUsb<Integer, Boolean> {
    @Override
    public Boolean get(Integer integer) {
        return null;
    }

    @Override
    public void hi(Integer integer) {

    }

    @Override
    public void run(Integer integer, Boolean aBoolean) {

    }
}

interface IUsb<T, R> {
    R get(T t);

    void hi(T t);

    void run(T t, R r);

    //��jdk8�У������ڽӿ���ʹ��Ĭ�Ϸ�����Ҳ�ǿ���ʹ�÷��͵�
    default R method(T t) {
        return null;
    }
}

interface IPhone<E, M> extends IUsb<E, M> {

}