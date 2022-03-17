package com.fly.tools;

import com.fly.tools.entity.DoubleLink;
import com.fly.tools.util.JSONFileUtil;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.INACTIVE;
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

    @Test
    public void testDoubleLink() {
        DoubleLink<Integer> doubleLink = new DoubleLink<>();
        doubleLink.append(5);
        doubleLink.append(6);
        doubleLink.append(7);
        doubleLink.append(8);
        doubleLink.exchange(doubleLink.getHead(), doubleLink.getTail());
        System.out.println(doubleLink);
    }
}
