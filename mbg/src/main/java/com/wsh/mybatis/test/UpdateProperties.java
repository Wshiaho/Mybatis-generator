package com.wsh.mybatis.test;


import java.io.*;
import java.util.Properties;

public class UpdateProperties {
    //属性文件的路径
    //String profilepath= Thread.currentThread().getContextClassLoader().getResource("jdbc.properties").getPath();
    String profilepath= this.getClass().getClassLoader().getResource("jdbc.properties").getPath();
    /**
     * 采用静态方法
     */
    private Properties props = new Properties();
    /**
     * 更新（或插入）一对properties信息(主键及其键值)
     * 如果该主键已经存在，更新该主键的值；
     * 如果该主键不存在，则插件一对键值。
     * @param keyname 键名
     * @param keyvalue 键值
     */
    public int writeProperties(String keyname, String keyvalue) {
        try {
            System.out.println(profilepath+"fdsafdsafdsa");
            props.load(new FileInputStream(profilepath));
            // 调用 Hashtable 的方法 put，使用 getProperty 方法提供并行性。
            // 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            OutputStream fos = new FileOutputStream(profilepath);
            props.setProperty(keyname, keyvalue);
            // 以适合使用 load 方法加载到 Properties 表中的格式，
            // 将此 Properties 表中的属性列表（键和元素对）写入输出流
            props.store(fos, "Update '" + keyname + "' value");
            return 1;
        } catch (IOException e) {
            System.err.println("属性文件更新错误");
            return 0;
        }
    }
}
