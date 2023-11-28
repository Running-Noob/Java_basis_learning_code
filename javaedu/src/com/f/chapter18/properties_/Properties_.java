package com.f.chapter18.properties_;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @author fzy
 * @date 2023/7/12 20:03
 */
public class Properties_ {
    public static void main(String[] args) {
        //使用 Properties 类来读取 mysql.peoperties 文件
        String filePath = "C:\\Users\\1\\Code Project\\Java project\\file\\jdbc.properties";
        Properties properties = new Properties();
        try {
            //1.`load`：加载配置文件的键值对到 `Properties` 对象。
            properties.load(new FileReader(filePath));
            //2.`list`：将数据显示到指定设备 / 流对象。
            properties.list(System.out);
            //3.`getProperty(key)`：根据键获取值。
            System.out.println("用户名 = " + properties.getProperty("user"));
            System.out.println("密码 = " + properties.getProperty("pwd"));
            //4.`setProperty(key, value)`：设置键值对到 `Properties` 对象。
            properties.setProperty("charset", "utf-8");
            //5.`store`：将 `Properties` 中的键值对存储到配置文件，在 `idea` 中，保存信息到配置文件，如果含有中文，会存储为 `unicode` 码。
            properties.store(new FileWriter(filePath), "This is a comment.");
            System.out.println("保存配置文件成功！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}