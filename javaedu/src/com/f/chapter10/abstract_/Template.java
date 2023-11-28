package com.f.chapter10.abstract_;

public abstract class Template {
    public void calculateTime() {
        long start = System.currentTimeMillis();
        long sum = 0;
        job();      //涉及到动态绑定：当调用对象方法的时候，该方法会和该对象内存地址/运行类型绑定；
        long end = System.currentTimeMillis();
        System.out.println("任务耗时" + (end - start) + "ms");
    }

    //这里，为了让 job 各不相同，应为抽象方法。实际操作发现不为抽象方法也无伤大雅
    public abstract void job();
}
