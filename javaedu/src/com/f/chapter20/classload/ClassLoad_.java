package com.f.chapter20.classload;

/**
 * @author fzy
 * @date 2023/7/25 15:17
 * 类在加载阶段中，连接阶段-准备 的分析
 */
public class ClassLoad_ {
}

class A {
    //n1 是实例属性，不是静态属性，因此在准备阶段是不会分配内存的
    public int n1 = 10;
    //n2 是静态变量，在"连接阶段-准备"时，在方法区中分配内存，n2 默认初始化为 0，在初始化阶段才会赋值为 20
    public static int n2 = 20;
    //N3 是静态常量，因为它一旦赋值就不变了，所以在"连接阶段-准备"时，N3 就直接赋值为 30
    public static final int N3 = 30;
}
