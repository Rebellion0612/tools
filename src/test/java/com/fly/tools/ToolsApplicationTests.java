package com.fly.tools;

import com.fly.tools.util.JSONFileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ToolsApplicationTests {
    private static String basePath = "D:\\GitRepository\\json\\";

    public static void main(String[] args) {
        parseJson();
    }

    @Test
    void contextLoads() {
    }


    @Test
    public static void parseJson() {
        List<Long> list = JSONFileUtil.parseJson(basePath.concat("s1.json"), "dataList", Long.class, "id");
        System.out.println(list);
    }
}
