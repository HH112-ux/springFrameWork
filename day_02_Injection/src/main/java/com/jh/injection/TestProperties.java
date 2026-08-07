package com.jh.injection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) throws IOException {
        Properties properties =new Properties();
        properties.load(new FileInputStream("D:\\idea_workspace\\springFramework\\day_02_Injection\\src\\main\\resources\\test.properties"));
        String kkk = properties.getProperty("kkk");
        System.out.println(kkk);
    }
}
