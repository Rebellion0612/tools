package com.fly.tools.util;

import com.fly.tools.annotation.Alias;
import com.fly.tools.constant.Punctuation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author：zhangpengfei
 * @since：2022/3/11
 */
public class HttpUtils {

    private static final String SERIAL = "serialVersionUID";

    /**
     * 构建参数
     *
     * @param obj 参数
     * @return 参数连接的字符串  get形式
     */
    public static String buildHttpGetParam(Object obj) {
        StringBuilder builder = new StringBuilder();
        Map<String, String> keyMap = parseKeyMap(obj);
        keyMap.forEach((k, v) -> {
            builder.append(k).append(Punctuation.EQUALS).append(v).append(Punctuation.AND);
        });
        String result = builder.substring(0, builder.length() - 1);
//        log.info("构建Http请求参数: {}", result);
        return result;
    }

    /**
     * 解析参数
     *
     * @param obj 参数
     * @return map
     */
    public static Map<String, String> parseKeyMap(Object obj) {
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        Map<String, String> fieldMap = new HashMap<>();
        Arrays.stream(fields).forEach(field -> {
            try {
                field.setAccessible(true);
                Alias annotation = field.getAnnotation(Alias.class);
                String key = field.getName();
                if (Objects.nonNull(annotation)) {
                    key = annotation.value();
                }
                if (Objects.nonNull(field.get(obj)) && !SERIAL.equals(key)) {
                    fieldMap.put(key, field.get(obj).toString());
                }
            } catch (Exception e) {
                //错误处理
                e.printStackTrace();
            }
        });
        return fieldMap;
    }
}
