package com.f.chapter13;

import java.util.Arrays;

/**
 * @author fzy
 * @date 2023/4/27 20:44
 */
public class SystemMethod {
    public static void main(String[] args) {
        //1. exit 退出当前程序
        //System.exit(0);     //0 表示一个状态，正常的状态

        //2. arraycopy 复制数组元素，比较适合底层调用，一般我们用Arrays.copyOf完成数组的复制
        /*
         * @param      src      源数组
         * @param      srcPos   源数组开始拷贝的位置
         * @param      dest     目标数组
         * @param      destPos  目标数组开始粘贴的位置
         * @param      length   拷贝的元素个数
         * */
        int[] src = {1, 2, -3, 6, 7};
        int[] dest = new int[src.length + 1];
        System.arraycopy(src, 0, dest, 0, src.length);
        System.out.println(Arrays.toString(dest));  //[1, 2, -3, 6, 7, 0]

        //3.currentTimeMillis 返回当前时间距离1970-1-1的毫秒数
        System.out.println(System.currentTimeMillis());
    }
}
