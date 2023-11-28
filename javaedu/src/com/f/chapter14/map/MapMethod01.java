package com.f.chapter14.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fzy
 * @date 2023/6/22 9:39
 */
public class MapMethod01 {
    public static void main(String[] args) {
        Map map = new HashMap();

        //1.`put(K key, V value)`：向 `map` 中添加一对 `k-v` ，如果键 `key` 重复，则会对 `value` 进行覆盖替换。
        map.put("num1", "三国演义");
        map.put("num2", "石头记");
        map.put("num2", "红楼梦"); //“红楼梦”替换了“石头记”
        map.put("num3", "水浒传");
        map.put("num4", "西游记");
        map.put(null, "四大名著");
        System.out.println(map);    //{null=四大名著, num1=三国演义, num4=西游记, num3=水浒传, num2=红楼梦} -> 注意是无序的

        //2.`remove(Object key)`：根据键删除映射关系。
        map.remove(null);
        System.out.println(map);    //{num1=三国演义, num4=西游记, num3=水浒传, num2=红楼梦}

        //3.`get(Object key)`：根据键获取值。
        System.out.println(map.get("num2"));    //红楼梦

        //4.`size()`：获取 `k-v` 对的个数。
        System.out.println(map.size());     //4

        //5.`isEmpty()`：判断 `map` 是否为空。
        System.out.println(map.isEmpty());  //false

        //6.`clear()`：清空 `map`。
        map.clear();
        System.out.println(map);    //{}

        //7.`containsKey(Object key)`：查找键是否存在。
        System.out.println(map.containsKey(null));  //false
    }
}
