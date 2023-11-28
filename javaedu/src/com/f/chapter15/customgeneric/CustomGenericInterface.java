package com.f.chapter15.customgeneric;

/**
 * @author fzy
 * @date 2023/6/29 21:09
 */
public class CustomGenericInterface {
    public static void main(String[] args) {
    }
}

//因为IA继承IUsb接口时，指定了T为String类型，R为Double类型，
// 所以在类AA实现IA接口时，就会用String替换T，用Double替换R
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

//在继承接口时确定泛型类型
interface IA extends IUsb<String, Double> {
}

//在实现接口时确定泛型类型
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

    //在jdk8中，可以在接口中使用默认方法，也是可以使用泛型的
    default R method(T t) {
        return null;
    }
}

interface IPhone<E, M> extends IUsb<E, M> {

}